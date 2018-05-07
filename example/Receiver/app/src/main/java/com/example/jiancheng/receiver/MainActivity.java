package com.example.jiancheng.receiver;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn,btn2;
    //private static final String BC_ACTION="org.hualang.alarm.action.BC_ACTION";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn= (Button) findViewById(R.id.btn);
        btn2= (Button) findViewById(R.id.btn2);

        final AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
        final Intent intent = new Intent();
        intent.setAction("org.hualang.alarm.action.BC_ACTION");
        intent.putExtra("msg", "你該起床了");
        final PendingIntent pi = PendingIntent.getBroadcast(MainActivity.this, 0, intent, 0);
        final long time = System.currentTimeMillis();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                am.setRepeating(AlarmManager.RTC_WAKEUP,time,5*1000,pi);
            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                am.cancel(pi);
            }
        });






    }


}
