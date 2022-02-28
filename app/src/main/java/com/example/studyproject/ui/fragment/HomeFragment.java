package com.example.studyproject.ui.fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import com.example.studyproject.Bean.SmallPic;
import com.example.studyproject.MainActivity;
import com.example.studyproject.R;
import com.example.studyproject.adapter.HorListview_Adapter;
import com.example.studyproject.custom.HorizontalListView;
import com.example.studyproject.custom.MultiTouchImageView;
import com.example.studyproject.tools.Click;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.transform.Result;


/**
 * @ClassName HomeFragment
 * @Author 孙培翔
 * @date 2022.02.25 15:49
 */
public class HomeFragment extends Fragment {
    private ImageView ivChange;
    private RelativeLayout relative;
    private HorizontalListView horListview;
    private ImageButton btBj;
    private ImageButton btPj;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private TextView tv6;
    private ArrayList<TextView> tvs = new ArrayList<>();
    private ArrayList<SmallPic> smallPics;
    private TextView tv0; private Uri uri;
    private Context context=getContext();
    private DisplayMetrics displayMetrics = new DisplayMetrics();
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        binding.tv1.setText("");
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_fragment, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        setTV();
        setHorAdapter(addIma_GQ());
        Log.d(TAG, "onViewCreated: "+addIma_GQ().size());
    }
    private class zp implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.bt_bj:
                    startDialog(0);
                    break;
                case R.id.bt_pj:
                    startDialog(1);
                    break;
            }
        }
    }

    private void startDialog(int a) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        builder.setTitle("请选择")
                .setNegativeButton("相册", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        UseAlbum(a);
                    }
                }).setPositiveButton("相机", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                UseCamera(a);
            }
        }).show();
    }
    public void UseAlbum(int a)
    {
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)//判断是否有这个权限
        {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2);
        } else {
            openAlbum(a);
        }
    }



    public void UseCamera(int a)
    {
        File file = new File(getActivity().getExternalCacheDir(), "test.jpg");//file(获取外部缓存目录.)
        try {
            if (file.exists()) {//如果路径存在,则删除file创建新file
                file.delete();
            }
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (Build.VERSION.SDK_INT >= 24) {//当SDK大于24时,
            uri = FileProvider.getUriForFile(context, "com.wocus.wined.fileprovider", file);//
        } else {
            uri = Uri.fromFile(file);
        }
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        Log.d(TAG, "UseCamera: "+intent.toString());
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        if (a==0)
        {
            startActivityForResult(intent, 1);
        }
        else if (a==1)
        {
            startActivityForResult(intent, 2);
        }
    }
    private void openAlbum(int a) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        if (a==1)
        {
        startActivityForResult(intent, 3);
        }
        else if (a==0)
        {
            startActivityForResult(intent, 4);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == getActivity().RESULT_OK) {
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getActivity().getContentResolver().openInputStream(uri));
                        ivChange.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 2:
                if (resultCode == getActivity().RESULT_OK) {
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getActivity().getContentResolver().openInputStream(uri));
                        AddIma2(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 3:
                if (resultCode == getActivity().RESULT_OK) {
                    if (Build.VERSION.SDK_INT >= 19) {
                        handeImage(data,3);
                    } else {
                        handleImageBefor(data,3);
                    }
                }
                break;
            case 4:
                if (resultCode == getActivity().RESULT_OK) {
                    if (Build.VERSION.SDK_INT >= 19) {
                        handeImage(data,4);
                    } else {
                        handleImageBefor(data,4);
                    }
                }
                break;
        }
    }
    private void handeImage(Intent data,int a) {
        String imagePath = null;
        Uri uri2 = data.getData();
        if (DocumentsContract.isDocumentUri(getActivity(), uri2)) {
            String docid = DocumentsContract.getDocumentId(uri2);
            if ("com.android.providers.media.documents".equals(uri2.getAuthority())) {
                String id = docid.split(":")[1];
                String selection = MediaStore.Images.Media._ID + "=" + id;
                imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, selection);
            } else if ("com.android.providers.downloads.documents".equals(uri2.getAuthority())) {
                Uri contenUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(docid));
                imagePath = getImagePath(contenUri, null);
            }
        } else if ("content".equalsIgnoreCase(uri2.getScheme())) {
            imagePath = getImagePath(uri2, null);
        } else if ("file".equalsIgnoreCase(uri2.getScheme())) {
            imagePath = uri2.getPath();
        }
        if (a==3)
        {
        AddIma(imagePath);
        }
        else if (a==4)
        {
            AddIma3(imagePath);
        }
    }

    private void handleImageBefor(Intent data,int a) {
        Uri uri = data.getData();
        String imagePath = getImagePath(uri, null);
        if (a==3)
        {
            AddIma(imagePath);
        }
        else if (a==4)
        {
            AddIma3(imagePath);
        }
    }
    public void AddIma(String path) {
        MultiTouchImageView mtiv = new MultiTouchImageView(getActivity());
        mtiv.setScaleType(ImageView.ScaleType.MATRIX);
        mtiv.setLayoutParams(relative.getLayoutParams());
        Bitmap bitmap = BitmapFactory.decodeFile(path);
        int src_w = bitmap.getWidth();
        int src_h = bitmap.getHeight();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int new_w = (int) (displayMetrics.widthPixels * 0.8);
        int new_h = (int) (displayMetrics.heightPixels * 0.8);
        float scale_w = (((float) new_w / src_w));
        float scale_h = (((float) new_h / src_h));
        Matrix matrix = new Matrix();
        matrix.postScale(scale_w, scale_h);
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap, 0, 0, src_w, src_h, matrix, true);
        mtiv.setImageBitmap(bitmap1);
        relative.addView(mtiv);
    }
    public void AddIma2(Bitmap bitmap) {
        MultiTouchImageView mtiv = new MultiTouchImageView(getActivity());
        mtiv.setScaleType(ImageView.ScaleType.MATRIX);
        mtiv.setLayoutParams(relative.getLayoutParams());
        int src_w = bitmap.getWidth();
        int src_h = bitmap.getHeight();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int new_w = (int) (displayMetrics.widthPixels * 0.8);
        int new_h = (int) (displayMetrics.heightPixels * 0.8);
        float scale_w = (((float) new_w / src_w));
        float scale_h = (((float) new_h / src_h));
        Matrix matrix = new Matrix();
        matrix.postScale(scale_w, scale_h);
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap, 0, 0, src_w, src_h, matrix, true);
        mtiv.setImageBitmap(bitmap1);
        relative.addView(mtiv);
    }
    public void AddIma3(String path) {
        MultiTouchImageView mtiv = new MultiTouchImageView(getActivity());
        mtiv.setScaleType(ImageView.ScaleType.MATRIX);
        mtiv.setLayoutParams(relative.getLayoutParams());
        Bitmap bitmap = BitmapFactory.decodeFile(path);
        int src_w = bitmap.getWidth();
        int src_h = bitmap.getHeight();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int new_w = (int) (displayMetrics.widthPixels * 0.8);
        int new_h = (int) (displayMetrics.heightPixels * 0.8);
        float scale_w = (((float) new_w / src_w));
        float scale_h = (((float) new_h / src_h));
        Matrix matrix = new Matrix();
        matrix.postScale(scale_w, scale_h);
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap, 0, 0, src_w, src_h, matrix, true);
        ivChange.setImageBitmap(bitmap1);
    }
    public void AddIma4(int url) {
        MultiTouchImageView mtiv = new MultiTouchImageView(getActivity());
        mtiv.setScaleType(ImageView.ScaleType.MATRIX);
        mtiv.setLayoutParams(relative.getLayoutParams());
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),url);
        Log.d(TAG, "AddIma4: "+bitmap.toString());
        int src_w = bitmap.getWidth();
        int src_h = bitmap.getHeight();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int new_w = (int) (displayMetrics.widthPixels * 0.8);
        int new_h = (int) (displayMetrics.heightPixels * 0.8);
        float scale_w = (((float) new_w / src_w));
        float scale_h = (((float) new_h / src_h));
        Matrix matrix = new Matrix();
        matrix.postScale(scale_w, scale_h);
        Bitmap bitmap1 = Bitmap.createBitmap(bitmap, 0, 0, src_w, src_h, matrix, true);
        mtiv.setImageBitmap(bitmap);
        relative.addView(mtiv);
    }
    @SuppressLint("Range")
    private String getImagePath(Uri uri, String selection) {
        String path = null;
        Cursor cursor = getActivity().getContentResolver().query(uri, null, selection, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return path;
    }





    public void setTV() {
        tvs.add(tv1);
        tvs.add(tv2);
        tvs.add(tv3);
        tvs.add(tv4);
        tvs.add(tv5);
        tvs.add(tv6);
        tvs.add(tv0);
        for (int i = 0; i < tvs.size(); i++) {
            tvs.get(i).setOnClickListener(new dj());
        }
        btBj.setOnClickListener(new zp());
        btPj.setOnClickListener(new zp());
    }

    public ArrayList<SmallPic> addIma_GQ() {
        smallPics = new ArrayList<>();
        smallPics.add(new SmallPic().setName("小表情1").setUrl(R.drawable.a10).setType(0));//小表情
        smallPics.add(new SmallPic().setName("小表情2").setUrl(R.drawable.a11).setType(0));
        smallPics.add(new SmallPic().setName("小表情3").setUrl(R.drawable.a12).setType(0));
        smallPics.add(new SmallPic().setName("小表情4").setUrl(R.drawable.a13).setType(0));
        smallPics.add(new SmallPic().setName("小表情5").setUrl(R.drawable.a14).setType(0));
        smallPics.add(new SmallPic().setName("小表情6").setUrl(R.drawable.a15).setType(0));
        smallPics.add(new SmallPic().setName("小表情7").setUrl(R.drawable.a16).setType(0));
        smallPics.add(new SmallPic().setName("小表情8").setUrl(R.drawable.a17).setType(0));
        smallPics.add(new SmallPic().setName("小表情9").setUrl(R.drawable.a18).setType(0));
        smallPics.add(new SmallPic().setName("小表情10").setUrl(R.drawable.a19).setType(0));
        smallPics.add(new SmallPic().setName("小表情11").setUrl(R.drawable.a20).setType(0));
        smallPics.add(new SmallPic().setName("小表情12").setUrl(R.drawable.a21).setType(0));
        smallPics.add(new SmallPic().setName("小表情13").setUrl(R.drawable.a22).setType(0));
        smallPics.add(new SmallPic().setName("小表情14").setUrl(R.drawable.a23).setType(0));
        smallPics.add(new SmallPic().setName("小表情15").setUrl(R.drawable.a24).setType(0));
        smallPics.add(new SmallPic().setName("小表情16").setUrl(R.drawable.a25).setType(0));
        smallPics.add(new SmallPic().setName("小表情17").setUrl(R.drawable.a26).setType(0));
        smallPics.add(new SmallPic().setName("小表情18").setUrl(R.drawable.a38).setType(0));
        smallPics.add(new SmallPic().setName("小表情19").setUrl(R.drawable.a27).setType(0));
        smallPics.add(new SmallPic().setName("小表情20").setUrl(R.drawable.a28).setType(0));
        smallPics.add(new SmallPic().setName("小表情21").setUrl(R.drawable.a29).setType(0));
        smallPics.add(new SmallPic().setName("小表情22").setUrl(R.drawable.a30).setType(0));
        smallPics.add(new SmallPic().setName("小表情23").setUrl(R.drawable.a31).setType(0));
        smallPics.add(new SmallPic().setName("小表情24").setUrl(R.drawable.a32).setType(0));
        smallPics.add(new SmallPic().setName("小表情25").setUrl(R.drawable.a33).setType(0));
        smallPics.add(new SmallPic().setName("小表情26").setUrl(R.drawable.a34).setType(0));
        smallPics.add(new SmallPic().setName("小表情27").setUrl(R.drawable.a35).setType(0));
        smallPics.add(new SmallPic().setName("小表情28").setUrl(R.drawable.a36).setType(0));
        smallPics.add(new SmallPic().setName("小表情29").setUrl(R.drawable.a37).setType(0));
        smallPics.add(new SmallPic().setName("小表情30").setUrl(R.drawable.a39).setType(0));
        smallPics.add(new SmallPic().setName("小表情31").setUrl(R.drawable.a4).setType(0));
        smallPics.add(new SmallPic().setName("小表情32").setUrl(R.drawable.a5).setType(0));
        smallPics.add(new SmallPic().setName("小表情33").setUrl(R.drawable.a6).setType(0));
        smallPics.add(new SmallPic().setName("小表情34").setUrl(R.drawable.a7).setType(0));
        smallPics.add(new SmallPic().setName("小表情35").setUrl(R.drawable.a8).setType(0));
        smallPics.add(new SmallPic().setName("小表情36").setUrl(R.drawable.a9).setType(0));


        smallPics.add(new SmallPic().setName("表情1").setUrl(R.drawable.b10).setType(1));//表情
        smallPics.add(new SmallPic().setName("表情2").setUrl(R.drawable.b11).setType(1));
        smallPics.add(new SmallPic().setName("表情3").setUrl(R.drawable.b12).setType(1));
        smallPics.add(new SmallPic().setName("表情4").setUrl(R.drawable.b2).setType(1));
        smallPics.add(new SmallPic().setName("表情5").setUrl(R.drawable.b3).setType(1));
        smallPics.add(new SmallPic().setName("表情6").setUrl(R.drawable.b4).setType(1));
        smallPics.add(new SmallPic().setName("表情7").setUrl(R.drawable.b5).setType(1));
        smallPics.add(new SmallPic().setName("表情8").setUrl(R.drawable.b6).setType(1));
        smallPics.add(new SmallPic().setName("表情9").setUrl(R.drawable.b8).setType(1));
        smallPics.add(new SmallPic().setName("表情10").setUrl(R.drawable.b9).setType(1));
        smallPics.add(new SmallPic().setName("表情11").setUrl(R.drawable.bt11).setType(1));
        smallPics.add(new SmallPic().setName("表情12").setUrl(R.drawable.bt3).setType(1));
        smallPics.add(new SmallPic().setName("表情13").setUrl(R.drawable.bt5).setType(1));
        smallPics.add(new SmallPic().setName("表情14").setUrl(R.drawable.bt6).setType(1));


        smallPics.add(new SmallPic().setName("右胳膊1").setUrl(R.drawable.gb1).setType(2));//上肢
        smallPics.add(new SmallPic().setName("右胳膊2").setUrl(R.drawable.gb2).setType(2));
        smallPics.add(new SmallPic().setName("左胳膊3").setUrl(R.drawable.gbl1).setType(2));
        smallPics.add(new SmallPic().setName("右胳膊3").setUrl(R.drawable.gb3).setType(2));
        smallPics.add(new SmallPic().setName("左胳膊2").setUrl(R.drawable.gbl2).setType(2));
        smallPics.add(new SmallPic().setName("左胳膊1").setUrl(R.drawable.gbl3).setType(2));


        smallPics.add(new SmallPic().setName("Q表情4").setUrl(R.drawable.bt6).setType(3));//QQ表情
        smallPics.add(new SmallPic().setName("Q表情3").setUrl(R.drawable.bt5).setType(3));
        smallPics.add(new SmallPic().setName("Q表情2").setUrl(R.drawable.bt3).setType(3));
        smallPics.add(new SmallPic().setName("Q表情1").setUrl(R.drawable.bt11).setType(3));


        smallPics.add(new SmallPic().setName("相机4").setUrl(R.drawable.dz5).setType(4));//配件
        smallPics.add(new SmallPic().setName("相机3").setUrl(R.drawable.dz4).setType(4));
        smallPics.add(new SmallPic().setName("相机2").setUrl(R.drawable.dz3).setType(4));
        smallPics.add(new SmallPic().setName("相机1").setUrl(R.drawable.dz2).setType(4));


        smallPics.add(new SmallPic().setName("左1").setUrl(R.drawable.k1).setType(2));//上肢
        smallPics.add(new SmallPic().setName("左2").setUrl(R.drawable.k2).setType(2));
        smallPics.add(new SmallPic().setName("左3").setUrl(R.drawable.k3).setType(2));
        smallPics.add(new SmallPic().setName("右3").setUrl(R.drawable.kr1).setType(2));
        smallPics.add(new SmallPic().setName("右2").setUrl(R.drawable.kr2).setType(2));
        smallPics.add(new SmallPic().setName("右1").setUrl(R.drawable.kr3).setType(2));


        smallPics.add(new SmallPic().setName("右小腿1").setUrl(R.drawable.r1).setType(5));//下肢
        smallPics.add(new SmallPic().setName("右小腿2").setUrl(R.drawable.r3).setType(5));
        smallPics.add(new SmallPic().setName("右小腿3").setUrl(R.drawable.r2).setType(5));

        return smallPics;
    }

    private class dj implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tv0:
                    setHorAdapter(smallPics);
                    select(6);
                    break;
                case R.id.tv1:
                    select(0);
                    break;
                case R.id.tv2:
                    select(1);
                    break;
                case R.id.tv3:
                    select(2);
                    break;
                case R.id.tv4:
                    select(3);
                    break;
                case R.id.tv5:
                    select(4);
                    break;
                case R.id.tv6:
                    select(5);
                    break;
            }
        }
    }

    public void select(int x) {
        for (int i = 0; i < tvs.size(); i++) {
            if (x == i) {
                tvs.get(i).setBackgroundColor(Color.parseColor("#00ff00"));
            } else {
                tvs.get(i).setBackgroundColor(Color.parseColor("#00000000"));
            }
        }
        if (x==6)
        {

        }
        else
        {
        ArrayList<SmallPic> sms = new ArrayList<>();
        for (int i = 0; i < smallPics.size(); i++) {
            if (x == smallPics.get(i).getType()) {
                sms.add(smallPics.get(i));
            }
        }
        setHorAdapter(sms);
        }
    }

    private static final String TAG = "HomeFragment";
    public void setHorAdapter(ArrayList<SmallPic> sms)
    {
        Log.d(TAG, "setHorAdapter: ===="+sms.size());
        HorListview_Adapter adapter=new HorListview_Adapter(sms,getContext());
        adapter.setClick(new Click() {
            @Override
            public void clicks(SmallPic pic) {
                AddIma4(pic.getUrl());
            }
        });
        horListview.setAdapter(adapter);
    }

    private void initView() {
        ivChange = (ImageView) getView().findViewById(R.id.iv_change);
        relative = (RelativeLayout) getView().findViewById(R.id.relative);
        horListview = (HorizontalListView) getView().findViewById(R.id.hor_listview);
        btBj = (ImageButton) getView().findViewById(R.id.bt_bj);
        btPj = (ImageButton) getView().findViewById(R.id.bt_pj);
        tv1 = (TextView) getView().findViewById(R.id.tv1);
        tv2 = (TextView) getView().findViewById(R.id.tv2);
        tv3 = (TextView) getView().findViewById(R.id.tv3);
        tv4 = (TextView) getView().findViewById(R.id.tv4);
        tv5 = (TextView) getView().findViewById(R.id.tv5);
        tv6 = (TextView) getView().findViewById(R.id.tv6);
        tv0 = (TextView) getView().findViewById(R.id.tv0);
    }
}
