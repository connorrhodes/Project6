package project6.rhodes.com.project6;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import android.widget.Toast;

public class NetworkChangeReceiver extends BroadcastReceiver {

    //previous attempt
 /*   @Override
    public void onReceive(final Context context, final Intent intent) {
        final ConnectivityManager connMgr = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        final android.net.NetworkInfo wifi = connMgr
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        final android.net.NetworkInfo mobile = connMgr
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if (wifi.isAvailable() || mobile.isAvailable()) {
            // Do something

            Log.d("Network Available", "Flag No 1");
        }
    }*/

    @Override
    public void onReceive(Context context, Intent intent) {


        //instantiates a connectivity manager to monitor the internet connection to the device
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE );
        //Specifies the connection to be a mobile one
        NetworkInfo activeNetInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        //Created a boolean to recognize if a working connection was working or null
        boolean isConnected = activeNetInfo != null && activeNetInfo.isConnectedOrConnecting();

        //If statement that will send a notification "Connected via: Mobile" if the device has a connection
        //or a notification "Not Connected via: Mobile" if there is no connection
        if (isConnected)
            Toast.makeText(context, "Connected via: " + activeNetInfo.getTypeName(), Toast.LENGTH_SHORT).show();

            //If you wanted to switch notifications from pop-up to only log debug notifications, comment the toast and uncomment the log lines
            /*Log.i("NET", "connected" + isConnected);*/
        else
            Toast.makeText( context, "Not Connected via: " + activeNetInfo.getTypeName(), Toast.LENGTH_SHORT ).show();

            //If you wanted to switch notifications from pop-up to only log debug notifications, comment the toast and uncomment the log lines
            /*Log.i("NET", "not connected" + isConnected);*/

    }



}