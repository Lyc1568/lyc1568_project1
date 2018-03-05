package com.example.student.myapplication123;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

public class MapsActivity extends FragmentActivity implements OnMapClickListener, OnMapReadyCallback {

    private Marker marker;
    private GoogleMap mMap;
    public double[][] coord = new double[1000][3];
    public Circle[] Cirles = new  Circle[1000];
    public int ind = 0;
    public int rad = 10;

    private static final int NOTIFY_ID = 101;

    @RequiresApi
            (api = Build.VERSION_CODES.JELLY_BEAN)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMapClickListener(this);
        mMap.setOnCircleClickListener(new GoogleMap.OnCircleClickListener() {

            @Override
            public void onCircleClick(Circle circle) {
                circle.setRadius(rad);
            }
        });
    }

    @Override
    public void onMapClick(LatLng point) {
        CircleOptions circleOptions = new CircleOptions()
                .center(point)
                .radius(rad)
                .clickable(true);
        Circle temp = mMap.addCircle(circleOptions);
        Cirles[ind] = temp;
        coord[ind][0] = point.latitude;
        coord[ind][1] = point.longitude;
        coord[ind][2] = rad;
        ind++;
    }

    public void Culick(View view) {
        final EditText edit;
        edit = (EditText) findViewById(R.id.editText);
        rad = Integer.parseInt(edit.getText().toString());
    }

    public void OK_f(View view) {
        //save files all from 0 to ind (not included)


    }

    public void Back(View view) {
        if (ind>0){
            ind-=1;
            Cirles[ind].remove();
        }
    }

    public void GodActivity(double coord_t[]){
        //проверяем попадание в зону

        Intersect inspect = new Intersect();
        inspect.readc(coord_t[0], coord_t[1], coord);

        if (!inspect.inspecting()){

            Context context = getApplicationContext();

            Intent notificstioinIntent = new Intent(context, MapsActivity.class);
            PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificstioinIntent,PendingIntent.FLAG_CANCEL_CURRENT);

            Resources res = context.getResources();
            Notification.Builder builder = new Notification.Builder(context);

            builder.setContentIntent(contentIntent)
                    .setSmallIcon(R.drawable.download)
                    .setLargeIcon(BitmapFactory.decodeResource(res, R.drawable.spider))
                    .setTicker("Быстро вернись в указанную зону")
                    .setContentText("Ты должен вернуться в заданную зону во избежания последствий")
                    .setContentTitle("ATTENTION");
            Notification notification = builder.build();

            NotificationManager notificationManager = (NotificationManager) context
                    .getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(NOTIFY_ID, notification);
        }

    }

}
