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

        for(int i=0; i < 10; i++) {
            computerChosen.add(buttonArray[rg.nextInt(4)]);
        }

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int counter = 0;
                for(int j=0; j < computerChosen.size(); j++){
                    final int finalJ = j;
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if(computerChosen.get(finalJ) == redButton) {
                                redButtonChange(redButton, 100);
                            }
                            if(computerChosen.get(finalJ) == yellowButton) {
                                yellowButtonChange(yellowButton, 100);
                            }
                            if(computerChosen.get(finalJ) == greenButton) {
                                greenButtonChange(greenButton, 100);
                            }
                            if(computerChosen.get(finalJ) == blueButton) {
                                blueButtonChange(blueButton, 100);
                            }
                        }
                    }, 3000);
                }
            }
        });

        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUserChosen(redButton);
                redButtonChange(redButton, 100);
                //checkMatch();
            }
        });

        yellowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUserChosen(yellowButton);
                yellowButtonChange(yellowButton, 100);
                //checkMatch();
            }
        });

        greenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUserChosen(greenButton);
                greenButtonChange(greenButton, 100);
                //checkMatch();
            }
        });

        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUserChosen(blueButton);
                blueButtonChange(blueButton, 100);
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

    public void redButtonChange(final Button e, int time){
        e.setBackgroundColor(Color.parseColor("#FF8A33"));
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                e.setBackgroundColor(Color.parseColor("#FF4933"));
            }
        }, time);
    }

    public void yellowButtonChange(final Button e, int time){
        e.setBackgroundColor(Color.parseColor("#FFC133"));
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                e.setBackgroundColor(Color.parseColor("#D7FF33"));
            }
        }, time);
    }

    public void greenButtonChange(final Button e, int time){
        e.setBackgroundColor(Color.parseColor("#DDFF33"));
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                e.setBackgroundColor(Color.parseColor("#33FF46"));
            }
        }, time);
    }

    public void blueButtonChange(final Button e, int time){
        e.setBackgroundColor(Color.parseColor("#3380FF"));
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                e.setBackgroundColor(Color.parseColor("#3349FF"));
            }
        }, time);
    }
}
