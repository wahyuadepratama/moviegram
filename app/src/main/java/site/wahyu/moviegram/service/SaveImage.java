package site.wahyu.moviegram.service;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import site.wahyu.moviegram.utils.GlideApp;

public class SaveImage extends Worker {

    private static final String TAG = SaveImage.class.getSimpleName();
    public static final String KEY_IMAGE_URI = "KEY_IMAGE_URI";

    private static final String TITLE = "Favorite Movie Image";
    private static final SimpleDateFormat DATE_FORMATTER =
            new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss z", Locale.getDefault());

    public SaveImage(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        WorkerUtils.makeStatusNotification("Downloading ...", getApplicationContext());
        WorkerUtils.sleep();

        Context applicationContext = getApplicationContext();

        ContentResolver resolver = applicationContext.getContentResolver();
        try {
            String resourceUri = getInputData()
                    .getString(KEY_IMAGE_URI);

            Bitmap bitmap = GlideApp.with(applicationContext)
                    .asBitmap()
                    .load(resourceUri)
                    .submit()
                    .get();

            String outputUri = MediaStore.Images.Media.insertImage(
                    resolver, bitmap, TITLE, DATE_FORMATTER.format(new Date()));

            if (TextUtils.isEmpty(outputUri)) {
                Log.e(TAG, "Writing to MediaStore failed");
                return Result.failure();
            }

            Data outputData = new Data.Builder()
                    .putString(KEY_IMAGE_URI, outputUri)
                    .build();

            WorkerUtils.makeStatusNotification("Download Success", getApplicationContext());
            WorkerUtils.sleep();

            return Result.success(outputData);

        } catch (Exception exception) {
            Log.e(TAG, "Unable to save image to Gallery", exception);
            return Worker.Result.failure();
        }
    }
}
