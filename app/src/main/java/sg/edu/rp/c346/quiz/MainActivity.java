package sg.edu.rp.c346.quiz;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static java.lang.reflect.Array.getInt;

public class MainActivity extends AppCompatActivity {

    BroadcastReceiver br = new WallpaperReceiver();

    RadioGroup rgGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgGroup = findViewById(R.id.radioGroup);

        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction("android.intent.action.WALLPAPER_CHANGED");
        this.registerReceiver(br, filter);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.unregisterReceiver(br);

    }
    @Override
    protected void onPause() {
        super.onPause();
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("id",rgGroup.getCheckedRadioButtonId());
            editor.apply();
        }


    @Override
    protected void onResume() {
        super.onResume();
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            int id = sharedPreferences.getInt("id", 0);
            rgGroup.check(id);
        }


    }

