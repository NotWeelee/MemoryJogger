package com.example.memory_jogger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
    int score = 0;

    TextView scoreNum = findViewById(R.id.scoreNum);
    TextView title = findViewById(R.id.title);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button redButton = findViewById(R.id.redButton);
        final Button yellowButton = findViewById(R.id.yellowButton);
        final Button greenButton = findViewById(R.id.greenButton);
        final Button blueButton = findViewById(R.id.blueButton);
        final Button startButton = findViewById(R.id.startButton);

        final Button[] buttonArray = {redButton, yellowButton, greenButton, blueButton};

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                do{
                    if(userChosen.size() < computerChosen.size()) {
                        addComputerChosen(buttonArray[rg.nextInt(4)]);
                    }
                }while(match = true);
            }
        });

        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUserChosen(redButton);
                checkMatch();
            }
        });

        yellowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUserChosen(yellowButton);
                checkMatch();
            }
        });

        greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUserChosen(greenButton);
                checkMatch();
            }
        });

        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUserChosen(blueButton);
                checkMatch();
            }
        });
    }

    public void checkMatch() {
        if(computerChosen.size()-1 != userChosen.size()-1) {
            match = false;
            title.setText("You choose poorly!");
        }
        else{
            score++;
            scoreNum.setText(score);
        }
    }

    public void addUserChosen(Button e) {
        userChosen.add(userChosen.size()-1, e);
    }

    public void addComputerChosen(Button e) {
        computerChosen.add(computerChosen.size()-1, e);
    }
}
