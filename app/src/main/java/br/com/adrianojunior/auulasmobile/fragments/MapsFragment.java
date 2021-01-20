package br.com.adrianojunior.auulasmobile.fragments;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import br.com.adrianojunior.auulasmobile.R;
import livroandroid.lib.utils.PermissionUtils;

public class MapsFragment extends BaseFragment {

    private Button btnMapa;
    private EditText localTxt;
    private EditText latTxt;
    private EditText lngTxt;
    private SupportMapFragment mapFragment;
    private GoogleMap mGoogleMap;

    boolean ok;

    LocationManager locationManager;

    void checkPermissions() {
        if (ActivityCompat.checkSelfPermission(getContext(),
                Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED

                && ActivityCompat.checkSelfPermission(getContext(),
                Manifest.permission.ACCESS_NETWORK_STATE) == PackageManager.PERMISSION_GRANTED


                && ActivityCompat.checkSelfPermission(getContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED

                && ActivityCompat.checkSelfPermission(getContext(),
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            toast("Permissões concedidas");
            ok = true;
        } else {
            ok = false;
            requestPermissions();
        }
    }

    void requestPermissions() {

        String permissions[] = new String[]{
                Manifest.permission.INTERNET,
                Manifest.permission.ACCESS_NETWORK_STATE,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,};

        ok = PermissionUtils.validate(getAppCompatActivity(), 0, permissions);
        if (!ok) {
            requestPermissions();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        checkPermissions();
    }

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {

            if (ContextCompat.checkSelfPermission(getContext(),
                    Manifest.permission.ACCESS_COARSE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED
                    &&
                    ContextCompat.checkSelfPermission(getContext(),
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED)
                googleMap.setMyLocationEnabled(true);
            Location location = googleMap.getMyLocation();
            LatLng myLatLng = new LatLng(location.getLatitude(), location.getLongitude());
            googleMap.addMarker(new MarkerOptions().position(myLatLng).title("Minha localização"));
            googleMap.setMinZoomPreference(18);
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(myLatLng));

            /*LatLng sydney = new LatLng(-34, 151);
            googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        btnMapa = view.findViewById(R.id.btn_search);
        localTxt = view.findViewById(R.id.local_text);
        latTxt = view.findViewById(R.id.lat_text);

        lngTxt = view.findViewById(R.id.lng_text);

        if (mapFragment != null && ok) {
            mapFragment.getMapAsync(callback);
        }

        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mapFragment != null && ok) {
                    mapFragment.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(GoogleMap googleMap) {

                            mGoogleMap = googleMap;

                            if (mGoogleMap != null) {
                                mapFragment.setHasOptionsMenu(true);

                                if (!latTxt.getText().toString().isEmpty() && latTxt.getText().toString() != null
                                        && !lngTxt.getText().toString().isEmpty() && lngTxt.getText().toString() != null
                                        && localTxt.getText().toString() != null && !localTxt.getText().toString().isEmpty()) {
                                    Double lat = Double.parseDouble(latTxt.getText().toString().replace(",", "."));
                                    Double lng = Double.parseDouble(lngTxt.getText().toString().replace(",", "."));
                                    String local = localTxt.getText().toString();
                                    latTxt.setText(latTxt.getText().toString().replace(",","."));
                                    lngTxt.setText(lngTxt.getText().toString().replace(",","."));

                                    if (lat != null && lng != null) {
                                        LatLng position = new LatLng(lat, lng);
                                        mGoogleMap.addMarker(new MarkerOptions().position(position).title(local));
                                        googleMap.setMinZoomPreference(15);
                                        googleMap.moveCamera(CameraUpdateFactory.newLatLng(position));
                                    }
                                }


                            }
                        }


                    });
                }
            }
        });
    }
}