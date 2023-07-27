package com.example.samadhan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Recipient_Login_Page extends AppCompatActivity {
Button btnRecipientLog;
EditText edtLogNo,edtLogPass;
Intent iRecHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipient_login_page);

        btnRecipientLog=findViewById(R.id.btnRecipientLog);
        edtLogNo=findViewById(R.id.edtLogNo);
        edtLogPass=findViewById(R.id.edtLogPass);

//        MyDBHelper dbHelper=new MyDBHelper(this);
//


        btnRecipientLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iRecHome=new Intent(getApplicationContext(),Recipient_Home_Page.class);
                startActivity(iRecHome);

            }
        });
    }
}