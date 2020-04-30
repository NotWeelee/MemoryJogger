package com.example.memory_jogger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class setHighScoreActivity extends AppCompatActivity {

    TextView yourScore, highScoreStatement;
    EditText playerName;
    Button submitButton;

    int playerScore;

    //Player High Scores
    private String[] easyHighPlayers = new String[5];
    private int[] easyHighScores = new int[5];

    private String[] mediumHighPlayers = new String[5];
    private int[] mediumHighScores = new int[5];

    private String[] hardHighPlayers = new String[5];
    private int[] hardHighScores = new int[5];

    private String[] endlessHighPlayers = new String[5];
    private int[] endlessHighScores = new int[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_high_score);

        yourScore = (TextView) findViewById(R.id.yourScore);
        highScoreStatement = (TextView) findViewById(R.id.highScoreStatement);
        playerName = (EditText) findViewById(R.id.playerName);
        submitButton = (Button) findViewById(R.id.submitButton);

        Bundle bundle = getIntent().getExtras();
        playerScore = bundle.getInt("playerScore");
        yourScore.setText(Integer.toString(playerScore));

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToMain();
            }
        });
    }

    private void putHighScoresInArray() {
        try{
            InputStream iS = getResources().getAssets().open("easyStandardScores.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(iS));
            String line;
            int x = 0;
            int y = 0;
            for(int i = 0; i < 10; i++) {
                while(br.readLine() != null) {
                    if (i % 2 == 0) {
                        line = br.readLine();
                        easyHighPlayers[x] = line;
                        x++;
                    }
                    if(i % 2 != 0) {
                        line = br.readLine();
                        int value = Integer.parseInt(line);
                        easyHighScores[y] = value;
                        y++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            InputStream iS = getResources().getAssets().open("mediumStandardScores.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(iS));
            String line;
            int x = 0;
            int y = 0;
            for(int i = 0; i < 10; i++) {
                while(br.readLine() != null) {
                    if (i % 2 == 0) {
                        line = br.readLine();
                        mediumHighPlayers[x] = line;
                        x++;
                    }
                    if(i % 2 != 0) {
                        line = br.readLine();
                        int value = Integer.parseInt(line);
                        mediumHighScores[y] = value;
                        y++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            InputStream iS = getResources().getAssets().open("hardStandardScores.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(iS));
            String line;
            int x = 0;
            int y = 0;
            for(int i = 0; i < 10; i++) {
                while(br.readLine() != null) {
                    if (i % 2 == 0) {
                        line = br.readLine();
                        hardHighPlayers[x] = line;
                        x++;
                    }
                    if(i % 2 != 0) {
                        line = br.readLine();
                        int value = Integer.parseInt(line);
                        hardHighScores[y] = value;
                        y++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            InputStream iS = getResources().getAssets().open("endlessScores.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(iS));
            String line;
            int x = 0;
            int y = 0;
            for(int i = 0; i < 10; i++) {
                while(br.readLine() != null) {
                    if (i % 2 == 0) {
                        line = br.readLine();
                        endlessHighPlayers[x] = line;
                        x++;
                    }
                    if(i % 2 != 0) {
                        line = br.readLine();
                        int value = Integer.parseInt(line);
                        endlessHighScores[y] = value;
                        y++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void checkHighScores() {
        for(int i = 0; i < 5; i++) {
            if(playerScore > easyHighScores[i]) {

            }
        }
    }

    private void returnToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
