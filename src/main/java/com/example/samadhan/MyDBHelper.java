package com.example.samadhan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="MYDB";
    private static final int DATABASE_VERSION=1;

    private static final String TABLE_RECIPIENT="recipient_info";
    private static final String REC_MOB_NO="rec_mob_no";
    private static final String REC_NAME="rec_name";
    private static final String REC_PASSWORD="rec_password";

    private static final String TABLE_TECHNICIAN="technician_info";
    private static final String TEC_EMP_NO="tec_emp_no";
    private static final String TEC_PASSWORD="tec_password";

    private static final String TABLE_ADMIN="admin_info";
    private static final String ADM_EMP_NO="adm_emp_no";
    private static final String ADM_PASSWORD="adm_password";

    private static final String TABLE_COMPLAINT="comp_table";
    private static final String COM_IMAGE="com_image";
    private static final String COM_LONG="com_longitude";
    private static final String COM_LAT="com_latitude";
    private static final String COM_REC_MOB="com_rec_mob";
    private static final String COM_ID="com_id";


    public MyDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_RECIPIENT + "(" + REC_MOB_NO + "text primary key ," + REC_NAME + "text," + REC_PASSWORD + "text)");
        db.execSQL("create table " + TABLE_TECHNICIAN + "(" + TEC_EMP_NO + "text primary key ," + TEC_PASSWORD + "text)");
        db.execSQL("create table " + TABLE_ADMIN + "(" + ADM_EMP_NO + "text primary key ," + ADM_PASSWORD + "text)");
        db.execSQL("create table "+TABLE_COMPLAINT+"("+COM_ID+" integer primary key autoincrement,"+ COM_LONG +" integer ,"+ COM_LAT +" integer ,"+ COM_REC_MOB+"text ,foreign key(COM_REC_MOB) references "+TABLE_RECIPIENT+"(REC_MOB_NO))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECIPIENT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ADMIN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TECHNICIAN);
        db.execSQL("drop table if exists "+ TABLE_COMPLAINT);

        onCreate(db);
    }

    public void add_recipient(String mob_no,String name,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(REC_NAME,name);
        values.put(REC_MOB_NO,mob_no);
        values.put(REC_PASSWORD, password);
        db.insert(TABLE_RECIPIENT,null, values);
        Log.d("mayankdb","succefully added data");
    }


//    public void add_recipient(String mob_no,String name,String password){
//        SQLiteDatabase db=this.getWritableDatabase();
//        db.execSQL("insert into "+TABLE_RECIPIENT+" values("+mob_no+","+name+","+password+")");
//    }


    public void add_technician(String emp_no,String password)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(TEC_EMP_NO,emp_no);
        values.put(TEC_PASSWORD,password);
        db.insert(TABLE_TECHNICIAN,null,values);
    }

    public ArrayList<Recipient_Details> get_rec_details(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from "+ TABLE_RECIPIENT,null);
        ArrayList<Recipient_Details> arrDetails=new ArrayList<>();
        while(cursor.moveToNext()){
             Recipient_Details model=new Recipient_Details();
             model.name=cursor.getString(0);
             model.number=cursor.getString(1);
             model.password= cursor.getString(2);

             arrDetails.add(model);

        }
        return arrDetails;
    }
}
