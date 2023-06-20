package com.example.intents_exercise;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.widget.Button;

public class AlarmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        Button button1 = findViewById(R.id.buttonsetalarm);
        Button button2 = findViewById(R.id.buttonshowalarm);
        Button button3 = findViewById(R.id.buttonsettimer);

        button1.setOnClickListener(v -> {
            Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
            intent.putExtra(AlarmClock.EXTRA_HOUR, 8);
            intent.putExtra(AlarmClock.EXTRA_MINUTES, 0);
            intent.putExtra(AlarmClock.EXTRA_MESSAGE, "Wake up!");
            startActivity(intent);
        });

        button2.setOnClickListener(v -> {
            Intent intent = new Intent(AlarmClock.ACTION_SHOW_ALARMS);
            startActivity(intent);
        });

        button3.setOnClickListener(v -> {
            Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER);
            intent.putExtra(AlarmClock.EXTRA_LENGTH, 600); // 10 minutes
            intent.putExtra(AlarmClock.EXTRA_MESSAGE, "Timer");
            startActivity(intent);
        });

    }
}
