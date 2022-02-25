package com.example.studyproject.base;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

/**
 * @ClassName BaseFragment
 * @Author 史正龙
 * @date 2022.02.25 15:28
 */
public abstract class BaseActivity<T extends ViewBinding> extends AppCompatActivity {
    public T binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        if (type != null) {
            Class<T> clazz = (Class<T>) type.getActualTypeArguments()[0];
            try {
                Method method = clazz.getMethod("inflate", LayoutInflater.class);
                binding = (T) method.invoke(null, getLayoutInflater());
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            assert binding != null;
            setContentView(binding.getRoot());
        }
        init();
    }


    public abstract void init();

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
