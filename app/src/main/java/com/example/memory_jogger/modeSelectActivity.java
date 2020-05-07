package com.example.memory_jogger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class modeSelectActivity extends AppCompatActivity {

    Button standardButton, endlessButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode_select);

        standardButton = (Button) findViewById(R.id.standardButton);
        endlessButton = (Button) findViewById(R.id.endlessButton);
        backButton = (Button) findViewById(R.id.backButton);

        standardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPlayActivity();
            }
        });

        endlessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEndlessPlayActivity();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });
    }

    public void openPlayActivity() {
        Intent intent = new Intent(this, playActivity.class);
        startActivity(intent);
    }

    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openEndlessPlayActivity() {
        Intent intent = new Intent(this, endlessPlayActivity.class);
        startActivity(intent);
    }
}
