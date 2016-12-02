package com.example.windows10.timeset;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {


     int year, month, day, hour, min;
     Chronometer cr1;
    Button bt1,bt2;
     RadioButton rb1,rb2;
    RadioGroup rbg1;
    TextView tv1;
     TimePicker tp1;
    CalendarView cv1;
    FrameLayout fl1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        cr1=(Chronometer)findViewById(R.id.chronometer3);
        bt1=(Button)findViewById(R.id.button2);
        bt2=(Button)findViewById(R.id.button4);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        tv1=(TextView)findViewById(R.id.textView2);
        rbg1=(RadioGroup)findViewById(R.id.radioGroup1);
        tp1=(TimePicker)findViewById(R.id.timePicker);
        cv1=(CalendarView)findViewById(R.id.calendarView4);
        fl1=(FrameLayout)findViewById(R.id.FrameLayout);


        bt1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                cr1.setBase(SystemClock.elapsedRealtime());
                cr1.start();
                cr1.setTextColor(Color.RED);
            }
        });

        rbg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                 if(i==R.id.radioButton){
                     cv1.setVisibility(View.VISIBLE);
                     tp1.setVisibility(View.INVISIBLE);
                 }
                else{
                     tp1.setVisibility(View.VISIBLE);
                     cv1.setVisibility(View.INVISIBLE);
                 }
            }
        });

        cv1.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int x, int y, int z) {
                 year=x;
                 month=y;
                 day=z;
            }
        });
        tp1.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                hour=i;
                min=i1;
            }
        });

       bt2.setOnClickListener(new Button.OnClickListener() {
           @Override
           public void onClick(View view) {
                cr1.stop();
               cr1.setTextColor(Color.BLUE);
                tv1.setText(year+"년"+month+"월"+day+"일"+hour+"시"+min+"분 예약완료.");
           }
       });
    }
}
