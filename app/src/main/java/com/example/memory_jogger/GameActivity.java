package com.example.memory_jogger;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    TextView score;
    Button b1, b2, b3, b4, start;

    int difficultyLevel = 3;
    int[] sequenceToCopy = new int[10];

    private Handler myHandler;
    boolean playSequence = false;
    int elementToPlay = 0;

    //For Checking Player Answers
    int playerResponses;
    int playerScore;
    boolean isResponding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_layout);

        //initialize objects
        score = (TextView) findViewById(R.id.scoreTextView);
        b1 = (Button) findViewById(R.id.redButton);
        b2 = (Button) findViewById(R.id.blueButton);
        b3 = (Button) findViewById(R.id.greenButton);
        b4 = (Button) findViewById(R.id.yellowButton);
        start = (Button) findViewById(R.id.startGameButton);

        //assign listeners
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        start.setOnClickListener(this);

        //This code defines the thread
        myHandler = new android.os.Handler() {
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                if (playSequence) {
                    //Thread action goes here
                    b1.setVisibility(View.VISIBLE);
                    b2.setVisibility(View.VISIBLE);
                    b3.setVisibility(View.VISIBLE);
                    b4.setVisibility(View.VISIBLE);

                    switch (sequenceToCopy[elementToPlay]) {
                        case 1:
//                            b1.setVisibility(View.INVISIBLE);
                            b1.setBackgroundColor(Color.BLACK);
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    b1.setBackgroundColor(Color.parseColor("#80FF0000"));
                                }
                            }, 1500);
                            break;
                        case 2:
//                            b2.setVisibility(View.INVISIBLE);
                            b2.setBackgroundColor(Color.BLACK);
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    b2.setBackgroundColor(Color.parseColor("#800000FF"));
                                }
                            }, 1500);
                            break;
                        case 3:
//                            b3.setVisibility(View.INVISIBLE);
                            b3.setBackgroundColor(Color.BLACK);
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    b3.setBackgroundColor(Color.parseColor("#8000FF00"));
                                }
                            }, 1500);
                            break;
                        case 4:
//                            b4.setVisibility(View.INVISIBLE);
                            b4.setBackgroundColor(Color.BLACK);
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    b4.setBackgroundColor(Color.parseColor("#80FFFF00"));
                                }
                            }, 1500);
                            break;
                    }

                    elementToPlay++;
                    if(elementToPlay == difficultyLevel){
                        sequenceFinished();
                    }
                }
                myHandler.sendEmptyMessageDelayed(0, 1000);
            }
        };
        myHandler.sendEmptyMessage(0);
        playASequence();
    }

    @Override
    public void onClick(View v) {

    }

    public void createSequence() {
        Random randInt = new Random();
        int ourRandom;
        for (int i = 0; i < difficultyLevel; i++) {
            //get random 1-4
            ourRandom = randInt.nextInt(4);
            ourRandom++;
            sequenceToCopy[i] = ourRandom;
        }
    }

    public void playASequence() {
        createSequence();
        isResponding = false;
        elementToPlay = 0;
        playerResponses = 0;
        Toast.makeText(this, "Your Turn", Toast.LENGTH_SHORT).show();
        playSequence = true;
    }

    public void sequenceFinished() {
        playSequence = false;
        //set buttons to visible?
        b1.setVisibility(View.VISIBLE);
        b2.setVisibility(View.VISIBLE);
        b3.setVisibility(View.VISIBLE);
        b4.setVisibility(View.VISIBLE);
        isResponding = true;
    }
}

