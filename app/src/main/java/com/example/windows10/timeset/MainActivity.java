package com.example.windows10.timeset;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Chronometer cr1;
        Button bt1,bt2;
        final RadioButton rb1,rb2;
        RadioGroup rbg1;
        TextView tv1;


        cr1=(Chronometer)findViewById(R.id.chronometer3);
        bt1=(Button)findViewById(R.id.button2);
        bt2=(Button)findViewById(R.id.button4);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        tv1=(TextView)findViewById(R.id.textView2);
        rbg1=(RadioGroup)findViewById(R.id.radioGroup1);


        bt1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                cr1.setBase(SystemClock.elapsedRealtime());
                cr1.start();
            }
        });

        rb1.setOnClickListener(new RadioButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rb1.isChecked()) {
                    rb1.setVisibility(View.VISIBLE);
                }
                else {
                    rb1.setVisibility(View.INVISIBLE);
                }
            }
        });
        rb2.setOnClickListener(new RadioButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rb2.isChecked()){
                    rb2.setVisibility(View.VISIBLE);
                }
                else {
                    rb2.setVisibility(View.INVISIBLE);
                }
            }
        });

       bt2.setOnClickListener(new Button.OnClickListener() {
           @Override
           public void onClick(View view) {

           }
       });
    }
}
