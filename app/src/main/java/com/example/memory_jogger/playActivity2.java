package com.example.memory_jogger;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class playActivity2 extends AppCompatActivity {

    Button startGameButton, b1, b2, b3, b4;

    //    List<Integer> buttons;
    int[] sequence;

    int curRound;
    int curGuess;
    final int TOTAL_ROUNDS = 10;

    Random rg = new Random();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_layout);

        startGameButton = (Button) findViewById(R.id.startGameButton);

        b1 = (Button) findViewById(R.id.redButton);
        b2 = (Button) findViewById(R.id.blueButton);
        b3 = (Button) findViewById(R.id.greenButton);
        b4 = (Button) findViewById(R.id.yellowButton);

        b1.setTag(1);
        b2.setTag(2);
        b3.setTag(3);
        b4.setTag(4);

        disableButtons();

        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGameButton.setVisibility(View.INVISIBLE);
                disableButtons();
                curGuess = 0;
                curRound = 1;
                sequence = new int[TOTAL_ROUNDS];            //generate empty sequence
                for (int i = 0; i < sequence.length; i++) {      //populate sequence
                    sequence[i] = rg.nextInt((4) + 1);
                }
                generateButtons(curRound);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonLogic(v);
                //highlight button code
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonLogic(v);
                //highlight button code
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonLogic(v);
                //highlight button code
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonLogic(v);
                //highlight button code
            }
        });
    }

    private void buttonLogic(View v) {
        List<Integer> tempList = new ArrayList<>();
        int[] tempSequence = new int[TOTAL_ROUNDS];
        for (int i = 0; i < curRound; i++) {
//            tempList.add(buttons.get(i));
        }

        if (tempList.contains(v.getTag())) {
            curGuess++;
            checkWin();
        } else {
            lostGame();
        }
    }

    private void checkWin() {
        if (curGuess == curRound) {
            disableButtons();
            if (curRound == 10) {
                Toast.makeText(this, "You win!", Toast.LENGTH_LONG).show();
                startGameButton.setVisibility(View.VISIBLE);
            } else {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        curGuess = 0;
                        curRound++;
                        generateButtons(2);
                    }
                }, 1000);
            }
        }
    }

    private void lostGame() {
        Toast.makeText(this, "You lose!", Toast.LENGTH_LONG).show();
        disableButtons();
        startGameButton.setVisibility(View.VISIBLE);
    }

    private void generateButtons(int number) {

        unhighlight();
        for (int i = 0; i < 3; i++) {            //highlighting as many tiles as rounds
            int thisbtn = sequence[i];             //get data in array index
            highlightNumber2(thisbtn);              //highlight corresponding button




        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //code to set buttons to normal state
                unhighlight();

                enableButtons();
            }
        }, 1500);
        Toast.makeText(this, "Your turn", Toast.LENGTH_SHORT).show();
    }

    private void highlightButton(int number) {
        if (number == 1) {
            b1.setBackgroundColor(Color.BLACK);
            System.out.println("HIGHLIGHTING b1");
            b1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    b1.setBackgroundColor(Color.parseColor("#80FF0000"));
                }
            }, 1200);

        }
        if (number == 2) {
            b2.setBackgroundColor(Color.BLACK);
            System.out.println("HIGHLIGHTING b2");
            b2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    b2.setBackgroundColor(Color.parseColor("#800000FF"));
                }
            }, 1200);

        }
        if (number == 3) {
            b3.setBackgroundColor(Color.BLACK);
            System.out.println("HIGHLIGHTING b3");
            b3.postDelayed(new Runnable() {
                @Override
                public void run() {
                    b3.setBackgroundColor(Color.parseColor("#8000FF00"));
                }
            }, 1200);

        }
        if (number == 4) {
            b4.setBackgroundColor(Color.BLACK);
            System.out.println("HIGHLIGHTING b4");
            b4.postDelayed(new Runnable() {
                @Override
                public void run() {
                    b4.setBackgroundColor(Color.parseColor("#80FFFF00"));
                }
            }, 1200);
        }
    }

    private void highlightNumber2(int number){
        switch(number){
            case 1:
                b1.setBackgroundColor(Color.BLACK);
                break;
            case 2:
                b2.setBackgroundColor(Color.BLACK);
                break;
            case 3:
                b3.setBackgroundColor(Color.BLACK);
                break;
            case 4:
                b4.setBackgroundColor(Color.BLACK);
                break;
        }
    }

    private void enableButtons() {
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
    }

    private void disableButtons() {
        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
    }

    private void unhighlight() {
        b1.setBackgroundColor(Color.parseColor("#80FF0000"));
        b2.setBackgroundColor(Color.parseColor("#800000FF"));
        b3.setBackgroundColor(Color.parseColor("#8000FF00"));
        b4.setBackgroundColor(Color.parseColor("#80FFFF00"));
    }
}