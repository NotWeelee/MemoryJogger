package com.example.memory_jogger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class highScoreActivity extends AppCompatActivity {
    //Setting up some variables
    TextView playerOne, playerTwo, playerThree, playerFour, playerFive;
    TextView scoreOne, scoreTwo, scoreThree, scoreFour, scoreFive;
    Button standardButton, endlessButton, easyButton, mediumButton, hardButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        //Assign variables to the buttons and textViews
        playerOne = (TextView) findViewById(R.id.playerOne);
        playerTwo = (TextView) findViewById(R.id.playerTwo);
        playerThree = (TextView) findViewById(R.id.playerThree);
        playerFour = (TextView) findViewById(R.id.playerFour);
        playerFive = (TextView) findViewById(R.id.playerFive);

        scoreOne = (TextView) findViewById(R.id.scoreOne);
        scoreTwo = (TextView) findViewById(R.id.scoreTwo);
        scoreThree = (TextView) findViewById(R.id.scoreThree);
        scoreFour = (TextView) findViewById(R.id.scoreFour);
        scoreFive = (TextView) findViewById(R.id.scoreFive);

        standardButton = (Button) findViewById(R.id.standardScoreButton);
        endlessButton = (Button) findViewById(R.id.endlessScoreButton);
        easyButton = (Button) findViewById(R.id.easyButton);
        mediumButton = (Button) findViewById(R.id.mediumButton);
        hardButton = (Button) findViewById(R.id.hardButton);
        backButton = (Button) findViewById(R.id.backButton);

        //Set difficulty button invisible to start with
        easyButton.setVisibility(View.GONE);
        mediumButton.setVisibility(View.GONE);
        hardButton.setVisibility(View.GONE);

        standardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Set difficulty buttons visible when user choses to view Standard High Scores
                easyButton.setVisibility(View.VISIBLE);
                mediumButton.setVisibility(View.VISIBLE);
                hardButton.setVisibility(View.VISIBLE);

                easyButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showEasyHighScores();
                    }
                });

                mediumButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showMediumHighScores();
                    }
                });

                hardButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showHardHighScores();
                    }
                });
            }
        });

        //Set difficulty buttons to invisible and display endless scores
        endlessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                easyButton.setVisibility(View.GONE);
                mediumButton.setVisibility(View.GONE);
                hardButton.setVisibility(View.GONE);
                showEndlessHighScores();
            }
        });

        //Return to Main Menu
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityMain();
            }
        });
    }

    public void showEasyHighScores() {
        try{
            InputStream iS = getResources().getAssets().open("easyStandardScores.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(iS));
            String line;
            if((line = br.readLine()) != null) {
                playerOne.setText(line);
            }
            if((line = br.readLine()) != null) {
                scoreOne.setText(line);
            }
            if((line = br.readLine()) != null) {
                playerTwo.setText(line);
            }
            if((line = br.readLine()) != null) {
                scoreTwo.setText(line);
            }
            if((line = br.readLine()) != null) {
                playerThree.setText(line);
            }
            if((line = br.readLine()) != null) {
                scoreThree.setText(line);
            }
            if((line = br.readLine()) != null) {
                playerFour.setText(line);
            }
            if((line = br.readLine()) != null) {
                scoreFour.setText(line);
            }
            if((line = br.readLine()) != null) {
                playerFive.setText(line);
            }
            if((line = br.readLine()) != null) {
                scoreFive.setText(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showMediumHighScores() {
        try{
            InputStream iS = getResources().getAssets().open("mediumStandardScores.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(iS));
            String line;
            if((line = br.readLine()) != null) {
                playerOne.setText(line);
            }
            if((line = br.readLine()) != null) {
                scoreOne.setText(line);
            }
            if((line = br.readLine()) != null) {
                playerTwo.setText(line);
            }
            if((line = br.readLine()) != null) {
                scoreTwo.setText(line);
            }
            if((line = br.readLine()) != null) {
                playerThree.setText(line);
            }
            if((line = br.readLine()) != null) {
                scoreThree.setText(line);
            }
            if((line = br.readLine()) != null) {
                playerFour.setText(line);
            }
            if((line = br.readLine()) != null) {
                scoreFour.setText(line);
            }
            if((line = br.readLine()) != null) {
                playerFive.setText(line);
            }
            if((line = br.readLine()) != null) {
                scoreFive.setText(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showHardHighScores() {
        try{
            InputStream iS = getResources().getAssets().open("hardStandardScores.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(iS));
            String line;
            if((line = br.readLine()) != null) {
                playerOne.setText(line);
            }
            if((line = br.readLine()) != null) {
                scoreOne.setText(line);
            }
            if((line = br.readLine()) != null) {
                playerTwo.setText(line);
            }
            if((line = br.readLine()) != null) {
                scoreTwo.setText(line);
            }
            if((line = br.readLine()) != null) {
                playerThree.setText(line);
            }
            if((line = br.readLine()) != null) {
                scoreThree.setText(line);
            }
            if((line = br.readLine()) != null) {
                playerFour.setText(line);
            }
            if((line = br.readLine()) != null) {
                scoreFour.setText(line);
            }
            if((line = br.readLine()) != null) {
                playerFive.setText(line);
            }
            if((line = br.readLine()) != null) {
                scoreFive.setText(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showEndlessHighScores() {
        try{
            InputStream iS = getResources().getAssets().open("endlessScores.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(iS));
            String line;
            if((line = br.readLine()) != null) {
                playerOne.setText(line);
            }
            if((line = br.readLine()) != null) {
                scoreOne.setText(line);
            }
            if((line = br.readLine()) != null) {
                playerTwo.setText(line);
            }
            if((line = br.readLine()) != null) {
                scoreTwo.setText(line);
            }
            if((line = br.readLine()) != null) {
                playerThree.setText(line);
            }
            if((line = br.readLine()) != null) {
                scoreThree.setText(line);
            }
            if((line = br.readLine()) != null) {
                playerFour.setText(line);
            }
            if((line = br.readLine()) != null) {
                scoreFour.setText(line);
            }
            if((line = br.readLine()) != null) {
                playerFive.setText(line);
            }
            if((line = br.readLine()) != null) {
                scoreFive.setText(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clearHighscoreScreen() {
        playerOne.setText("");
        playerTwo.setText("");
        playerThree.setText("");
        playerFour.setText("");
        playerFive.setText("");
        scoreOne.setText("");
        scoreTwo.setText("");
        scoreThree.setText("");
        scoreFour.setText("");
        scoreFive.setText("");
    }

    public void openActivityMain(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
