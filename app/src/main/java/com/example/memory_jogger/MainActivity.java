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

        Button playmenubutton = (Button) findViewById(R.id.playMenuButton);

        playmenubutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityPlay();
            }
        });

    }

    public void openActivityPlay(){
        Intent intent = new Intent(this, playActivity.class);
        startActivity(intent);
    }
}