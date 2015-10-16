package com.vtrifonov.geekhub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTaskOne = (Button) findViewById(R.id.btn_task_one);
        Button btnTaskTwo = (Button) findViewById(R.id.btn_task_two);

        btnTaskOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TaskOneActivity.class);
                startActivity(intent);
            }
        });

        btnTaskTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TaskTwoActivity.class);
                startActivity(intent);
            }
        });
    }
}
