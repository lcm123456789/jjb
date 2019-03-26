package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    public Aaa aaa = new Aaa();//子类构造方法

    class Aaa extends Binder{
        public void set(){
            Log.d("MyService","活动与服务通讯");
        }

        public int get(){
            Log.d("MyService","活动与服务通讯返回数据");
            return 0;
        }
    }

    public MyService() {}//父类构造方法

    @Override
    public IBinder onBind(Intent intent) {
        return aaa;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("MyService","启动时运行");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyService","调用时运行");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyService","关闭时运行");
    }

}
