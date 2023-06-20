package com.example.intents_exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

public class LocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_layout);

        Button launch_btn = findViewById(R.id.btnOpenMap);
        launch_btn.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            Uri geoLocation = Uri.parse("geo:10.762845086792561, 106.68248514510185?z=12&q=10.762845086792561, 106.68248514510185(University of Science, HCMC)");
            intent.setData(geoLocation);
            Intent chooser = Intent.createChooser(intent, "Launch Map");
            startActivity(chooser);
        });
    }
}