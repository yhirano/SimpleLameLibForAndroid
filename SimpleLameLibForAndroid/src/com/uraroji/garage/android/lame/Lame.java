package com.uraroji.garage.android.lame;

import android.util.Log;

public class Lame {
    public static final String TAG = "SimpleLameLib";

    static {
        System.loadLibrary("mp3lame");
        Log.d(TAG, "Loaded native library.");
    }

    /**
     * Display log.
     * 
     * @param instanceIndex Instance index.
     * @param on display log setting.
     */
    public native static void log(boolean on);
}
