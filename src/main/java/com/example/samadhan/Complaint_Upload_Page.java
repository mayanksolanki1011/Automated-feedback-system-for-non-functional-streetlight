package com.example.samadhan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class Complaint_Upload_Page extends AppCompatActivity implements LocationListener {
ImageView imgUpload;
Intent iImage;
Button btnSltLoc,btnSubCom;
Intent iComSub;
LocationManager locationManager;
private final int CAMERA_REQ_CODE=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_upload_page);
        btnSltLoc=findViewById(R.id.btnSltLoc);
        btnSubCom=findViewById(R.id.btnSubCom);
        if(ContextCompat.checkSelfPermission(Complaint_Upload_Page.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(Complaint_Upload_Page.this,new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            },100);
        }
        btnSltLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLocation();
            }
        });
        imgUpload=findViewById(R.id.imgUpload);
        imgUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iImage=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(iImage,CAMERA_REQ_CODE);
            }
        });
        btnSubCom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Complaint_Upload_Page.this, "Complaint uploaded successfully", Toast.LENGTH_SHORT).show();
                iComSub=new Intent(getApplicationContext(),Recipient_Home_Page.class);
                startActivity(iComSub);
            }
        });
    }

    @SuppressLint("MissingPermission")
    private void getLocation() {
        try{
            locationManager=(LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,3000,5,Complaint_Upload_Page.this);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    @Override
    public void onLocationChanged(@NonNull Location location) {
        Toast.makeText(this, "Location stored: "+location.getLatitude()+","+location.getLongitude(), Toast.LENGTH_SHORT).show();
        try{
            Geocoder geocoder=new Geocoder(Complaint_Upload_Page.this, Locale.getDefault());
            List<Address> addresses= geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
            String address= addresses.get(0).getAddressLine(0);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK)
        {
            if(requestCode==CAMERA_REQ_CODE)
            {
               Bitmap img = (Bitmap)data.getExtras().get("data");
                imgUpload.setImageBitmap(img);
            }

        }
    }
}