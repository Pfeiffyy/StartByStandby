package com.pf.startbystandby;

import android.app.Service;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.util.Log;

import java.util.Locale;

public class Timerservice extends Service {

    CountDownTimer timer;
    public Timerservice() {
        sendTimer(20);
        timer.start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void sendTimer(int waitTime) {
        timer = new CountDownTimer(waitTime * 1000, 20) {


            @Override
            public void onTick(long millisUntilFinished) {
                Log.d("service",(String.format(Locale.getDefault(), "%d", millisUntilFinished / 1000L)));
            }

            @Override
            public void onFinish() {
                try {
                    Log.d("service","finiiiissshhhhhh");




                    timer.start();
                } catch (Exception e) {
                    Log.e("Error", "Error: " + e.toString());
                    e.printStackTrace();
                }
            }
        };
    }



}