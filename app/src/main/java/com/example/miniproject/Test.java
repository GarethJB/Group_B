package com.example.miniproject;

import android.util.Log;

public class Test {
    int a = 5;
    String TAG = "로그";

    public void abc() {
        if (a != 5) {
            a = 4;
        } else if (a == 5) {
            for(int i = 0; i <= 15; i++) {
                Log.d(TAG, "abc: " + a++);
            }
        }
    }

}
