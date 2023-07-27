package com.example.samadhan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Recipient_Home_Page extends AppCompatActivity {
Button btnUpCom;
Intent iComPg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipient_home_page);
        btnUpCom=findViewById(R.id.btnUpCom);
        btnUpCom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iComPg=new Intent(getApplicationContext(),Complaint_Upload_Page.class);
                startActivity(iComPg);
            }
        });
    }
}