package com.example.studyproject.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.studyproject.Bean.SmallPic;
import com.example.studyproject.R;
import com.example.studyproject.adapter.HorListview_Adapter;
import com.example.studyproject.custom.HorizontalListView;

import java.util.ArrayList;


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
    private TextView tv0;

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
        ArrayList<SmallPic> smallPics1 = addIma_GQ();
        HorListview_Adapter adapter = new HorListview_Adapter(smallPics1, getActivity());
        horListview.setAdapter(adapter);
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
                    horListview.setAdapter(new HorListview_Adapter(addIma_GQ(), getContext()));
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
        horListview.setAdapter(new HorListview_Adapter(sms, getContext()));
        }
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
