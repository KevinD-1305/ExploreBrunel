package com.example.cs17kkd.explorebrunel;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

public class Main extends AppCompatActivity implements OnMapReadyCallback/*implements OnMapReadyCallback*/{
    private ActionBar actionBar;
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        Intent in;

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.settings:
                    in = new Intent(getBaseContext(),Settings.class);
                    startActivity(in);
                    break;
                case R.id.categories:
                    in = new Intent(getBaseContext(),Categories.class);
                    startActivity(in);
                    break;
                case R.id.favourites:
                    in = new Intent(getBaseContext(),Favourites.class);
                    startActivity(in);
                    break;
                    default:
            }
            return false;
        }
    };
    private SupportMapFragment map;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Brunel and move the camera
        LatLng Brunel = new LatLng(51.5328859, -0.4751111);
        mMap.addMarker(new MarkerOptions().position(Brunel).title("Marker in Brunel"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Brunel));

        LatLngBounds Brunel1 = new LatLngBounds(
                new LatLng(51.53278, -0.48246), new LatLng(51.53309, -0.46751));

        // Set the camera to the greatest possible zoom level that includes the
        // bounds
        mMap.setLatLngBoundsForCameraTarget(Brunel1);
        mMap.animateCamera(CameraUpdateFactory.zoomBy(13));
        // mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(Brunel1, 0));
    }
}

