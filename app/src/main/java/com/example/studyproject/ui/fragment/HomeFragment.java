package com.example.studyproject.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

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
        ArrayList<SmallPic> smallPics=new ArrayList<>();

        HorListview_Adapter adapter=new HorListview_Adapter(smallPics,getActivity());
        horListview.setAdapter(adapter);
    }
    public void addIma_GQ()
    {
        ArrayList<SmallPic> smallPics=new ArrayList<>();

        smallPics.add(new SmallPic().setName("表情1").setUrl(R.drawable.b10));
        smallPics.add(new SmallPic().setName("表情2").setUrl(R.drawable.b11));
        smallPics.add(new SmallPic().setName("表情3").setUrl(R.drawable.b12));
        smallPics.add(new SmallPic().setName("小表情31").setUrl(R.drawable.a4));
        smallPics.add(new SmallPic().setName("表情4").setUrl(R.drawable.b2));
        smallPics.add(new SmallPic().setName("表情5").setUrl(R.drawable.b3));
        smallPics.add(new SmallPic().setName("表情6").setUrl(R.drawable.b4));
        smallPics.add(new SmallPic().setName("表情7").setUrl(R.drawable.b5));
        smallPics.add(new SmallPic().setName("表情8").setUrl(R.drawable.b6));
        smallPics.add(new SmallPic().setName("表情9").setUrl(R.drawable.b8));
        smallPics.add(new SmallPic().setName("表情10").setUrl(R.drawable.b9));
        smallPics.add(new SmallPic().setName("表情11").setUrl(R.drawable.bt11));
        smallPics.add(new SmallPic().setName("表情12").setUrl(R.drawable.bt3));
        smallPics.add(new SmallPic().setName("表情13").setUrl(R.drawable.bt5));
        smallPics.add(new SmallPic().setName("表情14").setUrl(R.drawable.bt6));



        smallPics.add(new SmallPic().setName("右胳膊1").setUrl(R.drawable.gb1));
        smallPics.add(new SmallPic().setName("右胳膊2").setUrl(R.drawable.gb2));
        smallPics.add(new SmallPic().setName("左胳膊3").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("右胳膊3").setUrl(R.drawable.gb3));
        smallPics.add(new SmallPic().setName("左胳膊2").setUrl(R.drawable.gbl2));
        smallPics.add(new SmallPic().setName("左胳膊1").setUrl(R.drawable.gbl3));



        smallPics.add(new SmallPic().setName("Q表情4").setUrl(R.drawable.bt6));
        smallPics.add(new SmallPic().setName("Q表情3").setUrl(R.drawable.bt5));
        smallPics.add(new SmallPic().setName("Q表情2").setUrl(R.drawable.bt3));
        smallPics.add(new SmallPic().setName("Q表情1").setUrl(R.drawable.bt11));



        smallPics.add(new SmallPic().setName("相机4").setUrl(R.drawable.dz5));
        smallPics.add(new SmallPic().setName("相机3").setUrl(R.drawable.dz4));
        smallPics.add(new SmallPic().setName("相机2").setUrl(R.drawable.dz3));
        smallPics.add(new SmallPic().setName("相机1").setUrl(R.drawable.dz2));




        smallPics.add(new SmallPic().setName("左1").setUrl(R.drawable.k1));
        smallPics.add(new SmallPic().setName("左2").setUrl(R.drawable.k2));
        smallPics.add(new SmallPic().setName("左3").setUrl(R.drawable.k3));
        smallPics.add(new SmallPic().setName("右3").setUrl(R.drawable.kr1));
        smallPics.add(new SmallPic().setName("右2").setUrl(R.drawable.kr2));
        smallPics.add(new SmallPic().setName("右1").setUrl(R.drawable.kr3));


        smallPics.add(new SmallPic().setName("右小腿1").setUrl(R.drawable.r1));
        smallPics.add(new SmallPic().setName("右小腿2").setUrl(R.drawable.r3));
        smallPics.add(new SmallPic().setName("右小腿3").setUrl(R.drawable.r2));




        smallPics.add(new SmallPic().setName("动作").setUrl(R.drawable.a2));
        smallPics.add(new SmallPic().setName("动作").setUrl(R.drawable.a3));
        smallPics.add(new SmallPic().setName("动作").setUrl(R.drawable.a4));
        smallPics.add(new SmallPic().setName("动作").setUrl(R.drawable.b2));
        smallPics.add(new SmallPic().setName("动作").setUrl(R.drawable.b3));
        smallPics.add(new SmallPic().setName("动作").setUrl(R.drawable.b4));
        smallPics.add(new SmallPic().setName("动作").setUrl(R.drawable.b5));
        smallPics.add(new SmallPic().setName("动作").setUrl(R.drawable.c2));
        smallPics.add(new SmallPic().setName("动作").setUrl(R.drawable.c3));
        smallPics.add(new SmallPic().setName("动作").setUrl(R.drawable.c4));
        smallPics.add(new SmallPic().setName("动作").setUrl(R.drawable.c1));
        smallPics.add(new SmallPic().setName("动作").setUrl(R.drawable.d1));
        smallPics.add(new SmallPic().setName("动作").setUrl(R.drawable.d2));
        smallPics.add(new SmallPic().setName("动作").setUrl(R.drawable.d3));
        smallPics.add(new SmallPic().setName("动作").setUrl(R.drawable.d3));
        smallPics.add(new SmallPic().setName("动作").setUrl(R.drawable.e1));
        smallPics.add(new SmallPic().setName("动作").setUrl(R.drawable.e2));
        smallPics.add(new SmallPic().setName("动作").setUrl(R.drawable.e3));
        smallPics.add(new SmallPic().setName("动作").setUrl(R.drawable.e4));
        smallPics.add(new SmallPic().setName("动作").setUrl(R.drawable.f2));
        smallPics.add(new SmallPic().setName("动作").setUrl(R.drawable.f3));


    }


    private void initView() {
        ivChange = (ImageView) getView().findViewById(R.id.iv_change);
        relative = (RelativeLayout) getView().findViewById(R.id.relative);
        horListview = (HorizontalListView) getView().findViewById(R.id.hor_listview);
    }
}
