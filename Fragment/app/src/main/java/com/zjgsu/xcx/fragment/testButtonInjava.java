package com.zjgsu.xcx.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class testButtonInjava extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_button_injava);
        Button button = (Button) findViewById(R.id.testButtonInjava);

//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent=new Intent(this,MainActivity::);
//            }
//        });
        button.setOnClickListener(v -> {
            // Do something in response to button click
            Toast.makeText(this, "test java version", Toast.LENGTH_LONG).show();
        });
    }
}
