package com.example.jiancheng.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ScreenBroadcastReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();
        String msg=intent.getStringExtra("msg");
        Toast.makeText(context, "接收的Intent的Action為：" + action + "\n消息内容是"+msg, Toast.LENGTH_SHORT).show();


    }



}
