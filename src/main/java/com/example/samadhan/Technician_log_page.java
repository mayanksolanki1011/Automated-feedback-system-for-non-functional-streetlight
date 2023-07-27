package com.example.samadhan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Technician_log_page extends AppCompatActivity {
Button btnTecLog;
Intent iLogTec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technician_log_page);
        btnTecLog=findViewById(R.id.btnTecLog);
        btnTecLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iLogTec=new Intent(getApplicationContext(),Technician_home.class);
                startActivity(iLogTec);
            }
        });
    }
}