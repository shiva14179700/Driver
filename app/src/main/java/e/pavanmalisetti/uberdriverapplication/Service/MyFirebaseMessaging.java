package e.pavanmalisetti.uberdriverapplication.Service;

import android.content.Intent;

import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.gson.Gson;

import e.pavanmalisetti.uberdriverapplication.CustomerCall;

public class MyFirebaseMessaging extends FirebaseMessagingService{
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        //because we will send firebase message which contains latitude,longitude from Rider App
        //so we need to convert message to LatLng
        LatLng customer_location=new Gson().fromJson(remoteMessage.getNotification().getBody(),LatLng.class);

        Intent intent=new Intent(getBaseContext(), CustomerCall.class);

        intent.putExtra("lat",customer_location.latitude);
        intent.putExtra("lng",customer_location.longitude);
        intent.putExtra("customer",remoteMessage.getNotification().getTitle());

        startActivity(intent);

        //i.e.,when rider press callDriver button =>send message with content is lat and lng of Rider to Driver App
        //and Driver app receives this message,calculates distance,time and display for user
    }
}
