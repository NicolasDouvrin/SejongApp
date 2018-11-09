package com.security.nico.mycalculator.activities;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.security.nico.mycalculator.R;
import com.security.nico.mycalculator.sql.DatabaseHelper;
import com.security.nico.mycalculator.sql.SQLController;

public class Members extends Activity {

    TableLayout table_layout;
    EditText Name, Email;

    SQLController sqlcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_members);

        sqlcon = new SQLController(this);

        Name = (EditText) findViewById(R.id.name);
        Email = (EditText) findViewById(R.id.email);
        table_layout = (TableLayout) findViewById(R.id.tablelayout);

        BuildTable();
    }

    private void BuildTable() {

        sqlcon.open();
        Cursor c = sqlcon.readEntry();

        int rows = c.getCount();
        if (rows==0){
            rows=1;
        }

        c.moveToFirst();

        // outer for loop
        for (int i = 0; i < rows; i++) {

            TableRow row = new TableRow(this);
            row.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));

            // inner for loop
            for (int j = 0; j < 3; j++) {

                TextView tv = new TextView(this);
                tv.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT,
                        TableLayout.LayoutParams.WRAP_CONTENT));
                tv.setGravity(Gravity.CENTER);
                tv.setTextSize(18);
                tv.setPadding(0, 5, 0, 5);

                tv.setText(c.getString(j));

                row.addView(tv);
            }

            c.moveToNext();

            table_layout.addView(row);

        }
        sqlcon.close();
    }

}

