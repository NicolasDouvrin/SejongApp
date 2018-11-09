package com.security.nico.mycalculator.Forms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.security.nico.mycalculator.R;

public class Form extends AppCompatActivity implements View.OnClickListener {
    final static String NAME = "STUDENT";
    final static String EMAIL = "STUDENT";
    final static String AGE = "STUDENT";
    final static String NAT = "STUDENT";
    EditText nameEdit, emailEdit, ageEdit, natEdit;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        nameEdit = (EditText) findViewById(R.id.edName);
        emailEdit = (EditText) findViewById(R.id.edEmail);
        submit = (Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (nameEdit.getText().toString().length() == 0)
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
        if (emailEdit.getText().toString().length() == 0)
            Toast.makeText(this, "Please enter an email address", Toast.LENGTH_LONG).show();
        if (ageEdit.getText().toString().length() == 0)
            Toast.makeText(this, "Please enter an age", Toast.LENGTH_LONG).show();
        if (natEdit.getText().toString().length() == 0)
            Toast.makeText(this, "Please enter an nationality", Toast.LENGTH_LONG).show();
        else {
            String studentName = nameEdit.getText().toString();
            String studentEmail = emailEdit.getText().toString();
            String studentAge = ageEdit.getText().toString();
            String studentNat = natEdit.getText().toString();
            Intent intent = new Intent(this, Form2.class);
            intent.putExtra(NAME, studentName);
            intent.putExtra(EMAIL, studentEmail);
            intent.putExtra(AGE, studentAge);
            intent.putExtra(NAT, studentNat);
            startActivity(intent);
        }
    }
}