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
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    RadioButton radioDate,radioTime;
    CalendarView calendarl;
    TimePicker timePicker;
    Chronometer chrono;
    TextView textResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        radioDate = findViewById(R.id.radion_date);
        radioTime = findViewById(R.id.radio_time);

        radioDate.setOnClickListener(radiolistener);
        radioTime.setOnClickListener(radiolistener);

        calendarl = findViewById(R.id.calendar1);
        timePicker = findViewById(R.id.time_pick);
        chrono = findViewById(R.id.chronol);
        textResult = findViewById(R.id.text_result);
        Button btnStart = findViewById(R.id.btn_start);
        Button btnDone = findViewById(R.id.btn_stop);
        btnStart.setOnClickListener(btnListener);
        btnDone.setOnClickListener(btnListener);
        calendarl.setOnDateChangeListener(calendarListener);
    }
    View.OnClickListener radiolistener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.radion_date:
                    calendarl.setVisibility(View.VISIBLE);
                    timePicker.setVisibility(View.INVISIBLE);
                    break;
                case R.id.radio_time:
                    calendarl.setVisibility(View.INVISIBLE);
                    timePicker.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_start:
                    chrono.setBase(SystemClock.elapsedRealtime());
                    chrono.start();
                    chrono.setTextColor(Color.RED);
                    break;
                case R.id.btn_stop:
                    chrono.stop();
                    chrono.setTextColor(Color.BLUE);
                    textResult.setText(dateStr+ timePicker.getCurrentHour()+"시"+timePicker.getCurrentMinute()+"분");
                    break;
            }

        }
    };

    String dateStr =" ";

    CalendarView.OnDateChangeListener calendarListener = new CalendarView.OnDateChangeListener() {
        @Override
        public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
            dateStr = year + "년" + (month+1) + "월" + dayOfMonth + "일";
        }
    };
}