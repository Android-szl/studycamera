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
        smallPics.add(new SmallPic().setName("小表情").setUrl(R.drawable.a10));
        smallPics.add(new SmallPic().setName("小表情").setUrl(R.drawable.a11));
        smallPics.add(new SmallPic().setName("小表情").setUrl(R.drawable.a12));
        smallPics.add(new SmallPic().setName("小表情").setUrl(R.drawable.a13));
        smallPics.add(new SmallPic().setName("小表情").setUrl(R.drawable.a14));
        smallPics.add(new SmallPic().setName("小表情").setUrl(R.drawable.a15));
        smallPics.add(new SmallPic().setName("小表情").setUrl(R.drawable.a16));
        smallPics.add(new SmallPic().setName("小表情").setUrl(R.drawable.a17));
        smallPics.add(new SmallPic().setName("小表情").setUrl(R.drawable.a18));
        smallPics.add(new SmallPic().setName("小表情").setUrl(R.drawable.a19));
        smallPics.add(new SmallPic().setName("小表情").setUrl(R.drawable.a20));
        smallPics.add(new SmallPic().setName("小表情").setUrl(R.drawable.a21));
        smallPics.add(new SmallPic().setName("小表情").setUrl(R.drawable.a22));
        smallPics.add(new SmallPic().setName("小表情").setUrl(R.drawable.a23));
        smallPics.add(new SmallPic().setName("小表情").setUrl(R.drawable.a24));
        smallPics.add(new SmallPic().setName("小表情").setUrl(R.drawable.a25));
        smallPics.add(new SmallPic().setName("小表情").setUrl(R.drawable.a26));
        smallPics.add(new SmallPic().setName("小表情").setUrl(R.drawable.a38));
        smallPics.add(new SmallPic().setName("小表情").setUrl(R.drawable.a27));
        smallPics.add(new SmallPic().setName("小表情").setUrl(R.drawable.a28));
        smallPics.add(new SmallPic().setName("小表情").setUrl(R.drawable.a29));
        smallPics.add(new SmallPic().setName("小表情").setUrl(R.drawable.a30));
        smallPics.add(new SmallPic().setName("小表情").setUrl(R.drawable.a31));
        smallPics.add(new SmallPic().setName("小表情").setUrl(R.drawable.a32));
        smallPics.add(new SmallPic().setName("小表情").setUrl(R.drawable.a33));
        smallPics.add(new SmallPic().setName("小表情").setUrl(R.drawable.a34));
        smallPics.add(new SmallPic().setName("小表情").setUrl(R.drawable.a35));
        smallPics.add(new SmallPic().setName("小表情").setUrl(R.drawable.a36));
        smallPics.add(new SmallPic().setName("小表情").setUrl(R.drawable.a37));
        smallPics.add(new SmallPic().setName("小表情").setUrl(R.drawable.a39));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));
        smallPics.add(new SmallPic().setName("茄子").setUrl(R.drawable.gbl1));

    }


    private void initView() {
        ivChange = (ImageView) getView().findViewById(R.id.iv_change);
        relative = (RelativeLayout) getView().findViewById(R.id.relative);
        horListview = (HorizontalListView) getView().findViewById(R.id.hor_listview);
    }
}
