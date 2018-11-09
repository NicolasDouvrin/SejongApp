package com.security.nico.mycalculator.Forms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
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
    RadioButton artRadio, scienceRadio, fashRadio, engRadio, tourismRadio;
    SeekBar moodSeekbar;
    Button submit;
    String studentName= getIntent().getStringExtra("NAME");
    String studentEmail= getIntent().getStringExtra("EMAIL");
    String studentAge= getIntent().getStringExtra("AGE");
    String studentNat= getIntent().getStringExtra("NAT");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form2);

        seekbarResult = (TextView) findViewById(R.id.seekbarResult);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        artRadio = (RadioButton) findViewById(R.id.Arts);
        scienceRadio = (RadioButton) findViewById(R.id.Sciences);
        fashRadio = (RadioButton) findViewById(R.id.Business);
        engRadio = (RadioButton) findViewById(R.id.Eng);
        tourismRadio = (RadioButton) findViewById(R.id.Tourism);
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
            String department = "";
            int mood = moodSeekbar.getProgress();
            switch (radioGroup.getCheckedRadioButtonId()) {
                case R.id.Arts:
                    department = "Arts";
                    break;
                case R.id.Sciences:
                    department = "Sciences";
                    break;
                case R.id.Business:
                    department = "Business";
                    break;
                case R.id.Eng:
                    department = "Engineering";
                    break;
                case R.id.Tourism:
                    department = "Tourism";
                    break;
            }

            Student student = new Student(studentName, studentEmail,studentAge,studentNat, department, mood);
            Intent intent = new Intent(this, Display.class);
            intent.putExtra(STUDENT_KEY, (Student) student);
            startActivity(intent);
        }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
