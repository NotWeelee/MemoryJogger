package com.example.memory_jogger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class highScoreActivity extends AppCompatActivity {
    //Setting up some variables
    TextView playerOneView, playerTwoView, playerThreeView, playerFourView, playerFiveView;
    TextView scoreOneView, scoreTwoView, scoreThreeView, scoreFourView, scoreFiveView;
    Button standardButton, endlessButton, resetScoresButton, backButton;

    public static final String sharedPrefs = "sharedPrefs";

    public static final String playerOne = "playerOne";
    public static final String playerTwo = "playerTwo";
    public static final String playerThree = "playerThree";
    public static final String playerFour = "playerFour";
    public static final String playerFive = "playerFive";

    public static final String scoreOne = "scoreOne";
    public static final String scoreTwo = "scoreTwo";
    public static final String scoreThree = "scoreThree";
    public static final String scoreFour = "scoreFour";
    public static final String scoreFive = "scoreFive";

    public static final String playerOneEndless = "playerOne";
    public static final String playerTwoEndless = "playerTwo";
    public static final String playerThreeEndless = "playerThree";
    public static final String playerFourEndless = "playerFour";
    public static final String playerFiveEndless = "playerFive";

    public static final String scoreOneEndless = "scoreOne";
    public static final String scoreTwoEndless = "scoreTwo";
    public static final String scoreThreeEndless = "scoreThree";
    public static final String scoreFourEndless = "scoreFour";
    public static final String scoreFiveEndless = "scoreFive";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        //Assign variables to the buttons and textViews
        playerOneView = (TextView) findViewById(R.id.playerOne);
        playerTwoView = (TextView) findViewById(R.id.playerTwo);
        playerThreeView = (TextView) findViewById(R.id.playerThree);
        playerFourView = (TextView) findViewById(R.id.playerFour);
        playerFiveView = (TextView) findViewById(R.id.playerFive);

        scoreOneView = (TextView) findViewById(R.id.scoreOne);
        scoreTwoView = (TextView) findViewById(R.id.scoreTwo);
        scoreThreeView = (TextView) findViewById(R.id.scoreThree);
        scoreFourView = (TextView) findViewById(R.id.scoreFour);
        scoreFiveView = (TextView) findViewById(R.id.scoreFive);

        standardButton = (Button) findViewById(R.id.standardScoreButton);
        endlessButton = (Button) findViewById(R.id.endlessScoreButton);

        backButton = (Button) findViewById(R.id.backButton);
        resetScoresButton= (Button) findViewById(R.id.resetHighScores);

        standardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHighScores();
            }
        });

        endlessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearHighScoreScreen();
                showEndlessHighScores();
            }
        });

        resetScoresButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(sharedPrefs, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString(playerOne, "");
                editor.putString(playerTwo, "");
                editor.putString(playerThree, "");
                editor.putString(playerFour, "");
                editor.putString(playerFive, "");

                editor.putString(scoreOne, "");
                editor.putString(scoreTwo, "");
                editor.putString(scoreThree, "");
                editor.putString(scoreFour, "");
                editor.putString(scoreFive, "");

                editor.putString(playerOneEndless, "");
                editor.putString(playerTwoEndless, "");
                editor.putString(playerThreeEndless, "");
                editor.putString(playerFourEndless, "");
                editor.putString(playerFiveEndless, "");

                editor.putString(scoreOneEndless, "");
                editor.putString(scoreTwoEndless, "");
                editor.putString(scoreThreeEndless, "");
                editor.putString(scoreFourEndless, "");
                editor.putString(scoreFiveEndless, "");

                editor.apply();
                clearHighScoreScreen();
            }
        });

        //Return to Main Menu
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearHighScoreScreen();
                openActivityMain();
            }
        });
    }

    public void showHighScores(){
        SharedPreferences sharedPreferences = getSharedPreferences(sharedPrefs, MODE_PRIVATE);
        playerOneView.setText(sharedPreferences.getString(playerOne,""));
        playerTwoView.setText(sharedPreferences.getString(playerTwo,""));
        playerThreeView.setText(sharedPreferences.getString(playerThree,""));
        playerFourView.setText(sharedPreferences.getString(playerFour,""));
        playerFiveView.setText(sharedPreferences.getString(playerFive,""));
        scoreOneView.setText(sharedPreferences.getString(scoreOne,""));
        scoreTwoView.setText(sharedPreferences.getString(scoreTwo,""));
        scoreThreeView.setText(sharedPreferences.getString(scoreThree,""));
        scoreFourView.setText(sharedPreferences.getString(scoreFour,""));
        scoreFiveView.setText(sharedPreferences.getString(scoreFive,""));
    }

    public void showEndlessHighScores(){
        SharedPreferences sharedPreferences = getSharedPreferences(sharedPrefs, MODE_PRIVATE);
        playerOneView.setText(sharedPreferences.getString(playerOneEndless,""));
        playerTwoView.setText(sharedPreferences.getString(playerTwoEndless,""));
        playerThreeView.setText(sharedPreferences.getString(playerThreeEndless,""));
        playerFourView.setText(sharedPreferences.getString(playerFourEndless,""));
        playerFiveView.setText(sharedPreferences.getString(playerFiveEndless,""));
        scoreOneView.setText(sharedPreferences.getString(scoreOneEndless,""));
        scoreTwoView.setText(sharedPreferences.getString(scoreTwoEndless,""));
        scoreThreeView.setText(sharedPreferences.getString(scoreThreeEndless,""));
        scoreFourView.setText(sharedPreferences.getString(scoreFourEndless,""));
        scoreFiveView.setText(sharedPreferences.getString(scoreFiveEndless,""));
    }

    public void clearHighScoreScreen() {
        playerOneView.setText("");
        playerTwoView.setText("");
        playerThreeView.setText("");
        playerFourView.setText("");
        playerFiveView.setText("");
        scoreOneView.setText("");
        scoreTwoView.setText("");
        scoreThreeView.setText("");
        scoreFourView.setText("");
        scoreFiveView.setText("");
    }

    public void openActivityMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
