package com.example.cs17kkd.explorebrunel;

import android.content.Intent;
import android.graphics.Camera;
import android.location.Address;
import android.location.Geocoder;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
//import com.google.android.gms.location.places.Place;
//import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
//import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.model.Marker;
import com.google.android.libraries.places.api.Places;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main extends AppCompatActivity implements OnMapReadyCallback {
    //search text
    private EditText mSearchText;
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
    private GoogleMap mMap;
    //PlaceAutocompleteFragment placeAutoComplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        //Sets the bottom navigation bar at the bottom.
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //Search bar for the map to search for location.

        Places.initialize(getApplicationContext(), "AIzaSyCnTBUkfvILavRXaRYMTuJuDUEc4UK6jnM");
        PlacesClient placesClient = Places.createClient(this);

        if (!Places.isInitialized()) {
            Places.initialize(getApplicationContext(), "AIzaSyCnTBUkfvILavRXaRYMTuJuDUEc4UK6jnM");
        }

        // Initialize the AutocompleteSupportFragment.
        AutocompleteSupportFragment autocompleteFragment = (AutocompleteSupportFragment)
                getSupportFragmentManager().findFragmentById(R.id.autocomplete_fragment);

        autocompleteFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME,Place.Field.LAT_LNG));
        autocompleteFragment.setCountry("UK");
        //mSearchText = (EditText) findViewById(R.id.autocomplete_fragment);

        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {

                Log.d("Maps", "Place selected: " + place.getName() + place.getLatLng());
                //Moves camera so to the LatLng of the location entered.
                mMap.animateCamera(CameraUpdateFactory.newLatLng(place.getLatLng()));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(place.getLatLng(), 18.0f));
                //Adds marker to the location and names it.
                mMap.addMarker(new MarkerOptions().position(place.getLatLng()).title("Marker in " + place.getName()));


            }

            @Override
            public void onError(Status status) {
                Log.d("Maps", "An error occurred: " + status);
            }
        });

        SupportMapFragment mapFragment1 = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment1.getMapAsync(this);
    }
    /*private void geoLocate() {
        //Log.d(TAG, "geoLocate: geoLocating");
        String searchString = mSearchText.getText().toString();
        Geocoder geocoder = new Geocoder(Main.this);
        List<Address> list = new ArrayList<>();
        try {
            list = geocoder.getFromLocationName(searchString, 1);
        }catch (IOException e){
            //Log.e(TAG, "geoLocate:  IOException:  " + e.getMessage());
        }
        if(list.size() > 0) {
            Address address = list.get(0);
            //Log.d(TAG, "geoLocate: found a location" + address.toString());
        }
    }
    */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Brunel and move the camera
        LatLng Brunel = new LatLng(51.5328859, -0.4751111);
        LatLng Wilfred_brown = new LatLng(51.532791, -0.475213);
        LatLng Eastern_Gateway = new LatLng(51.533347, -0.468689);
        LatLng Antonlin_Artaud = new LatLng(51.531046, -0.474961);
        LatLng Mary_Seacole = new LatLng(51.532893, -0.468457);
        LatLng Bannerman_Centre = new LatLng(51.532751, -0.473927);
        LatLng Halsbury = new LatLng(51.534211, -0.4729280);
        LatLng Lecture_Centre = new LatLng(51.533245, -0.472851);
        LatLng Joseph_Lowe = new LatLng(51.530925, -0.474071);
        LatLng Heinz_Wolff = new LatLng(51.534145, -0.474734);
        LatLng Gaskell = new LatLng(51.533003, -0.477658);




        mMap.addMarker(new MarkerOptions().position(Brunel).title("Marker in Brunel"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Brunel));
        mMap.animateCamera(CameraUpdateFactory.zoomBy(13));

        LatLngBounds Brunel1 = new LatLngBounds(
                new LatLng(51.53278, -0.48246), new LatLng(51.53309, -0.46751));

        // Set the camera to the greatest possible zoom level that includes the bounds
        //Limits the Boundaries to only Brunel.
        mMap.setLatLngBoundsForCameraTarget(Brunel1);


        mMap.addMarker(
                new MarkerOptions().position(Wilfred_brown).title("Wilfred Brown").snippet("Building for COMPUTER SCIENCE STUDENTS"));

        mMap.addMarker(
                new MarkerOptions().position(Eastern_Gateway).title("Eastern Gateway").snippet("Building for BUSINESS  STUDENTS"));

        mMap.addMarker(
                new MarkerOptions().position(Antonlin_Artaud).title("Antonlin Artaud").snippet("Building for ARTS  STUDENTS"));

        mMap.addMarker(
                new MarkerOptions().position(Mary_Seacole).title("Mary Seacole").snippet("Building for CLINICAL SCIENCE STUDENTS"));

        mMap.addMarker(
                new MarkerOptions().position(Bannerman_Centre).title("Bannerman Centre").snippet("Building for ALL STUDENTS"));

        mMap.addMarker(
                new MarkerOptions().position(Halsbury).title("Halsbury").snippet("Building for EDUCATION,BIOMED AND COMPUTER SCIENCE STUDENTS"));

        mMap.addMarker(
                new MarkerOptions().position(Lecture_Centre).title("Lecture Centre").snippet("Building for ALL  STUDENTS"));

        mMap.addMarker(
                new MarkerOptions().position(Joseph_Lowe).title("Joseph Lowe").snippet("Building for CIVIL ENGINEERING STUDENTS"));

        mMap.addMarker(
                new MarkerOptions().position(Heinz_Wolff).title("Heinz_Wolff").snippet("Building for SPORT SCIENCE STUDENTS"));

        mMap.addMarker(
                new MarkerOptions().position(Gaskell).title("Gaskell").snippet("Building for PSYCHOLOGY  STUDENTS"));

    }
}





