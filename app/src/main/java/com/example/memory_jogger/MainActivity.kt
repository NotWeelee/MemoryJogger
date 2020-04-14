package com.example.memory_jogger

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import com.example.memory_jogger.playActivity2 as playActivity21

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {        //When class is created, do this{
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)                  //show this layout

        playMenuButton.setOnClickListener {             //when playMenuButton is clicked start playActivity
            startActivity(Intent(this, playActivity21::class.java))

        }
    }
}