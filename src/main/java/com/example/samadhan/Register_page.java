package com.example.samadhan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Register_page extends AppCompatActivity {
EditText edtRegName,edtRegNo,edtPassword;
Button btnRegister;
Intent iRegbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        edtRegName=findViewById(R.id.edtRegName);
        edtRegNo=findViewById(R.id.edtRegNo);
        edtPassword=findViewById(R.id.edtPassword);
        btnRegister=findViewById(R.id.btnRegister);

        MyDBHelper dbHelper=new MyDBHelper(this);
//        dbHelper.add_recipient("8959398795","mayank","mayank1011");
//        dbHelper.add_technician("tec20321","my1234");

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               dbHelper.add_recipient(edtRegName.getText().toString(),edtRegNo.getText().toString(),edtPassword.getText().toString());
               ArrayList<Recipient_Details> arrDetails=dbHelper.get_rec_details();
               for(int i=0;i<arrDetails.size();i++)
               {
                   Log.d("rec_info","name: "+arrDetails.get(i).name+", Number: "+arrDetails.get(i).number+", password: "+arrDetails.get(i).password);
               }
                iRegbtn=new Intent(getApplicationContext(),Recipient_Home_Page.class);
                startActivity(iRegbtn);
            }
        });
    }

}