package com.example.binusezyfood;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap Loc;
    ArrayList<LatLng> arrayList = new ArrayList<LatLng>();
    LatLng EzyFoodyJakarta = new LatLng(-6.1952, 106.8204);
    LatLng EzyFoodyBogor = new LatLng(-6.5980, 106.7975);
    LatLng EzyFoodyDepok = new LatLng(-6.4025, 106.7942);
    LatLng EzyFoodyGS = new LatLng(-6.2411, 106.6285);
    LatLng EzyFoodyBekasi = new LatLng(-6.2260, 107.0011);
    LatLng EzyFoodyBandung = new LatLng(-6.8915, 107.6107);
    LatLng EzyFoodyCirebon = new LatLng(-6.737246, 108.550659);
    LatLng EzyFoodySurabaya = new LatLng(-7.250445, 112.768845);
    LatLng EzyFoodyLampung = new LatLng(-5.450000, 105.266670);
    LatLng EzyFoodySemarang = new LatLng(-6.966667, 110.416664);

    private String[] name = {"EzyFoody Jakarta", "EzyFoody Bogor", "EzyFoody Depok",
            "EzyFoody Gading Serpong", "EzyFoody Bekasi", "EzyFoody Bandung", "EzyFoody Cirebon",
            "EzyFoody Surabaya","EzyFoody Lampung","EzyFoody Semarang"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        arrayList.add(EzyFoodyJakarta);
        arrayList.add(EzyFoodyBogor);
        arrayList.add(EzyFoodyDepok);
        arrayList.add(EzyFoodyGS);
        arrayList.add(EzyFoodyBekasi);
        arrayList.add(EzyFoodyBandung);
        arrayList.add(EzyFoodyCirebon);
        arrayList.add(EzyFoodySurabaya);
        arrayList.add(EzyFoodyLampung);
        arrayList.add(EzyFoodySemarang);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        Loc = googleMap;

        // Add a marker in Sydney and move the camera
        for (int i = 0;i<arrayList.size();i++){
            Loc.addMarker(new MarkerOptions().position(arrayList.get(i)).title(name[i]));
            CameraPosition cameraPosition = new CameraPosition.Builder().target(arrayList.get(i)).zoom(17).build();
            Loc.moveCamera(CameraUpdateFactory.newLatLng(arrayList.get(i)));
        }
    }
}