package com.example.memory_jogger;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    final ArrayList<Button> computerChosen = new ArrayList<>();
    final ArrayList<Button> userChosen = new ArrayList<>();
    boolean match = true;
    Random rg = new Random();
    Handler handler = new Handler();
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView scoreNum = findViewById(R.id.scoreNum);
        final TextView title = findViewById(R.id.title);

        final Button redButton = findViewById(R.id.redButton);
        final Button yellowButton = findViewById(R.id.yellowButton);
        final Button greenButton = findViewById(R.id.greenButton);
        final Button blueButton = findViewById(R.id.blueButton);
        final Button startButton = findViewById(R.id.startButton);

        final Button[] buttonArray = {redButton, yellowButton, greenButton, blueButton};

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int counter = 0;
                for(int i=0; i < 10; i++) {
                    computerChosen.add(buttonArray[rg.nextInt(4)]);
                }
                for(int j=0; j < 10; j++) {
                    
                }
            }
        });

        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUserChosen(redButton);
                redButtonChange(redButton);
                //checkMatch();
            }
        });

        yellowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUserChosen(yellowButton);
                yellowButtonChange(yellowButton);
                //checkMatch();
            }
        });

        greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUserChosen(greenButton);
                greenButtonChange(greenButton);
                //checkMatch();
            }
        });

        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUserChosen(blueButton);
                blueButtonChange(blueButton);
                //checkMatch();
            }
        });
    }

    public void checkMatch() {
        if(computerChosen.get(score) == userChosen.get(score)) {
            match = true;
        }
        else {match = false;}
    }

    public void addUserChosen(Button e) {
        userChosen.add(e);
    }

    public void redButtonChange(final Button e){
        e.setBackgroundColor(Color.parseColor("#FF8A33"));
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                e.setBackgroundColor(Color.parseColor("#FF4933"));
            }
        }, 100);
    }

    public void yellowButtonChange(final Button e){
        e.setBackgroundColor(Color.parseColor("#FFC133"));
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                e.setBackgroundColor(Color.parseColor("#D7FF33"));
            }
        }, 100);
    }

    public void greenButtonChange(final Button e){
        e.setBackgroundColor(Color.parseColor("#DDFF33"));
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                e.setBackgroundColor(Color.parseColor("#33FF46"));
            }
        }, 100);
    }

    public void blueButtonChange(final Button e){
        e.setBackgroundColor(Color.parseColor("#3380FF"));
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                e.setBackgroundColor(Color.parseColor("#3349FF"));
            }
        }, 100);
    }
}
