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
        smallPics.add(new SmallPic().setName("小表情1").setUrl(R.drawable.a10));
        smallPics.add(new SmallPic().setName("小表情2").setUrl(R.drawable.a11));
        smallPics.add(new SmallPic().setName("小表情3").setUrl(R.drawable.a12));
        smallPics.add(new SmallPic().setName("小表情4").setUrl(R.drawable.a13));
        smallPics.add(new SmallPic().setName("小表情5").setUrl(R.drawable.a14));
        smallPics.add(new SmallPic().setName("小表情6").setUrl(R.drawable.a15));
        smallPics.add(new SmallPic().setName("小表情7").setUrl(R.drawable.a16));
        smallPics.add(new SmallPic().setName("小表情8").setUrl(R.drawable.a17));
        smallPics.add(new SmallPic().setName("小表情9").setUrl(R.drawable.a18));
        smallPics.add(new SmallPic().setName("小表情10").setUrl(R.drawable.a19));
        smallPics.add(new SmallPic().setName("小表情11").setUrl(R.drawable.a20));
        smallPics.add(new SmallPic().setName("小表情12").setUrl(R.drawable.a21));
        smallPics.add(new SmallPic().setName("小表情13").setUrl(R.drawable.a22));
        smallPics.add(new SmallPic().setName("小表情14").setUrl(R.drawable.a23));
        smallPics.add(new SmallPic().setName("小表情15").setUrl(R.drawable.a24));
        smallPics.add(new SmallPic().setName("小表情16").setUrl(R.drawable.a25));
        smallPics.add(new SmallPic().setName("小表情17").setUrl(R.drawable.a26));
        smallPics.add(new SmallPic().setName("小表情18").setUrl(R.drawable.a38));
        smallPics.add(new SmallPic().setName("小表情19").setUrl(R.drawable.a27));
        smallPics.add(new SmallPic().setName("小表情20").setUrl(R.drawable.a28));
        smallPics.add(new SmallPic().setName("小表情21").setUrl(R.drawable.a29));
        smallPics.add(new SmallPic().setName("小表情22").setUrl(R.drawable.a30));
        smallPics.add(new SmallPic().setName("小表情23").setUrl(R.drawable.a31));
        smallPics.add(new SmallPic().setName("小表情24").setUrl(R.drawable.a32));
        smallPics.add(new SmallPic().setName("小表情25").setUrl(R.drawable.a33));
        smallPics.add(new SmallPic().setName("小表情26").setUrl(R.drawable.a34));
        smallPics.add(new SmallPic().setName("小表情27").setUrl(R.drawable.a35));
        smallPics.add(new SmallPic().setName("小表情28").setUrl(R.drawable.a36));
        smallPics.add(new SmallPic().setName("小表情29").setUrl(R.drawable.a37));
        smallPics.add(new SmallPic().setName("小表情30").setUrl(R.drawable.a39));
        smallPics.add(new SmallPic().setName("小表情31").setUrl(R.drawable.a4));
        smallPics.add(new SmallPic().setName("小表情32").setUrl(R.drawable.a5));
        smallPics.add(new SmallPic().setName("小表情33").setUrl(R.drawable.a6));
        smallPics.add(new SmallPic().setName("小表情34").setUrl(R.drawable.a7));
        smallPics.add(new SmallPic().setName("小表情35").setUrl(R.drawable.a8));
        smallPics.add(new SmallPic().setName("小表情36").setUrl(R.drawable.a9));


        smallPics.add(new SmallPic().setName("表情1").setUrl(R.drawable.b10));
        smallPics.add(new SmallPic().setName("表情2").setUrl(R.drawable.b11));
        smallPics.add(new SmallPic().setName("表情3").setUrl(R.drawable.b12));
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



    }


    private void initView() {
        ivChange = (ImageView) getView().findViewById(R.id.iv_change);
        relative = (RelativeLayout) getView().findViewById(R.id.relative);
        horListview = (HorizontalListView) getView().findViewById(R.id.hor_listview);
    }
}
