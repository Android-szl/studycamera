package com.example.studyproject.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import com.bumptech.glide.Glide;
import com.example.studyproject.MainActivity;
import com.example.studyproject.R;
import com.example.studyproject.base.BaseActivity;
import com.example.studyproject.databinding.ActivitySpalshBinding;


@SuppressLint("CustomSplashScreen")
public class SplashActivity extends BaseActivity<ActivitySpalshBinding> {
    @Override
    public void init() {
        AlphaAnimation animation = new AlphaAnimation(0.3f, 1.0f);
        animation.setDuration(1000);
        //http://img5.adesk.com/61a1ba657e978a3b2dd42ae4?imageMogr2/thumbnail/!1080x1920r/gravity/Center/crop/1080x1920&sign=179454136412ce2020e6dbc448ec7315&t=62189e12
        Glide.with(this).load(R.mipmap.tp4)
                .into(binding.splashIv);
        binding.splashIv.setAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}