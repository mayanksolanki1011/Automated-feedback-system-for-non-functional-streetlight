package com.example.samadhan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login_page extends AppCompatActivity {
Button btnLogRec,btnLogTec,btnLogAd;
Intent iRecHomePg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        btnLogRec=findViewById(R.id.btnLogRec);
        btnLogTec=findViewById(R.id.BtnLogTec);
        btnLogAd=findViewById(R.id.BtnLogAd);
        btnLogRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iRecHomePg=new Intent(getApplicationContext(),Recipient_Login_Page.class);
                startActivity(iRecHomePg);
            }
        });
        btnLogTec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iLogTec=new Intent(getApplicationContext(),Technician_log_page.class);
                startActivity(iLogTec);
            }
        });
        btnLogAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}