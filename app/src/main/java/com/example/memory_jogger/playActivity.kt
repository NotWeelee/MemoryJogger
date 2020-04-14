package com.example.memory_jogger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.play_layout.*

class playActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {        //when layout is created do this{
        super.onCreate(savedInstanceState)
        setContentView(R.layout.play_layout)                    //show

        redButton.setTag(1)
        blueButton.setTag(2)
        greenButton.setTag(3)
        yellowButton.setTag(4)

        startGameButton.setOnClickListener{
        }
    }
}