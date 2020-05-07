package com.example.memory_jogger;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class setHighScoreActivity extends AppCompatActivity {

    TextView yourScore, highScoreStatement;
    EditText playerName;
    Button submitButton;

    int playerScore;
    String playerScoreString;

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

    public static final String playerOneEndless = "playerOneEndless";
    public static final String playerTwoEndless = "playerTwoEndless";
    public static final String playerThreeEndless = "playerThreeEndless";
    public static final String playerFourEndless = "playerFourEndless";
    public static final String playerFiveEndless = "playerFiveEndless";

    public static final String scoreOneEndless = "scoreOneEndless";
    public static final String scoreTwoEndless = "scoreTwoEndless";
    public static final String scoreThreeEndless = "scoreThreeEndless";
    public static final String scoreFourEndless = "scoreFourEndless";
    public static final String scoreFiveEndless = "scoreFiveEndless";

    //Player High Scores
    private String[] highPlayers = new String[5];
    private String[] highScores = new String[5];

    private String[] highPlayersEndless = new String[5];
    private String[] highScoresEndless = new String[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_high_score);

        yourScore = (TextView) findViewById(R.id.yourScore);
        highScoreStatement = (TextView) findViewById(R.id.highScoreStatement);
        playerName = (EditText) findViewById(R.id.playerName);
        submitButton = (Button) findViewById(R.id.submitButton);

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        playerScore = bundle.getInt("playerScore");
        playerScoreString = Integer.toString(playerScore);
        yourScore.setText(playerScoreString);

        dataToArray();
        SharedPreferences sharedPreferences = getSharedPreferences(sharedPrefs, MODE_PRIVATE);
        if(sharedPreferences.getString("mode","").equals("standard")) {
            for (int i = 0; i < 5; i++) {
                if (highScores[i].equals("") && playerScore != 0) {
                    highScoreStatement.setText("You set a high score!");
                } else if (!highScores[i].equals("")) {
                    if (playerScore > Integer.parseInt(highScores[i])) {
                        highScoreStatement.setText("You set a high score!");
                    }
                } else {
                    highScoreStatement.setText("Good Game!");
                }

            }
        }
        if(sharedPreferences.getString("mode","").equals("endless")) {
            for (int i = 0; i < 5; i++) {
                if (highScoresEndless[i].equals("") && playerScore != 0) {
                    highScoreStatement.setText("You set a high score!");
                } else if (!highScoresEndless[i].equals("")) {
                    if (playerScore > Integer.parseInt(highScoresEndless[i])) {
                        highScoreStatement.setText("You set a high score!");
                    }
                } else {
                    highScoreStatement.setText("Good Game!");
                }

            }
        }

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(sharedPrefs, MODE_PRIVATE);
                checkForHighScore();
                updateSharedPrefs();
                returnToMain();

            }
        });
    }

    private void dataToArray() {
        SharedPreferences sharedPreferences = getSharedPreferences(sharedPrefs, MODE_PRIVATE);
        highPlayers[0] = sharedPreferences.getString(playerOne, "");
        highScores[0] = sharedPreferences.getString(scoreOne, "");
        highPlayers[1] = sharedPreferences.getString(playerTwo, "");
        highScores[1] = sharedPreferences.getString(scoreTwo, "");
        highPlayers[2] = sharedPreferences.getString(playerThree, "");
        highScores[2] = sharedPreferences.getString(scoreThree, "");
        highPlayers[3] = sharedPreferences.getString(playerFour, "");
        highScores[3] = sharedPreferences.getString(scoreFour, "");
        highPlayers[4] = sharedPreferences.getString(playerFive, "");
        highScores[4] = sharedPreferences.getString(scoreFive, "");

        highPlayersEndless[0] = sharedPreferences.getString(playerOneEndless, "");
        highScoresEndless[0] = sharedPreferences.getString(scoreOneEndless, "");
        highPlayersEndless[1] = sharedPreferences.getString(playerTwoEndless, "");
        highScoresEndless[1] = sharedPreferences.getString(scoreTwoEndless, "");
        highPlayersEndless[2] = sharedPreferences.getString(playerThreeEndless, "");
        highScoresEndless[2] = sharedPreferences.getString(scoreThreeEndless, "");
        highPlayersEndless[3] = sharedPreferences.getString(playerFourEndless, "");
        highScoresEndless[3] = sharedPreferences.getString(scoreFourEndless, "");
        highPlayersEndless[4] = sharedPreferences.getString(playerFiveEndless, "");
        highScoresEndless[4] = sharedPreferences.getString(scoreFiveEndless, "");
    }

    private void checkForHighScore() {
        SharedPreferences sharedPreferences = getSharedPreferences(sharedPrefs, MODE_PRIVATE);
        if(sharedPreferences.getString("mode","").equals("standard")) {
            for(int i = 0; i < 5; i++) {
                if(highScores[i].equals("")) {
                    highScores[i] = Integer.toString(playerScore);
                    highPlayers[i] = playerName.getText().toString();
                    break;
                }
                else if(playerScore > Integer.parseInt(highScores[i])) {
                    highScores = updateHighScoreArray(highScores, i, playerScore);
                    highPlayers = updateHighPlayerArray(highPlayers, i, playerName.getText().toString());
                    break;
                }
            }
        }
        if(sharedPreferences.getString("mode","").equals("endless")) {
            for(int i = 0; i < 5; i++) {
                if(highScoresEndless[i].equals("")) {
                    highScoresEndless[i] = Integer.toString(playerScore);
                    highPlayersEndless[i] = playerName.getText().toString();
                    break;
                }
                else if(playerScore > Integer.parseInt(highScoresEndless[i])) {
                    highScoresEndless = updateHighScoreArray(highScoresEndless, i, playerScore);
                    highPlayersEndless = updateHighPlayerArray(highPlayersEndless, i, playerName.getText().toString());
                    break;
                }
            }
        }
    }

    private String[] updateHighScoreArray(String[] scores, int pos, int num) {
        String[] temp = new String[5];
        for(int i = 0; i == (5 - pos); i++) {
            temp[i] = scores[i];
        }
        temp[pos] = Integer.toString(num);
        for(int i = pos + 1; i < 5; i++) {
            temp[i] = scores[i - 1];
        }
        return temp;
    }

    private String[] updateHighPlayerArray(String[] scores, int pos, String name) {
        String[] temp = new String[5];
        for(int i = 0; i < pos; i++) {
            temp[i] = scores[i];
        }
        temp[pos] = name;
        for(int i = pos + 1; i < 5; i++) {
            temp[i] = scores[i - 1];
        }
        return temp;
    }

    private void updateSharedPrefs() {
        SharedPreferences sharedPreferences = getSharedPreferences(sharedPrefs, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(sharedPreferences.getString("mode","").equals("standard")) {
            if (highPlayers[0] != null) {
                editor.putString(playerOne, highPlayers[0]);
                editor.putString(scoreOne, highScores[0]);
            }
            if (highPlayers[1] != null) {
                editor.putString(playerTwo, highPlayers[1]);
                editor.putString(scoreTwo, highScores[1]);
            }
            if (highPlayers[2] != null) {
                editor.putString(playerThree, highPlayers[2]);
                editor.putString(scoreThree, highScores[2]);
            }
            if (highPlayers[3] != null) {
                editor.putString(playerFour, highPlayers[3]);
                editor.putString(scoreFour, highScores[3]);
            }
            if (highPlayers[4] != null) {
                editor.putString(playerFive, highPlayers[4]);
                editor.putString(scoreFive, highScores[4]);
            }
            editor.apply();
        }

        if(sharedPreferences.getString("mode","").equals("endless")) {
            if (highPlayersEndless[0] != null) {
                editor.putString(playerOneEndless, highPlayersEndless[0]);
                editor.putString(scoreOneEndless, highScoresEndless[0]);
            }
            if (highPlayersEndless[1] != null) {
                editor.putString(playerTwoEndless, highPlayersEndless[1]);
                editor.putString(scoreTwoEndless, highScoresEndless[1]);
            }
            if (highPlayersEndless[2] != null) {
                editor.putString(playerThreeEndless, highPlayersEndless[2]);
                editor.putString(scoreThreeEndless, highScoresEndless[2]);
            }
            if (highPlayersEndless[3] != null) {
                editor.putString(playerFourEndless, highPlayersEndless[3]);
                editor.putString(scoreFourEndless, highScoresEndless[3]);
            }
            if (highPlayersEndless[4] != null) {
                editor.putString(playerFiveEndless, highPlayersEndless[4]);
                editor.putString(scoreFiveEndless, highScoresEndless[4]);
            }
            editor.apply();
        }
    }

    private void returnToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
