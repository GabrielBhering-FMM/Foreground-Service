package com.example.foregroundservicegabrielbhering;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    static final String  CHANNEL_ID = "100";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public Notification getNotification(){

        createNotificationChannel();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_priority_high_black_24dp)
                .setContentTitle("Esta é a notificação")
                .setContentText("O que mais posso dizer?")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        return builder.build();

    }


    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            CharSequence name = "Mostrar notificação";
            String description = "Mostra a notificação";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

        }
    }

    public void notificar(View view){

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        notificationManager.notify(100, getNotification());
    }
}
