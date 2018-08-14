package sg.edu.rp.c346.quiz;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

public class WallpaperReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast my_toast = Toast.makeText(context,"You have changed the wallpaper",Toast.LENGTH_LONG);
        my_toast.show();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        int id = preferences.getInt("id",R.id.radioButtonGood);
        if(id == R.id.radioButtonGood)
            Toast.makeText(context,"You have a good taste!",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(context,"Bro,think twice about it.",Toast.LENGTH_LONG).show();
    }
}
