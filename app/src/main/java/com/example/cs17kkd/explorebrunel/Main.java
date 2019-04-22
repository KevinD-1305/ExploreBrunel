package com.example.cs17kkd.explorebrunel;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
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

import java.util.Arrays;


public class Main extends AppCompatActivity implements OnMapReadyCallback {
    //search text
    private EditText mSearchText;
    //Lecture Centre Marker
    private Marker lcMarker;
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
                new MarkerOptions().position(Wilfred_brown).title("Wilfred Brown"));

        mMap.addMarker(
                new MarkerOptions().position(Eastern_Gateway).title("Eastern Gateway"));

        mMap.addMarker(
                new MarkerOptions().position(Antonlin_Artaud).title("Antonlin Artaud"));

        mMap.addMarker(
                new MarkerOptions().position(Mary_Seacole).title("Mary Seacole"));

        mMap.addMarker(
                new MarkerOptions().position(Bannerman_Centre).title("Bannerman Centre"));

        mMap.addMarker(
                new MarkerOptions().position(Halsbury).title("Halsbury"));

        //Lecture Centre Marker Object
        lcMarker = mMap.addMarker(
                new MarkerOptions().position(Lecture_Centre).title("Lecture Centre"));

        mMap.addMarker(
                new MarkerOptions().position(Joseph_Lowe).title("Joseph Lowe"));

        mMap.addMarker(
                new MarkerOptions().position(Gaskell).title("Heinz_Wolff"));

        mMap.addMarker(
                new MarkerOptions().position(Gaskell).title("Gaskell"));

        if (mMap != null){
            mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
                @Override
                public View getInfoWindow(Marker marker) {
                    return null;
                }

                @Override
                public View getInfoContents(Marker marker) {
                    View v = getLayoutInflater().inflate(R.layout.info_window, null);
                    TextView nametv = (TextView) v.findViewById(R.id.nameTV);
                    ImageView markerimg = (ImageView) v.findViewById(R.id.infowindow_icon);

                    nametv.setText(marker.getTitle());
                    markerimg.setImageDrawable(getResources().getDrawable(R.drawable.lecture_centre_image));
                    if (marker.getTitle().contains("Lecture Centre")){
                        markerimg.setImageDrawable(getResources().getDrawable(R.drawable.lecture_centre_image));
                    }else{
                        markerimg.setImageDrawable(getResources().getDrawable(R.drawable.app_logo));
                    }
                    return v;
                }
            });

            //Info window click function
            mMap.setOnInfoWindowLongClickListener(new GoogleMap.OnInfoWindowLongClickListener() {
                @Override
                public void onInfoWindowLongClick(Marker marker) {
                    if(marker.getTitle().contains("Lecture Centre")){
                        Toast.makeText(Main.this, "You Have Clicked the Lecture Centre", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(Main.this,LectureCentreInfo.class);
                        startActivity(i);
                        finish();
                    }else{
                        Toast.makeText(Main.this, marker.getTitle(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        }

    }



