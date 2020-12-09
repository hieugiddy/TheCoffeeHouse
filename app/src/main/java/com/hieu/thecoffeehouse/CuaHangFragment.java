package com.hieu.thecoffeehouse;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;


import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;


public class CuaHangFragment extends Fragment implements OnMapReadyCallback {
    GoogleMap map;
    Spinner spnDiaDiem;
    CategoryAdapter categoryAdapter;
    private FusedLocationProviderClient fusedLocationClient; //Location
    String latitude,longitude;
    View myFragment;
    private TabLayout mTabLayout;
    private ViewPager mviewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.fragment_cuahang, container, false);
        spnDiaDiem=myFragment.findViewById(R.id.spinner);
        SupportMapFragment supportMapFragment=(SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        categoryAdapter = new CategoryAdapter(getActivity(), R.layout.item_selected, getListCategory());
        spnDiaDiem.setAdapter(categoryAdapter);
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(getActivity());

        supportMapFragment.getMapAsync(this);
        return myFragment;
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        map=googleMap;
        LatLng current=new LatLng(16.0767282,108.2118856);
        map.addMarker(new MarkerOptions().position(current).title("48 Cao Thắng"));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(current,20));
    }
    public List<Category> getListCategory(){
        List<Category> list = new ArrayList<>();
        list.add(new Category("Quận Hải Châu"));
        list.add(new Category("Quận Ngũ Hành Sơn"));
        list.add(new Category("Quận Sơn Trà"));
        list.add(new Category("Quận Cẩm Lệ"));
        list.add(new Category("Quận 3"));
        list.add(new Category("Quận Liên Chiểu"));
        list.add(new Category("Quận Thanh Khuê"));
        list.add(new Category("Huyện Hòa Vang"));
        return list;
    }

}