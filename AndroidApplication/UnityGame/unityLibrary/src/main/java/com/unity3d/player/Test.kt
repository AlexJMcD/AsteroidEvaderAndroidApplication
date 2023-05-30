package com.unity3d.player

import android.util.Log

class Test: UnityPlayerActivity() {
    override fun onPause() {
        super.onPause()
        Log.d("TestDestroy", "TestDestroy")
    }
}