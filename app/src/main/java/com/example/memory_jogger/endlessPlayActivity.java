package com.example.memory_jogger;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
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

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class endlessPlayActivity extends AppCompatActivity implements View.OnClickListener {

    //create textview and buttons
    TextView score;
    Button b1, b2, b3, b4, start, back;

    int[] sequenceToCopy = new int[999];
    private Handler myHandler;
    boolean playSequence = false;
    int difficultyLevel;
    int elementToPlay = 0;

    //For Checking Player Answers
    int playerResponses;
    int playerScore;
    boolean isResponding;

    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize objects
        b1 = (Button) findViewById(R.id.blueButton);
        b2 = (Button) findViewById(R.id.redButton);
        b3 = (Button) findViewById(R.id.greenButton);
        b4 = (Button) findViewById(R.id.yellowButton);
        back = (Button) findViewById(R.id.backButton);
        start = (Button) findViewById(R.id.startButton);
        score = (TextView) findViewById(R.id.scoreNum);
        score.setText("Score: " + playerScore);

        //assign listeners to buttons
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        start.setOnClickListener(this);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMain();
            }
        });

        //High-scores
        SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("mode", "standard");
        editor.apply();

        //This code defines the thread and only runs when (playSequence == true)
        myHandler = new android.os.Handler() {
            public void handleMessage(Message msg) {
                super.handleMessage(msg);

                if (playSequence) {
                    unhighlight();

                    switch (sequenceToCopy[elementToPlay]) {
                        case 1:
                            b1.setBackgroundColor(Color.WHITE);
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    unhighlight();
                                }
                            }, 500);
                            break;
                        case 2:
                            b2.setBackgroundColor(Color.WHITE);
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    unhighlight();
                                }
                            }, 500);
                            break;
                        case 3:
                            b3.setBackgroundColor(Color.WHITE);
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    unhighlight();
                                }
                            }, 500);
                            break;
                        case 4:
                            b4.setBackgroundColor(Color.WHITE);
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    unhighlight();
                                }
                            }, 500);
                            break;
                    }

                    elementToPlay++;
                    if (elementToPlay == difficultyLevel) {
                        sequenceFinished();
                    }
                }
                myHandler.sendEmptyMessageDelayed(0, 1000);
            }
        };
        myHandler.sendEmptyMessage(0);
    }

    @Override
    public void onClick(View v) {
        if (!playSequence) {
            switch (v.getId()) {
                case R.id.blueButton:
                    b1.setBackgroundColor(Color.WHITE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            unhighlight();
                        }
                    }, 250);
                    checkElement(1);
                    break;
                case R.id.redButton:
                    b2.setBackgroundColor(Color.WHITE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            unhighlight();
                        }
                    }, 250);
                    checkElement(2);
                    break;
                case R.id.greenButton:
                    b3.setBackgroundColor(Color.WHITE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            unhighlight();
                        }
                    }, 250);
                    checkElement(3);
                    break;
                case R.id.yellowButton:
                    b4.setBackgroundColor(Color.WHITE);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            unhighlight();
                        }
                    }, 250);
                    checkElement(4);
                    break;
                case R.id.startButton:
                    difficultyLevel = 1;
                    playerScore = 0;
                    score.setText("Score: " + playerScore);
                    playASequence();
                    break;

            }
        }
    }

    public void createSequence() {
        Random randInt = new Random();
        int ourRandom;

        for (int i = 0; i < sequenceToCopy.length; i++) {
            //get random 1-4
            ourRandom = randInt.nextInt(4);
            ourRandom++;
            sequenceToCopy[i] = ourRandom;
        }
    }

    public void playASequence() {
        disableButtons();
        if (playerScore <= 0) {
            createSequence();
            playerResponses = 0;    //reset # responses
        }

        isResponding = false; //time for computer to respond
        elementToPlay = 0;
        playSequence = true; //immediately starts thread handler block
    }

    public void checkElement(int thisElement) {
        if (isResponding) {
            playerResponses++;
            if (sequenceToCopy[playerResponses - 1] == thisElement) {
                //if correct guess
                if (playerResponses == difficultyLevel) {
                    //if level completed
                    isResponding = false;
                    difficultyLevel++;
                    playerScore = playerScore + 1;   //increment score
                    score.setText("Score: " + playerScore);
                    Toast.makeText(this, "Good job, next level...", Toast.LENGTH_SHORT).show();
                    playASequence();
                }
            } else {
                //if wrong guess
                Toast.makeText(this, "GAME OVER!", Toast.LENGTH_LONG * 4).show();
                disableButtons();
                isResponding = false;
                setHighScore();
            }
        }
    }

    public void sequenceFinished() {
        playSequence = false; //immediately ends thread block
        Toast.makeText(this, "Your Turn...", Toast.LENGTH_LONG * 2).show();

        playerResponses = 0;
        isResponding = true;
        enableButtons();
    }

    private void unhighlight() {
        b1.setBackgroundColor(Color.parseColor("#3349FF"));
        b2.setBackgroundColor(Color.parseColor("#FF4933"));
        b3.setBackgroundColor(Color.parseColor("#33FF46"));
        b4.setBackgroundColor(Color.parseColor("#D7FF33"));
    }

    private void disableButtons() {
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
    }

    private void enableButtons() {
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
    }

    private void setHighScore() {
        Intent intent = new Intent(this, setHighScoreActivity.class);
        intent.putExtra("playerScore", playerScore);
        startActivity(intent);
    }

    private void goToMain() {
        Intent intent = new Intent(this, modeSelectActivity.class);
        startActivity(intent);
    }
}