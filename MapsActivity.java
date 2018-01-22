package com.example.student.myapplication123;

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
    public int ind = 0;

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
        LatLng sydney = new LatLng(-34, 151);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public void onMapClick(LatLng point) {
        final EditText edit;
        TextView view;
        view = (TextView)  findViewById(R.id.textView);
        edit = (EditText) findViewById(R.id.editText);
        final int rad = Integer.parseInt(edit.getText().toString());
        CircleOptions circleOptions = new CircleOptions()
                .center(point)
                .radius(rad)
                .clickable(true);
        Circle circle = mMap.addCircle(circleOptions);
        coord[ind][0] = point.latitude;
        coord[ind][1] = point.longitude;
        coord[ind][2] = rad;
        ind++;
        view.setText(String.valueOf(ind));
        mMap.setOnCircleClickListener(new GoogleMap.OnCircleClickListener() {

            @Override
            public void onCircleClick(Circle circle) {
                circle.setRadius(rad);
            }
        });
    }

    public void Culick(View view) {
        //make file
    }
}
