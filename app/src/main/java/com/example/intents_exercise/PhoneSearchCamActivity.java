package com.example.intents_exercise;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.provider.MediaStore;

import androidx.appcompat.app.AppCompatActivity;

public class PhoneSearchCamActivity extends AppCompatActivity {
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private Button search_btn;
    private Button dial_btn;
    private EditText search_text;
    private EditText phone_number;
    private Button cam_btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone_search_cam);

        search_btn = findViewById(R.id.search_button);
        dial_btn = findViewById(R.id.dial_button);
        search_text = findViewById(R.id.query_field);
        phone_number = findViewById(R.id.phone_number_field);

        cam_btn = findViewById(R.id.create_note_button);

        search_btn.setOnClickListener(v -> setSearch_btn());
        dial_btn.setOnClickListener(v -> setDial_btn());
        cam_btn.setOnClickListener(v -> setVideo_Cam_btn());
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

    private void setVideo_Cam_btn() {
        Video_Mode_Camera();
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
    public void Video_Mode_Camera() {
        Intent intent = new Intent(MediaStore.INTENT_ACTION_VIDEO_CAMERA);
        startActivity(intent);
    }
}
