package com.adinda.meetup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private TextView home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent i = getIntent();

        home = findViewById(R.id.tvWelcome);

        String nameFromIntent = getIntent().getStringExtra("password");

        home.setText("Selamat Datang " + nameFromIntent);
    }
}
