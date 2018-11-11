package com.security.nico.mycalculator.Forms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.security.nico.mycalculator.R;
import com.security.nico.mycalculator.activities.Home;
import com.security.nico.mycalculator.model.Student;

public class Display extends AppCompatActivity {

    final static String STUDENT_DISPLAY_KEY = "STUDENT";
    final static String CHOICE_KEY = "CHOICE";
    final static String VALUE = "VALUE";
    final static int NAME_REQUEST = 1;
    final static int EMAIL_REQUEST = 2;
    final static int AGE_REQUEST = 3;
    final static int NAT_REQUEST = 4;
    final static int MAJOR_REQUEST = 5;
    final static int MOOD_REQUEST = 6;
    Student student;
    Button finish;
    int type;
    TextView name, email, age, nat, major, mood;
    ImageView editNameIcon, editEmailIcon,editAgeIcon, editNatIcon, editMajorIcon, editMoodIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        name = (TextView) findViewById(R.id.studentNameTextView);
        email = (TextView) findViewById(R.id.emailTextView);
        age = (TextView) findViewById(R.id.ageTextView);
        nat = (TextView) findViewById(R.id.natTextView);
        major = (TextView) findViewById(R.id.majorTextView);
        mood = (TextView) findViewById(R.id.moodTextView);
        editNameIcon = (ImageView) findViewById(R.id.nameEditIcon);
        editEmailIcon = (ImageView) findViewById(R.id.emailEditIcon);
        editAgeIcon = (ImageView) findViewById(R.id.ageEditIcon);
        editNatIcon = (ImageView) findViewById(R.id.natEditIcon);
        editMajorIcon = (ImageView) findViewById(R.id.majorEditIcon);
        editMoodIcon = (ImageView) findViewById(R.id.moodEditIcon);
        finish = (Button) findViewById(R.id.finish);


        if (getIntent().getExtras() != null) {
            student = (Student) getIntent().getExtras().getSerializable(Form2.STUDENT_KEY);
            name.setText(student.getName());
            email.setText(student.getEmail());
            age.setText(student.getAge());
            nat.setText(student.getNat());
            major.setText(student.getMajor());
            mood.setText(student.getMood() + " % Positive");

            editNameIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Display.this, Form.class);
                    intent.putExtra(STUDENT_DISPLAY_KEY, student);
                    intent.putExtra(CHOICE_KEY, "NAME");
                    startActivityForResult(intent, NAME_REQUEST);
                    type = 1;
                }
            });
            editEmailIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Display.this, Form.class);
                    intent.putExtra(STUDENT_DISPLAY_KEY, student);
                    intent.putExtra(CHOICE_KEY, "EMAIL");
                    startActivityForResult(intent, EMAIL_REQUEST);
                    type = 2;
                }
            });
            editAgeIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Display.this, Form.class);
                    intent.putExtra(STUDENT_DISPLAY_KEY, student);
                    intent.putExtra(CHOICE_KEY, "AGE");
                    startActivityForResult(intent, AGE_REQUEST);
                    type = 3;
                }
            });
            editNatIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Display.this, Form.class);
                    intent.putExtra(STUDENT_DISPLAY_KEY, student);
                    intent.putExtra(CHOICE_KEY, "NAT");
                    startActivityForResult(intent, NAT_REQUEST);
                    type = 4;
                }
            });
            editMajorIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Display.this, Form.class);
                    intent.putExtra(STUDENT_DISPLAY_KEY, student);
                    intent.putExtra(CHOICE_KEY, "MAJOR");
                    startActivityForResult(intent, MAJOR_REQUEST);
                    type = 5;
                }
            });
            editMoodIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Display.this, Form.class);
                    intent.putExtra(STUDENT_DISPLAY_KEY, student);
                    intent.putExtra(CHOICE_KEY, "MOOD");
                    startActivityForResult(intent, MOOD_REQUEST);
                }
            });
        }


        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Display.this,"SEND",Toast.LENGTH_SHORT).show();
                Intent e= new Intent(Display.this,Home.class);
                startActivity(e);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == NAME_REQUEST) {
                student.setName(data.getExtras().getString(VALUE));
                name.setText(student.getName());
            }
            if (requestCode == EMAIL_REQUEST) {
                student.setEmail(data.getExtras().getString(VALUE));
                email.setText(student.getEmail());
            }
            if (requestCode == AGE_REQUEST) {
                student.setEmail(data.getExtras().getString(VALUE));
                age.setText(student.getAge());
            }
            if (requestCode == NAT_REQUEST) {
                student.setEmail(data.getExtras().getString(VALUE));
                nat.setText(student.getNat());
            }
            if (requestCode == MAJOR_REQUEST) {
                student.setMajor(data.getExtras().getString(VALUE));
                major.setText(student.getMajor());
            }
            if (requestCode == MOOD_REQUEST) {
                student.setMood(Integer.parseInt(data.getExtras().getString(VALUE)));
                mood.setText(student.getMood() + "% positive");
            }
        } else {
        }
    }
}