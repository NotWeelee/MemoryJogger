package com.example.memory_jogger;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quick_menu);

        Button playMenuButton = (Button) findViewById(R.id.standardButton);
        Button highScoreButton = (Button) findViewById(R.id.highScoreButton);
        Button howToPlayButton = (Button) findViewById(R.id.howToPlayButton);

        playMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityPlay();
            }
        });

        highScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityHighScore();
            }
        });

        howToPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHowToPlay();
            }
        });
    }

    public void openActivityPlay(){
        Intent intent = new Intent(this, modeSelectActivity.class);
        startActivity(intent);
    }

    public void openActivityHighScore() {
        Intent intent = new Intent(this, highScoreActivity.class);
        startActivity(intent);
    }

    public void openHowToPlay() {
        Intent intent = new Intent(this, howToPlayActivity.class);
        startActivity(intent);
    }
}