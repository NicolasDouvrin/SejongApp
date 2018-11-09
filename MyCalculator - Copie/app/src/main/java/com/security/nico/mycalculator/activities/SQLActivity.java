package com.security.nico.mycalculator.activities;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.security.nico.mycalculator.R;

public class SQLActivity extends AppCompatActivity implements View.OnClickListener{
    EditText etName, etEmail, etSearch, etAge;
    SQLiteDatabase sqlitedb;
    Button btnSave, btnUpdate, btnDelete, btnSelect, btnSelAll;
    String name, email, age, search;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);

        sqlitedb = openOrCreateDatabase("StudentDB", Context.MODE_PRIVATE, null);
        sqlitedb.execSQL("CREATE TABLE IF NOT EXISTS StudentRegistreation(STID INTEGER KEY AUTOINCREAMENT, StName VARCHAR(255), StEmail VARCHAR(255), StAge VARCHAR(255))");

        etSearch = (EditText) findViewById(R.id.etSearch);
        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etAge = (EditText) findViewById(R.id.etAge);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnSelect = (Button) findViewById(R.id.btnSelect);
        btnSelAll = (Button) findViewById(R.id.btnSelAll);
        btnDelete = (Button) findViewById(R.id.btnDelete);

        btnSave.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnSelect.setOnClickListener(this);
        btnSelAll.setOnClickListener(this);
    }

        @Override public void onClick(View v) {

        if (v.getId() == R.id.btnSave){
            name = etName.getText().toString().trim();
            email = etEmail.getText().toString().trim();
            age = etAge.getText().toString().trim();
            if(name.equals("")||email.equals("")||age.equals("")){
                Toast.makeText(this, "Please fill up all the fields!",
                        Toast.LENGTH_SHORT).show();
                return;
            }else {
                sqlitedb.execSQL("Insert Into" +
                        " StudentRegistreation(StName,StEmail,StAge)VALUES('"+name+"','"+email+"','"+age+"');" +
                        " ");
                Toast.makeText(this,"Record Saved", Toast.LENGTH_SHORT).show();
            }
        } else if(v.getId()==R.id.btnSelAll){
            Cursor c=sqlitedb.rawQuery("Select * From StudentRegistreation", null);
            if(c.getCount()==0){
                Toast.makeText(this,"Database is Empty", Toast.LENGTH_SHORT).show();
                return;
            }
            StringBuffer buffer=new StringBuffer();
            while (c.moveToNext()){
                buffer.append("Student Name:"+c.getString(1)+"\n");
                buffer.append("Student Email:"+c.getString(2)+"\n");
                buffer.append("Student Age:"+c.getString(3)+"\n");
            }
            Toast.makeText(this, buffer.toString(), Toast.LENGTH_LONG).show();
        }else if(v.getId()==R.id.btnSelect){
            search = etSearch.getText().toString().trim();
            if(search.equals("")){
                Toast.makeText(this, "Enter Student Name", Toast.LENGTH_SHORT).show();
                return;
            }
            Cursor c=sqlitedb.rawQuery("Select * From StudentRegistreation Where StName='"+ search+"'",null);
            if(c.moveToFirst()){
                etName.setText(c.getString(1));
                etEmail.setText(c.getString(2));
                etAge.setText(c.getString(3));
            }else {
                Toast.makeText(this, "Data Not Found", Toast.LENGTH_SHORT).show();
            }
        }else if(v.getId()==R.id.btnUpdate){
            search=etSearch.getText().toString().trim();
            name=etName.getText().toString().trim();
            email=etEmail.getText().toString().trim();
            age = etAge.getText().toString().trim();
            if(search.equals("")){
                Toast.makeText(this, "Please Enter Student Name to Update", Toast.LENGTH_SHORT).show();
                return;
            }
            Cursor cursorupdate = sqlitedb.rawQuery("Select * From StudentRegistreation Where StName='"+ search+"'",null);
            if(cursorupdate.moveToFirst()){
                if(name.equals("")||email.equals("")||age.equals("")){
                    Toast.makeText(this, "Please enter new infromation", Toast.LENGTH_SHORT).show();
                return;
                }else {
                    sqlitedb.execSQL("Update StudentRegistreation Set StName ='"+name+"', StEmail='"+email+"',StAge='"+age+"' Where StName='"+search+"'");
                    Toast.makeText(this, "Record Modified", Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(this, "Data Not Found", Toast.LENGTH_SHORT).show();
            }
        }else if(v.getId()==R.id.btnDelete){
            search=etSearch.getText().toString().trim();
            if(search.equals("")){
                Toast.makeText(this, "Enter Student Name to Delete",Toast.LENGTH_SHORT).show();
                return;
            }
            Cursor cursordel = sqlitedb.rawQuery("Select * From StudentRegistreation Where StName = '"+search+"'",null);
            if(cursordel.moveToFirst()){
                sqlitedb.execSQL("Delete From StudentRegistreation Where StName = '"+search+"'");
                Toast.makeText(this, "Record Deleted", Toast.LENGTH_SHORT).show();
            } else{
                Toast.makeText(this, "Data not Found", Toast.LENGTH_SHORT).show();
            }
        }
        }
    }

