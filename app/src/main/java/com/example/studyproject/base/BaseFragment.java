package com.example.studyproject.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

/**
 * @ClassName BaseFragment
 * @Author 史正龙
 * @date 2022.02.25 15:28
 */
public abstract class BaseFragment<T extends ViewBinding> extends Fragment {
    public T binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        if (type != null) {
            Class<T> clazz = (Class<T>) type.getActualTypeArguments()[0];
            try {
                Method method = clazz.getMethod("inflate", LayoutInflater.class, ViewGroup.class, boolean.class);
                binding = (T) method.invoke(null, inflater, container, false);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        assert binding != null;
        return binding.getRoot();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
