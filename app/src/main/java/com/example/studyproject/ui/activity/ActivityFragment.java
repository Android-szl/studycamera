package com.example.studyproject.ui.activity;

import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import com.example.studyproject.R;
import com.example.studyproject.base.BaseActivity;
import com.example.studyproject.databinding.ActivityFragmentBinding;
import com.example.studyproject.ui.fragment.GifFragment;
import com.example.studyproject.ui.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class ActivityFragment extends BaseActivity<ActivityFragmentBinding> implements View.OnClickListener {
    private Fragment currFragment;
    private final List<Fragment> fragmentList = new ArrayList<>();
    private String name;

    @Override
    public void init() {
        Bundle bundle = getIntent().getExtras();
        name = bundle.getString("name");
        showFragment();
    }

    private void showFragment() {
        switch (name) {
            case "首页":
                setFrameLayout(new HomeFragment());
                break;
            case "Gif":
                setFrameLayout(new GifFragment());
                break;

        }
    }

    private void setFrameLayout(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (fragment.isAdded()) {
            transaction.hide(currFragment).show(fragment);
            for (int i = 0; i < fragmentList.size(); i++) {
                if (fragmentList.get(i) == fragment) {
                    fragmentList.remove(i);
                    break;
                }
            }
        } else {
            if (currFragment != null) {
                transaction.hide(currFragment);
                fragmentList.add(currFragment);
            }
            transaction.add(R.id.frag_frame, fragment);
        }
        currFragment = fragment;
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = null;
        if (fragmentList.size() > 0) {
            fragment = fragmentList.get(fragmentList.size() - 1);
        }
        if (fragment != null) {
            setFrameLayout(fragment);
        } else {
            finish();
        }

    }

    @Override
    public void onClick(View view) {
        onBackPressed();
    }
}