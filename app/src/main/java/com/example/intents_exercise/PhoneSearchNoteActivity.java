package com.example.intents_exercise;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PhoneSearchActivity extends AppCompatActivity {
    private Button search_btn;
    private Button dial_btn;
    private EditText search_text;
    private EditText phone_number;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone_search);

        search_btn = findViewById(R.id.search_button);
        dial_btn = findViewById(R.id.dial_button);
        search_text = findViewById(R.id.query_field);
        phone_number = findViewById(R.id.phone_number_field);

        search_btn.setOnClickListener(v -> setSearch_btn());
        dial_btn.setOnClickListener(v -> setDial_btn());
    }


    private void setSearch_btn() {
        String query = search_text.getText().toString();
        if (query.isEmpty()) {
            Toast.makeText(this, "Please enter a search query.", Toast.LENGTH_SHORT).show();
            return;
        }
        else if (query.length() > 100) {
            Toast.makeText(this, "Please enter a shorter search query.", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            searchWeb(query);
        }
    }

    private void setDial_btn() {
        String phoneNumber = phone_number.getText().toString();
        if (phoneNumber.isEmpty()) {
            Toast.makeText(this, "Please enter a phone number.", Toast.LENGTH_SHORT).show();
            return;
        }
        else if (phoneNumber.length() != 10) {
            Toast.makeText(this, "Please enter a valid phone number.", Toast.LENGTH_SHORT).show();
            return;
        }
        else if (!phoneNumber.matches("[0-9]+")) {
            Toast.makeText(this, "Please enter a valid phone number.", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            dialPhoneNumber(phoneNumber);
        }
    }
    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(intent);
    }

    public void searchWeb(String query) {
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, query);
        startActivity(intent);
    }
}
