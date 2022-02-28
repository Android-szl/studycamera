package com.example.studyproject;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import com.example.studyproject.databinding.ActivityMainBinding;
import com.example.studyproject.ui.fragment.GifFragment;
import com.example.studyproject.ui.fragment.HomeFragment;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private Fragment currFragment;
    private Map<String, Fragment> fragmentMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        verifyStoragePermissions(this);
        setFragmentMap();
        setFrameLayout(Objects.requireNonNull(fragmentMap.get("首页")));

        binding.mainBottom.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.home_iv) {
                setFrameLayout(Objects.requireNonNull(fragmentMap.get("首页")));
            } else if (itemId == R.id.gif_iv) {
                setFrameLayout(Objects.requireNonNull(fragmentMap.get("Gif")));
            }
            return true;
        });
    }

    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE"};


    public static void verifyStoragePermissions(Activity activity) {
        try {
            //检测是否有写的权限
            int permission = ActivityCompat.checkSelfPermission(activity,
                    "android.permission.WRITE_EXTERNAL_STORAGE");
            if (permission != PackageManager.PERMISSION_GRANTED) {
                // 没有写的权限，去申请写的权限，会弹出对话框
                ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void setFragmentMap() {
        fragmentMap = new HashMap<>();
        fragmentMap.put("首页", new HomeFragment());
        fragmentMap.put("Gif", new GifFragment());
    }

    private void setFrameLayout(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (fragment.isAdded()) {
            transaction.hide(currFragment).show(fragment);
        } else {
            if (currFragment != null) {
                transaction.hide(currFragment);
            }
            transaction.add(R.id.main_frame, fragment);
        }
        currFragment = fragment;
        transaction.commit();
    }
}