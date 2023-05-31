package com.amcd.unity.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class BootActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        runBlocking {
            installSplashScreen()
            delay(5000)
        }
        val bootIntent = Intent(this, MainActivity::class.java)
        startActivity(bootIntent)
        finish()
    }
}