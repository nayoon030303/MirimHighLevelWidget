package kr.hs.emirim.s2019s05.mirimhighlevelwidget;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    RadioButton radioDate,radioTime;
    DatePicker datePick;
    TimePicker timePicker;
    Chronometer chrono;
    TextView textResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        radioDate = findViewById(R.id.radion_date);
        radioTime = findViewById(R.id.radio_time);
        datePick = findViewById(R.id.date_pick);
        timePicker = findViewById(R.id.time_pick);
        radioDate.setOnClickListener(radiolistener);
        radioTime.setOnClickListener(radiolistener);

        timePicker = findViewById(R.id.time_pick);
        chrono = findViewById(R.id.chronol);
        textResult = findViewById(R.id.text_result);
       chrono.setOnClickListener(chronoListener);
       textResult.setOnLongClickListener(textListener);

        radioDate.setVisibility(View.INVISIBLE);
        radioTime.setVisibility(View.INVISIBLE);
        timePicker.setVisibility(View.INVISIBLE);
        datePick.setVisibility(View.INVISIBLE);

    }
    View.OnClickListener radiolistener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.radion_date:
                    datePick.setVisibility(View.VISIBLE);
                    timePicker.setVisibility(View.INVISIBLE);
                    break;
                case R.id.radio_time:
                    datePick.setVisibility(View.INVISIBLE);
                    timePicker.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };

    View.OnClickListener chronoListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);
                radioDate.setVisibility(View.VISIBLE);
                radioTime.setVisibility(View.VISIBLE);
            }
    };

    View.OnLongClickListener textListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            chrono.stop();
            chrono.setTextColor(Color.BLUE);
            textResult.setText(datePick.getYear()+"년"+(datePick.getMonth()+1)+"월"+
                    (datePick.getDayOfMonth()+1)+"일"+timePicker.getCurrentHour()+"시"+timePicker.getCurrentMinute()+"분");

            radioDate.setVisibility(View.INVISIBLE);
            radioTime.setVisibility(View.INVISIBLE);
            timePicker.setVisibility(View.INVISIBLE);
            datePick.setVisibility(View.INVISIBLE);
            return false;
        }
    };


}