package com.example.intents_exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button getWeb;
    EditText et_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWeb = findViewById(R.id.GetWeb);
        et_data = findViewById(R.id.LinkEnter);
        getWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebPage(et_data.getText().toString());
            }
        });
    }
    public void openWebPage(String url) {
        if (!url.startsWith("http://") || !url.startsWith("https://")){
            url = "http://" + url;
        }
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }


}