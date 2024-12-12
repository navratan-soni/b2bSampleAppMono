package com.turbomoduleexample;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CustomScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the string passed from React Native
        String message = getIntent().getStringExtra("message");

        // Create and set up the TextView
        TextView textView = new TextView(this);
        if (message != null) {
            textView.setText(message);
        } else {
            textView.setText("Welcome to the custom screen!"); // Default message
        }
        textView.setTextSize(24f);
        textView.setPadding(20, 20, 20, 20);

        setContentView(textView);
    }
}
