package site.wahyu.moviegram.service;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import site.wahyu.moviegram.R;
import site.wahyu.moviegram.data.remote.model.Movie;
import site.wahyu.moviegram.ui.movie.detail.MovieDetailActivity;
import site.wahyu.moviegram.utils.config.Config;

public class AddToFavoriteMovieNotification extends JobService {

    private NotificationManager mNotifyManager;

    private static final int NOTIFICATION_ID = 1;
    private static final String CHANNEL_ID = "channel_01";
    private static final String CHANNEL_NAME = "favorite_movie_notification";

    @Override
    public boolean onStartJob(JobParameters p) {
        createNotificationChannel();

        Movie movies = new Movie(
                p.getExtras().getInt("id"),
                p.getExtras().getString("poster_path"),
                p.getExtras().getString("title"),
                p.getExtras().getString("overview"),
                p.getExtras().getString("release_date")
        );

        showNotification(
                p.getExtras().getString("notif_title"),
                p.getExtras().getString("notif_description"),
                movies
        );

        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    private void showNotification(String title, String description, Movie movie) {

        Intent intent = new Intent(this, MovieDetailActivity.class);
        PendingIntent contentPendingIntent = PendingIntent.getActivity(
                this,
                0,
                intent.putExtra(Config.EXTRA_MOVIES, movie),
                PendingIntent.FLAG_UPDATE_CURRENT
        );

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(description)
                .setContentIntent(contentPendingIntent)
                .setSmallIcon(R.drawable.ic_favorite)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setAutoCancel(true);

        mNotifyManager.notify(NOTIFICATION_ID, builder.build());
    }

    public void createNotificationChannel(){

        mNotifyManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

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
}
