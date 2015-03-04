package project6.rhodes.com.project6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import android.widget.Toast;
//Class to create a broadcast that establishes a completed boot of the activity
public class StartupBootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //Once the project 6 activity is finished rendering, you will be notified "Booting Completed"
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            Toast.makeText(context, "Booting Completed", Toast.LENGTH_LONG).show();

        }
    }
}