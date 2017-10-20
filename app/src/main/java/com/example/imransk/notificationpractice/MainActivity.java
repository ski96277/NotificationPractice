package com.example.imransk.notificationpractice;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button= (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,intent,0);
                Notification notification=new Notification.Builder(MainActivity.this)
                        .setTicker("Set Ticker")
                        .setContentTitle("Cobtebt Title")
                        .setContentText("this is ContentText")
                        .setSmallIcon(R.drawable.icon)
                        .addAction(R.mipmap.ic_launcher,"Action 1 ",pendingIntent)
                        .addAction(R.mipmap.ic_launcher_round,"Action 2 ",pendingIntent)
                        .setContentIntent(pendingIntent).getNotification();

                notification.flags = Notification.FLAG_AUTO_CANCEL;

                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(0,notification);
            }
        });
    }


}
