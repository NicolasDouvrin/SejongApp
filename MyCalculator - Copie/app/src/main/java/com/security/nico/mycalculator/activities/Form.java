package com.security.nico.mycalculator.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.security.nico.mycalculator.R;
import com.security.nico.mycalculator.model.Student;

public class Form extends AppCompatActivity implements View.OnClickListener {
    final static String STUDENT_KEY = "STUDENT";
    EditText nameEdit, emailEdit;
    TextView seekbarResult;
    RadioGroup radioGroup;
    RadioButton civRadio, ceRadio, fashRadio, othersRadio;
    SeekBar moodSeekbar;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);

        nameEdit = (EditText) findViewById(R.id.edName);
        emailEdit = (EditText) findViewById(R.id.edEmail);
        seekbarResult = (TextView) findViewById(R.id.seekbarResult);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        civRadio = (RadioButton) findViewById(R.id.civRadioButton);
        ceRadio = (RadioButton) findViewById(R.id.ceRadioButton);
        fashRadio = (RadioButton) findViewById(R.id.fashRadioButton);
        othersRadio = (RadioButton) findViewById(R.id.othersRadioButton);
        moodSeekbar = (SeekBar) findViewById(R.id.moodSeekBar);

        moodSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekBar.setProgress(i);
                seekbarResult.setText(i + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        submit = (Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (nameEdit.getText().toString().length() == 0)
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
        else if (emailEdit.getText().toString().length() == 0)
            Toast.makeText(this, "Please enter an email address", Toast.LENGTH_LONG).show();
        else {
            String studentName = nameEdit.getText().toString();
            String studentEmail = emailEdit.getText().toString();
            String department = "";
            int mood = moodSeekbar.getProgress();
            switch (radioGroup.getCheckedRadioButtonId()) {
                case R.id.civRadioButton:
                    department = "CIV";
                    break;
                case R.id.ceRadioButton:
                    department = "CE";
                    break;
                case R.id.fashRadioButton:
                    department = "FASH";
                    break;
                case R.id.othersRadioButton:
                    department = "Others";
                    break;
            }

            Student student = new Student(studentName, studentEmail, department, mood);
            Intent intent = new Intent(this, Display.class);
            intent.putExtra(STUDENT_KEY, (Student) student);
            startActivity(intent);
        }
    }
}