package com.zjgsu.cxxu.toolbartest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val toolbar=findViewById(R.id.toolbar)
        setSupportActionBar(findViewById(R.id.toolbar))
        Log.d(TAG, "onCreate:$ ")
    }
}