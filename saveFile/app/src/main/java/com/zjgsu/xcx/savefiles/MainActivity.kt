package com.zjgsu.xcx.savefiles

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import java.io.*

class MainActivity : AppCompatActivity() {


    private lateinit var messageText: EditText
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        messageText = findViewById(R.id.msgText)

    }

    override fun onPause() {
        super.onPause()
        val content = messageText.text.toString()
        save(content)
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
            reader.use{
                reader.use{
                    reader.forEachLine {
                        content.append(it+"\n")
                    }
                }
            }

        }
        catch(e:IOException){
            e.printStackTrace()
        }
        return content.toString()
    }
}