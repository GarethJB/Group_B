package com.example.miniproject;

import android.util.Log;

public class Test {
    int a = 5;
    int b = 3;
    String TAG = "로그";

        public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + 10);
        }
    }

    public void abc() {
        if (a != 5) {
            a = 4;
        } else if (a == 5) {
            for(int i = 0; i <= 15; i++) {
                Log.d(TAG, "abc: " + a++ + b);
            }
        }
    }
}