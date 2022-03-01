package com.example.studyproject.custom;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

import com.example.studyproject.R;

public class MultiTouchImageView extends AppCompatImageView {
    private ImageView cancel;
    private float startDis;
    private PointF midPoint;//中点
    private float oldRotation=0;//旋转前
    private float rotation=0;//旋转后
    private PointF startPoint=new PointF();//开始点
    private Matrix matrix=new Matrix();
    private Matrix currentMatrix=new Matrix();
    private Activity mActivity;
    private boolean is_Editable=true;
    private int width;
    private int height;
    float matrixX,matrixY;//矩阵的X点Y点;
    float saveScale=1f;
    float minScale=1f;
    float maxScale=3f;
    float redundantXSpace,redundantYSpace;
    float right,bottom,origWidth,origHeight,bmWidth,bmHeight;
    float[] m;
    public MultiTouchImageView(@NonNull Context context) {
        super(context);
    }

    public MultiTouchImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    public MultiTouchImageView(@NonNull Context context, @Nullable AttributeSet attrs,int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View inflate = LayoutInflater.from(context).inflate(R.layout.lay_multi_image,null);
        cancel = inflate.findViewById(R.id.cancel);
    }
    private enum MODE{
        NONE,DRAG,ZOOM //三种模式
    }
    private MODE mode=MODE.NONE;

    public void setmActivity(Activity mActivity) {
        this.mActivity = mActivity;
    }

    public boolean isIs_Editable() {
        return is_Editable;
    }

    public void setIs_Editable(boolean is_Editable) {
        this.is_Editable = is_Editable;
    }
    public static float distance(MotionEvent event)
    {
        float dx=event.getX(1)-event.getX(0);//滑动的距离
        float dy=event.getY(1)-event.getY(0);
        return (float)Math.sqrt(dx*dx+dy*dy);
    }
    public static PointF mid(MotionEvent event)//中点
    {
        float midX=(event.getX(1)+event.getX(0))/2;
        float midY=(event.getY(1)+event.getY(0))/2;
        return new PointF(midX,midY);
    }
    private float rotation(MotionEvent event)
    {
        double delta_x=(event.getX(0)-event.getX(1));
        double delta_y=(event.getY(0)-event.getY(1));
        double radians=Math.atan2(delta_y,delta_x);//计算角度
        return (float)Math.toDegrees(radians);
    }
    private int lastX,lastY;
    public boolean onTouchEvent(MotionEvent event)
    {
        if (is_Editable==true)
        {
            switch (event.getAction()&MotionEvent.ACTION_MASK)
            {
                case MotionEvent.ACTION_DOWN://手指按下屏幕
                    mode=MODE.DRAG;
                    currentMatrix.set(this.getImageMatrix());//记录imageview当前的矩阵
                    matrix.set(currentMatrix);//设置matrix为当前矩阵
                    startPoint.set(event.getX(),event.getY());//起始点坐标
                    postInvalidate();
                    lastX= (int) event.getRawX();//距离屏幕左边界位置,getX和getY是距离自身
                    lastY= (int) event.getRawY();//距离屏幕上边界位置
                    break;
                case MotionEvent.ACTION_POINTER_DOWN://当屏幕上还有触点（手指），再有一个手指压下时
                    mode=MODE.ZOOM;//设置模式为移动
                    oldRotation=rotation(event);//保存滑动前的角度;
                    startDis=distance(event);//保存滑动前的距离;
                    if (startDis>10f)//如果华东前距离大于10f则获取中点
                    {
                        midPoint=mid(event);
                        currentMatrix.set(this.getImageMatrix());//设置当前的矩阵
                    }
                    break;
                case MotionEvent.ACTION_MOVE://手指在屏幕移动，事件会不断地触发
                    if (mode==MODE.DRAG)//拖动
                    {
                        float dx=event.getX()-startPoint.x;//得到在x轴上的移动距离
                        float dy=event.getY()-startPoint.y;//得到在y轴上的移动距离
                        matrix.set(currentMatrix);
                        matrix.postTranslate(dx,dy);//设置平移距离
                    }
                    else if (mode==MODE.ZOOM)//缩放与旋转
                    {
                        float enDis=distance(event);//结束的距离
                        rotation=(rotation(event)-oldRotation);//角度
                        if (enDis>10f)
                        {
                            float scale=enDis/startDis;//得到缩放倍数
                            matrix.set(currentMatrix);//先设置原先的矩阵，后再设置改变的地方
                            matrix.postScale(scale,scale,midPoint.x,midPoint.y);
                            matrix.postRotate(rotation,midPoint.x,midPoint.y);
                        }
                    }
                    break;
                case MotionEvent.ACTION_UP://手指离开
                    //设置不能出界
                    int dx= (int) event.getRawX()-lastX;
                    int dy= (int) event.getRawY()-lastY;
                    int left=this.getLeft()+dx;
                    int top=this.getTop()+dy;
                    int right=this.getRight()+dx;
                    if (left<0)
                    {
                        left=0;
                        right=left+this.getWidth();//如果超出，则设为fill_parent;
                    }
                    if (right>width)
                    {
                        right=(int)width;
                        left=right-this.getWidth();
                    }
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    mode=MODE.NONE;
                    break;
            }
            this.setImageMatrix(matrix);
        }
        return true;

    }
    private void calcPadding()
    {
        right = width * saveScale - width - (2 * redundantXSpace * saveScale);
        bottom = height * saveScale - height - (2 * redundantYSpace * saveScale);
    }
    private void fillMatrixXY() {
        matrix.getValues(m);
        matrixX = m[Matrix.MTRANS_X];
        matrixY = m[Matrix.MTRANS_Y];
    }

    private void scaleMatrixToBounds() {
        if (Math.abs(matrixX + right / 2) > 0.5f)
            matrix.postTranslate(-(matrixX + right / 2), 0);
        if (Math.abs(matrixY + bottom / 2) > 0.5f)
            matrix.postTranslate(0, -(matrixY + bottom / 2));
    }

    public Bitmap getImageBitmap() {
        // ImageView对象必须做如下设置后，才能获取其中的图像
        setDrawingCacheEnabled(true);
        // 获取ImageView中的图像
        Bitmap obmp = Bitmap.createBitmap(getDrawingCache());
        // 从ImaggeView对象中获取图像后，要记得调用setDrawingCacheEnabled(false)清空画图�?
        // 冲区，否则，下一次用getDrawingCache()方法回去图像时，还是原来的图�?
        setDrawingCacheEnabled(false);
        return obmp;
    }
}
