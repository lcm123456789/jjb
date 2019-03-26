package com.example.myapplication;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class Ht extends IntentService {

    public Ht(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("Hr","后台线程内容");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Hr","后台线程关闭");
    }
}
