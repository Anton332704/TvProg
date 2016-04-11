package com.example.tvfirst;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by User on 03.03.2016.
 */
public class Utils {

    public static void makeMyToast(Context context, String text)
    {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }
}
