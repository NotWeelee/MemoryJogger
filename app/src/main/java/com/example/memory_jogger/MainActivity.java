package com.example.memory_jogger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView scoreView = findViewById(R.id.scoreView);

        final Button redButton = findViewById(R.id.redButton);
        final Button yellowButton = findViewById(R.id.yellowButton);
        final Button greenButton = findViewById(R.id.greenButton);
        final Button blueButton = findViewById(R.id.blueButton);
        final Button startButton = findViewById(R.id.startButton);

        final Button[] buttonArray = {redButton, yellowButton, greenButton, blueButton};
        final ArrayList<Button> computerChosen = new ArrayList<>();
        final ArrayList<Button> userChosen = new ArrayList<>();


        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean match = true;
                final Random rg = new Random();

                if(computerChosen.isEmpty()) {
                    while(match = true) {
                        int score = 0;
                        computerChosen.add(buttonArray[rg.nextInt(4)]);
                        computerChosen.get(score).getBackground().setAlpha(70);

                        redButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                userChosen.add(redButton);
                                userChosen.get(userChosen.size()-1).getBackground().setAlpha(70);
                            }
                        });
                        yellowButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                userChosen.add(yellowButton);
                                userChosen.get(userChosen.size()-1).getBackground().setAlpha(70);
                            }
                        });
                        greenButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                userChosen.add(greenButton);
                                userChosen.get(userChosen.size()-1).getBackground().setAlpha(70);
                            }
                        });
                        blueButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                userChosen.add(blueButton);
                                userChosen.get(userChosen.size()-1).getBackground().setAlpha(70);
                            }
                        });

                        if(computerChosen.get(score) != userChosen.get(score)) {
                            match = false;
                        }
                        else {
                            score++;
                            scoreView.setText(score);
                        }

                    }
                }
            }
        });
    }
}
