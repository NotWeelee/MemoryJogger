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

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataToArray();
                checkForHighScore();
                updateSharedPrefs();
                returnToMain();
            }
        });
    }

    private void saveData() {
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
    }

    private void dataToArray() {
        SharedPreferences sharedPreferences = getSharedPreferences(sharedPrefs, MODE_PRIVATE);
        for(int i = 0; i < 5; i++) {
            if(i == 0) {
                highPlayers[i] = sharedPreferences.getString(playerOne, "");
                highScores[i] = sharedPreferences.getString(scoreOne, "");
                highPlayersEndless[i] = sharedPreferences.getString(playerOneEndless, "");
                highScoresEndless[i] = sharedPreferences.getString(scoreOneEndless, "");
            }
            if(i == 1) {
                highPlayers[i] = sharedPreferences.getString(playerTwo, "");
                highScores[i] = sharedPreferences.getString(scoreTwo, "");
                highPlayersEndless[i] = sharedPreferences.getString(playerTwoEndless, "");
                highScoresEndless[i] = sharedPreferences.getString(scoreTwoEndless, "");
            }
            if(i == 2) {
                highPlayers[i] = sharedPreferences.getString(playerThree, "");
                highScores[i] = sharedPreferences.getString(scoreThree, "");
                highPlayersEndless[i] = sharedPreferences.getString(playerThreeEndless, "");
                highScoresEndless[i] = sharedPreferences.getString(scoreThreeEndless, "");
            }
            if(i == 3) {
                highPlayers[i] = sharedPreferences.getString(playerFour, "");
                highScores[i] = sharedPreferences.getString(scoreFour, "");
                highPlayersEndless[i] = sharedPreferences.getString(playerFourEndless, "");
                highScoresEndless[i] = sharedPreferences.getString(scoreFourEndless, "");
            }
            if(i == 4) {
                highPlayers[i] = sharedPreferences.getString(playerFive, "");
                highScores[i] = sharedPreferences.getString(scoreFive, "");
                highPlayersEndless[i] = sharedPreferences.getString(playerFiveEndless, "");
                highScoresEndless[i] = sharedPreferences.getString(scoreFiveEndless, "");
            }
        }
    }

    private void checkForHighScore() {
        for(int i = 0; i < 5; i++) {
            if(highScores[i].equals("")) {
                highScores[i] = Integer.toString(playerScore);
                highPlayers[i] = playerName.getText().toString();
                highScoreStatement.setText("You set a high score!");
                break;
            }
            else if(playerScore > Integer.parseInt(highScores[i])) {
                highScores = updateHighScoreArray(highScores, i, playerScore);
                highPlayers = updateHighPlayerArray(highPlayers, i, playerName.getText().toString());
                highScoreStatement.setText("You set a high score!");
                break;
            }
            else {
                highScoreStatement.setText("Good Game!");
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
        if(highPlayers[0] != null) {
            editor.putString(playerOne, highPlayers[0]);
            editor.putString(scoreOne, highScores[0]);
            editor.apply();
        }
        if(highPlayers[1] != null) {
            editor.putString(playerTwo, highPlayers[1]);
            editor.putString(scoreTwo, highScores[1]);
            editor.apply();
        }
        if(highPlayers[2] != null) {
            editor.putString(playerThree, highPlayers[2]);
            editor.putString(scoreThree, highScores[2]);
            editor.apply();
        }
        if(highPlayers[3] != null) {
            editor.putString(playerFour, highPlayers[3]);
            editor.putString(scoreFour, highScores[3]);
            editor.apply();
        }
        if(highPlayers[4] != null) {
            editor.putString(playerFive, highPlayers[4]);
            editor.putString(scoreFive, highScores[4]);
            editor.apply();
        }
    }

    private void returnToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
