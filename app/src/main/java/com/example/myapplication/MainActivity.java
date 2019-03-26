package com.example.myapplication;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button=(Button)findViewById(R.id.a1);
        Button button1=(Button)findViewById(R.id.a2);
        Button button2=(Button)findViewById(R.id.a3);
        Button button3=(Button)findViewById(R.id.a4);
        Button button4=(Button)findViewById(R.id.a5);

        button.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }



    private ServiceConnection connection =new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            MyService.Aaa aaa;//储存服务返回的对象
            aaa=(MyService.Aaa)service;
            aaa.get();
            aaa.set();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.a1://开启
                Intent intent=new Intent(this,MyService.class);
                startService(intent);
                break;

            case R.id.a2://关闭
                Intent intent1=new Intent(this,MyService.class);
                stopService(intent1);
                break;

            case R.id.a3://绑定
                Intent intent2=new Intent(this,MyService.class);
                bindService(intent2,connection,BIND_AUTO_CREATE);
                break;

            case R.id.a4://解绑
                unbindService(connection);
                break;

            case R.id.a5://InerntServic后台服务
                Intent intent3=new Intent(this,Ht.class);
                stopService(intent3);
                Log.d("MainActivity","007");
                break;

                default:
                    break;
        }

    }
}
