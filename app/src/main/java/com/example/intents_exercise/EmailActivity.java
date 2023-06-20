package com.example.intents_exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EmailActivity extends AppCompatActivity {
    Button getMail;
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_activity);
        getMail = findViewById(R.id.ButtonClick);
        et = findViewById(R.id.EnterEmail);
        getMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] s = new String[1];
                s[0] = et.getText().toString();
                composeEmail(s, "hello from the other side");
            }
        });
    }
    public void composeEmail(String[] addresses, String subject) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // Only email apps handle this.
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        startActivity(intent);
    }
}