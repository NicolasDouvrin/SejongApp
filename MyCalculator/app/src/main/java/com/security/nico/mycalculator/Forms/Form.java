package com.security.nico.mycalculator.forms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.security.nico.mycalculator.R;

public class Form extends AppCompatActivity implements View.OnClickListener {

    EditText nameEdit, emailEdit, ageEdit, natEdit;
    Button submit;
    final static String STUDENT_KEY = "STUDENT";
    final static String STUDENT_NAME = "NAME";
    final static String STUDENT_EMAIL = "EMAIL";
    final static String STUDENT_AGE = "AGE";
    final static String STUDENT_NAT = "NAT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        nameEdit = (EditText) findViewById(R.id.edName);
        emailEdit = (EditText) findViewById(R.id.edEmail);
        ageEdit = (EditText) findViewById(R.id.edAge);
        natEdit = (EditText) findViewById(R.id.edNat);
        submit = (Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (nameEdit.getText().toString().length() == 0)
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
        else if (emailEdit.getText().toString().length() == 0)
            Toast.makeText(this, "Please enter an email address", Toast.LENGTH_LONG).show();
        else if (ageEdit.getText().toString().length() == 0)
            Toast.makeText(this, "Please enter an age", Toast.LENGTH_LONG).show();
        else if (natEdit.getText().toString().length() == 0)
            Toast.makeText(this, "Please enter an nationality", Toast.LENGTH_LONG).show();
        else {
            String studentName = nameEdit.getText().toString();
            String studentEmail = emailEdit.getText().toString();
            String studentAge = ageEdit.getText().toString();
            String studentNat = natEdit.getText().toString();

            Intent intent = new Intent(this, Form2.class);
            intent.putExtra(STUDENT_NAME, studentName);
            intent.putExtra(STUDENT_EMAIL, studentEmail);
            intent.putExtra(STUDENT_AGE, studentAge);
            intent.putExtra(STUDENT_NAT, studentNat);
            startActivity(intent);
        }
    }
}