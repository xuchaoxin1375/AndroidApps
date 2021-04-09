package com.zjgsu.xcx.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private  val TAG = "MainActivity"
    private lateinit var airplaneModeReceiver: AirplaneModeReceiver
    private lateinit var myBroadcastReceiver: MyBroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.testMyBroadcast)
        button.setOnClickListener {

            Intent().also { intent ->
                intent.setAction("com.example.broadcast.MY_NOTIFICATION")
                intent.putExtra("data", "Notice me senpai!")
                sendBroadcast(intent)
                Log.d(TAG, "onCreate: setOnClickListener")
            }
        }
        /*dynamic declare a broadcast receiver:*/
        /*we need instantiate a IntentFilter to capture the broadcast properly*/
        val intentFilter = IntentFilter()
        val intentFilterMyBroadcastReceiver=IntentFilter()
//        intentFilter.addAction("android.intent.action.TIME_TICK")
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        intentFilterMyBroadcastReceiver.addAction("com.example.broadcast.MY_NOTIFICATION")
        /*instantiate a BroadcastReceiver subclass instance */
        this.airplaneModeReceiver = AirplaneModeReceiver()
        this.myBroadcastReceiver = MyBroadcastReceiver()
        /*the registerReceiver() need the BroadcastReceiver (or its subclass)instance and a intentFilter
        * you should know that the registerReceiver whether to register is depend on the intentFilter instance captured the intent or not ;different broadcastReceiver should set speclized intentFilter separately!*/
        registerReceiver(airplaneModeReceiver, intentFilter)
        registerReceiver(myBroadcastReceiver, intentFilterMyBroadcastReceiver)
    }

    /*we must destroy the broadcast receiver in time!*/
    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(airplaneModeReceiver)
        unregisterReceiver(myBroadcastReceiver)
    }

    //    override fun onDestroy(){
//        super.onDestroy()
//        unregisterReceiver(myBroadcastReceiver)
//    }
    /*the inner class is to instantiate a instance to be the parameter of the registerReceiver()*/
    inner class AirplaneModeReceiver : BroadcastReceiver() {
        /*we need override the onReceive function to*/
        override fun onReceive(context: Context, intent: Intent) {
            Toast.makeText(context, "Time airplaneMode  changed \n"+Log.i(TAG, "onReceive"), Toast.LENGTH_SHORT).show()
            toString().also { log ->
                Log.d(TAG, log)
                Toast.makeText(context, log, Toast.LENGTH_LONG).show()
            }


        }
    }

    inner class MyBroadcastReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            Toast.makeText(context, "MyBroadcast notice is captured!", Toast.LENGTH_SHORT).show()
            toString().also { log ->
                Log.d(TAG, log)
                Toast.makeText(context, log, Toast.LENGTH_LONG).show()
            }
        }
    }

}