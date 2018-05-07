# BroadcastReceiver

BroadcastReceiver分為兩種做法

## (1) 靜態

## 在AndroidManifest.xml裡註冊
```
  //MyReceiver為繼承BroadcastReceiver 的類別名
 <receiver android:name=".MyReceiver">

         <intent-filter>
              <action android:name="action"/>    //android:name為自定義名稱
         </intent-filter>
 </receiver>
```



##### MainActivity.java
```
 Intent intent = new Intent();
 intent.setAction("action");
 sendBroadcast(intent); 
```



##### MyReceiver.java
```
    (1).extends BroadcastReceiver // 繼承BroadcastReceiver
    (2).onReceive()方法 //改寫onReceive()方法
 
```

## (2) 動態


##### MainActivity.java
```
    MyReceiver m  = new MyReceiver();
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("action");   //設定類型
    registerReceiver(m, intentFilter);//進行動態註冊


    unregisterReceiver(mBroadcastReceiver);//註銷廣播


```

##### MyReceiver.java
```
    (1).extends BroadcastReceiver // 繼承BroadcastReceiver
    (2).onReceive()方法 //改寫onReceive()方法
 
```


[BroadcastReceiver範例ㄧ](https://github.com/s5016335/android/tree/master/example/Receiver)


