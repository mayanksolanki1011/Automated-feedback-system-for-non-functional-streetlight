package com.example.samadhan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btnLogin,btnReg;
Intent iLogPg,iRegPg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        MyDBHelper dbHelper=new MyDBHelper(this);
//        dbHelper.add_recipient("mayank","8959398795","mayank1011");


        btnLogin=findViewById(R.id.btnLogin);
        btnReg=findViewById(R.id.btnReg);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iLogPg = new Intent(getApplicationContext(),Login_page.class);
                startActivity(iLogPg);
            }
        });
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iRegPg=new Intent(getApplicationContext(),Register_page.class);
                startActivity(iRegPg);
            }
        });
    }
}