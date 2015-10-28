package com.vtrifonov.geekhub.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.vtrifonov.geekhub.R;

public class TaskOneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_one);

        Button btnSend = (Button) findViewById(R.id.btn_send);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText helloMessage = (EditText) findViewById(R.id.edit_message);

                Intent intent = new Intent(TaskOneActivity.this, MessageActivity.class)
                        .putExtra("msg", helloMessage.getText().toString());
                startActivity(intent);
            }
        });
    }

}
