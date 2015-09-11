package com.mmadapps.backgroundtask;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {

    final static String MY_ACTION = "MY_ACTION";

    @Override
    public IBinder onBind(Intent arg0) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub

        MyThread myThread = new MyThread();
        myThread.start();

        return super.onStartCommand(intent, flags, startId);
    }

    public class MyThread extends Thread{

        @Override
        public void run() {
            // TODO Auto-generated method stub
            for(app.i=0; app.i<100; app.i++){
                try {
                    Thread.sleep(500);
                    Intent intent = new Intent();
                    intent.setAction(MY_ACTION);

                    intent.putExtra("DATAPASSED", app.i);

                    sendBroadcast(intent);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
           stopSelf();
        }

    }

}