package com.security.nico.mycalculator.activities;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.security.nico.mycalculator.R;

import org.w3c.dom.Text;

import java.util.TimerTask;

public class IsPrime extends AppCompatActivity {

    Button button;

    TextView tv2;

    Integer Num;

    EditText edt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_is_prime);

        button = (Button) findViewById(R.id.button);
        edt2= (EditText) findViewById(R.id.edt2);
        tv2 = (TextView) findViewById(R.id.tv2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Num = Integer.valueOf(String.valueOf(edt2.getText()));
                if(isPrime(Num)){
                    tv2.setText(edt2.getText()+ " is a prime number");
                }else{
                    tv2.setText(edt2.getText()+ " is not a prime number");
                }
            }
        });
    }

    public static boolean isPrime(Integer N){
        if (N==2) return true;
        if (N==3) return true;
        if (N%2 == 0) return false;
        if (N%3 == 0) return false;
        long Stop = (long) Math.sqrt(N);
        long di=2;
        for(long i=5; i<=Stop; i+=di, di=6-di){
            if (N%i == 0) return false;
        };
        return true;
    }




}
