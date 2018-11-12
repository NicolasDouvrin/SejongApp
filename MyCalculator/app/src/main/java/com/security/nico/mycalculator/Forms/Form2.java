package com.security.nico.mycalculator.forms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.security.nico.mycalculator.R;
import com.security.nico.mycalculator.model.Student;

public class Form2 extends AppCompatActivity implements View.OnClickListener {

    final static String STUDENT_KEY = "STUDENT";
    TextView seekbarResult;
    RadioGroup radioGroup;
    SeekBar moodSeekbar;
    Button submit;
    String name, email, age, nat, major;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form2);

        seekbarResult = (TextView) findViewById(R.id.seekbarResult);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
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

        int mood = moodSeekbar.getProgress();
        switch (radioGroup.getCheckedRadioButtonId()) {
            case R.id.arts:
                major = "Arts";
                break;
            case R.id.sciences:
                major = "Sciences";
                break;
            case R.id.business:
                major = "Business";
                break;
            case R.id.eng:
                major = "Engineering";
                break;
            case R.id.tourism:
                major = "Tourism";
                break;
        }


        name = getIntent().getExtras().getString(Form.STUDENT_NAME);
        email = getIntent().getExtras().getString(Form.STUDENT_EMAIL);
        age = getIntent().getExtras().getString(Form.STUDENT_AGE);
        nat = getIntent().getExtras().getString(Form.STUDENT_NAT);

        Toast.makeText(this, major,Toast.LENGTH_SHORT).show();

        Student student = new Student(name, email, age, nat, major, mood);
        Intent intent = new Intent(this, Display.class);
        intent.putExtra(STUDENT_KEY, (Student) student);
        startActivity(intent);
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
