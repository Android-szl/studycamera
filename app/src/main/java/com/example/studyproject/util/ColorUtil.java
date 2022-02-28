package com.example.studyproject.util;

import android.app.Activity;
import android.graphics.Color;
import android.view.Window;

public class ColorUtil {
    public static void initColor(Activity activity) {
        Window window = activity.getWindow();
        window.setStatusBarColor(Color.parseColor("#0396ff"));
    }
}
