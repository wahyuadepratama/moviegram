package site.wahyu.moviegram.receiver;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import java.util.Calendar;

import site.wahyu.moviegram.R;
import site.wahyu.moviegram.ui.home.HomeActivity;

import static android.content.Context.NOTIFICATION_SERVICE;

public class ReminderNotificationAlarm extends BroadcastReceiver {

    private static final int NOTIFICATION_ID = 2;
    private static final String CHANNEL_ID = "channel_02";
    private static final String CHANNEL_NAME = "reminder_notification";
    public static final int ID_REPEATING = 100;
    private Context mContext;

    private NotificationManager mNotifyManager;

    @Override
    public void onReceive(Context context, Intent intent) {
        this.mContext = context;
        createNotificationChannel();
        showNotification("Hey, we miss you", "Check our movie and tv show today!");
    }

    public void setRepeatingAlarm(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 8);
        calendar.set(Calendar.MINUTE, 27);
        calendar.set(Calendar.SECOND, 0);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                context,
                ID_REPEATING,
                new Intent(context, ReminderNotificationAlarm.class),
                0
        );

        if (alarmManager != null) {
            alarmManager.setInexactRepeating(
                    AlarmManager.RTC_WAKEUP,
                    calendar.getTimeInMillis(),
                    AlarmManager.INTERVAL_DAY,
                    pendingIntent);
        }
    }

    public void createNotificationChannel(){

        mNotifyManager = (NotificationManager) mContext.getSystemService(NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID,
                    CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.enableVibration(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setDescription("Notification reminder from job service");

            mNotifyManager.createNotificationChannel(notificationChannel);
        }
    }

    private void showNotification(String title, String description) {

        PendingIntent contentPendingIntent = PendingIntent.getActivity(
                mContext,
                0,
                new Intent(mContext, HomeActivity.class),
                PendingIntent.FLAG_UPDATE_CURRENT
        );

        NotificationCompat.Builder builder = new NotificationCompat.Builder(mContext, CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(description)
                .setContentIntent(contentPendingIntent)
                .setSmallIcon(R.drawable.ic_favorite)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setAutoCancel(true);

        mNotifyManager.notify(NOTIFICATION_ID, builder.build());
    }

    public void cancelAlarm(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, ReminderNotificationAlarm.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, ID_REPEATING, intent, 0);
        pendingIntent.cancel();
        if (alarmManager != null) {
            alarmManager.cancel(pendingIntent);
        }
    }
}
