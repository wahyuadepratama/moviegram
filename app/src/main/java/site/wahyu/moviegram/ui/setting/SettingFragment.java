package site.wahyu.moviegram.ui.setting;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.preference.CheckBoxPreference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreference;

import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

import site.wahyu.moviegram.R;
import site.wahyu.moviegram.receiver.ReminderNotificationAlarm;

import static site.wahyu.moviegram.utils.config.Config.DEFAULT_HISTORY;
import static site.wahyu.moviegram.utils.config.Config.DEFAULT_REMINDER_NOTIFICATION;
import static site.wahyu.moviegram.utils.config.Config.HISTORY;
import static site.wahyu.moviegram.utils.config.Config.REMINDER_NOTIFICATION;

public class SettingFragment extends PreferenceFragmentCompat implements
        SharedPreferences.OnSharedPreferenceChangeListener {

    private SwitchPreference reminderPreference;
    private CheckBoxPreference historyPreference;
    private Context context;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.preferences);
        init();
        summary();
    }

    private void init(){
        reminderPreference = findPreference(REMINDER_NOTIFICATION);
        historyPreference = findPreference(HISTORY);
    }

    private void summary(){
        SharedPreferences sh = getPreferenceManager().getSharedPreferences();
        reminderPreference.setChecked(sh.getBoolean(REMINDER_NOTIFICATION, DEFAULT_REMINDER_NOTIFICATION));
        historyPreference.setChecked(sh.getBoolean(HISTORY, DEFAULT_HISTORY));
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sh, String s) {
        if (s.equals(REMINDER_NOTIFICATION)){

            reminderPreference.setChecked(sh.getBoolean(REMINDER_NOTIFICATION, DEFAULT_REMINDER_NOTIFICATION));

            ReminderNotificationAlarm reminderNotificationAlarm = new ReminderNotificationAlarm();

            if (sh.getBoolean(REMINDER_NOTIFICATION, DEFAULT_REMINDER_NOTIFICATION)){
                reminderNotificationAlarm.setRepeatingAlarm(this.context);
                Snackbar.make(Objects.requireNonNull(getView()), "Notification Enabled", Snackbar.LENGTH_LONG).show();
            }else{
                reminderNotificationAlarm.cancelAlarm(this.context);
                Snackbar.make(Objects.requireNonNull(getView()), "Notification Disabled", Snackbar.LENGTH_LONG).show();
            }

        }else if(s.equals(HISTORY)){
            historyPreference.setChecked(sh.getBoolean(HISTORY, DEFAULT_HISTORY));
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }
}
