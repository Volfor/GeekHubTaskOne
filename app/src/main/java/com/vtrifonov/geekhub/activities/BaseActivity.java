package com.vtrifonov.geekhub.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.vtrifonov.geekhub.R;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        if (isAddFragment() && (savedInstanceState == null)) {
            addFragment();
        }
    }

    public abstract boolean isAddFragment();
    public abstract void addFragment();

}
