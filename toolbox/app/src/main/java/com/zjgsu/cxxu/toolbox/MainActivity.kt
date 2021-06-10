package com.zjgsu.cxxu.toolbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        memoBtn.setOnClickListener {
//            make a toast for click the MemoNote:
            Toast.makeText(
                applicationContext,
                "the MemoNote will save the content you typed automatically",
                Toast.LENGTH_LONG
            ).show()
            val intent = Intent(this, MemoNote::class.java)
            startActivity(intent)
        }

    }
}
