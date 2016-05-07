package com.mad.hovansu.soccersocialnetwork.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mad.hovansu.soccersocialnetwork.R;

public class DetailFieldActivity extends AppCompatActivity implements OnMapReadyCallback{

    private GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_field);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap map) {
        this.googleMap = map;
        LatLng field = new LatLng(16.065073, 108.150941);
        this.googleMap.addMarker(new MarkerOptions().position(field).title("Field_1"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(field));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);

    }
}
