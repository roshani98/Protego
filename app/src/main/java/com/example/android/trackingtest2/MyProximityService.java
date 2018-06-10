package com.example.android.trackingtest2;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;


public class MyProximityService extends IntentService {



    public MyProximityService() {
        super("MyProximityService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if(intent!=null){
            GeofencingEvent geofencingEvent = GeofencingEvent.fromIntent(intent);
            int geofenceTransition = geofencingEvent.getGeofenceTransition();
            if(geofenceTransition == Geofence.GEOFENCE_TRANSITION_ENTER || geofenceTransition == Geofence.GEOFENCE_TRANSITION_DWELL){
                Toast.makeText(this,"GeoFence Successful",Toast.LENGTH_LONG).show();
                MainActivity.textView.setText(R.string.msg_danger);
            }
        }
    }

}
