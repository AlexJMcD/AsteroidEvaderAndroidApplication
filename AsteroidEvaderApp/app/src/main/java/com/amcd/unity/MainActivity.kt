package com.amcd.unity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.unity3d.player.Test
import com.unity3d.player.UnityPlayerActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStartGame = findViewById<Button>(R.id.btnStartGame)
        btnStartGame.setOnClickListener {
            startActivity(Intent(this, Test::class.java))
        }
    }
}