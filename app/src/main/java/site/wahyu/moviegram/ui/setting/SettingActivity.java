package site.wahyu.moviegram.ui.setting;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import site.wahyu.moviegram.R;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        getSupportFragmentManager().beginTransaction().add(R.id.setting_holder, new SettingFragment()).commit();
    }
}
