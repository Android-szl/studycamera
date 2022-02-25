package com.example.studyproject;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
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
        setFragmentMap();
        setFrameLayout(Objects.requireNonNull(fragmentMap.get("首页")));
        Log.d("log", "onCreate: 123");
        binding.mainBottom.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.navigation_home) {
                setFrameLayout(Objects.requireNonNull(fragmentMap.get("首页")));
            } else if (itemId == R.id.navigation_dashboard) {
                setFrameLayout(Objects.requireNonNull(fragmentMap.get("Gif")));
            }
            return true;
        });
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