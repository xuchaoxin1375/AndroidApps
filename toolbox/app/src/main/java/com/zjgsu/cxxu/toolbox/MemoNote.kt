package com.zjgsu.cxxu.toolbox

//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle

//class MemoNote : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_memo_note)
//    }
//}

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import java.io.*

class MemoNote : AppCompatActivity() {


    lateinit var messageText: EditText

    //    notification test:
    lateinit var manager: NotificationManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memo_note)

        messageText = findViewById(R.id.editTextTextMultiLine)
        //        Create a channel and set the importance
//        createNotificationChannel()
    }
    override fun onPause() {
        super.onPause()
        val content = messageText.text.toString()
        save(content)
//        set and show the notification
        createNotificationChannel()
        val notification=buildNotificationContent()
        manager.notify(1, notification)
    }

    private fun createNotificationChannel() {
        manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel("normal", "Normal", NotificationManager.IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(channel)
            val channel2 =
                NotificationChannel("important", "Important", NotificationManager.IMPORTANCE_HIGH)
            manager.createNotificationChannel(channel2)
        }
    }

    private fun buildNotificationContent(): Notification {
        //            Set the notification's tap action
//        val intent = Intent(this, NotificationActivity::class.java)
//
//        val pi = PendingIntent.getActivity(this, 0, intent, 0)
//            Set the notification content
        val notification = NotificationCompat.Builder(this, "important")
            .setContentTitle("Title:save completed!")
            .setContentText("save completed!")
            //  .setStyle(NotificationCompat.BigTextStyle().bigText("Learn how to build notifications, send and sync data, and use voice actions. Get the official Android IDE and developer tools to build apps for Android."))
//           .setStyle(NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(resources, R.drawable.big_image)))
            .setSmallIcon(R.drawable.small_icon)
            .setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.large_icon))
//            .setContentIntent(pi)
            .setAutoCancel(true)
            .build()
        return notification
    }

    override fun onResume() {
        super.onResume()
        val content = load()
        if (content.isNotEmpty()) {
            messageText.setText(content)
        }
    }


    private fun save(inputText: String) {
        try {
            val output = openFileOutput("data", Context.MODE_PRIVATE)
            val writer = BufferedWriter(OutputStreamWriter(output))
            writer.use {
                it.write(inputText)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        /*save as shared files(xml)*/
//        val editor = getSharedPreferences("data", Context.MODE_PRIVATE).edit()
//        editor.putString("name", "Tom")
//        editor.putInt("age", 28)
//        editor.putBoolean("married", false)
//        editor.apply()
    }

    private fun load(): String {
        val content = StringBuilder()
        try {
            val input = openFileInput("data")
            val reader = BufferedReader(InputStreamReader(input))
            reader.use {
                reader.use {
                    reader.forEachLine {
                        content.append(it + "\n")
                    }
                }
            }

        } catch (e: IOException) {
            e.printStackTrace()
        }
        return content.toString()
    }
}