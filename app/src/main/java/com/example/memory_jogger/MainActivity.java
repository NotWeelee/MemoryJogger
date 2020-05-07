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

        Button playMenuButton = (Button) findViewById(R.id.normalButton);
        Button highScoreButton = (Button) findViewById(R.id.highScoreButton);

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
    }

    public void openActivityPlay(){
        Intent intent = new Intent(this, playActivity.class);
        startActivity(intent);
    }

    public void openActivityHighScore() {
        Intent intent = new Intent(this, highScoreActivity.class);
        startActivity(intent);
    }
}