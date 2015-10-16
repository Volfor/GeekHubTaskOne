package com.vtrifonov.geekhub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        TextView helloMessage = (TextView) findViewById(R.id.view_message);
        String s = getIntent().getStringExtra("msg");
        if (s.trim().length() > 0)
            helloMessage.setText(s);
        else
            helloMessage.setText(R.string.hello_world);
    }

}
