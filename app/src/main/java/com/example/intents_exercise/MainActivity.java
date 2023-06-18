package com.example.intents_exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText day = findViewById(R.id.editTextDay);
        EditText month = findViewById(R.id.editTextMonth);
        EditText year = findViewById(R.id.editTextYear);
        Button addEvent = findViewById(R.id.btnAddEvent);

        addEvent.setOnClickListener(v -> {
            int dayEvent = Integer.parseInt(day.getText().toString());
            int monthEvent = Integer.parseInt(month.getText().toString());
            int yearEvent = Integer.parseInt(year.getText().toString());
            Calendar beginTime = Calendar.getInstance();
            beginTime.set(yearEvent, monthEvent, dayEvent, 9, 0);
            Intent intent = new Intent(Intent.ACTION_INSERT)
                    .setData(CalendarContract.Events.CONTENT_URI)
                    .putExtra(CalendarContract.Events.TITLE, "Test Event")
                    .putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true)
                    .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis());
            Intent chooser = Intent.createChooser(intent, "Add Event");
            startActivity(chooser);
        });
    }
}