package com.vtrifonov.geekhub.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.vtrifonov.geekhub.R;

public class TaskFiveActivity extends AppCompatActivity {

    TextView textAnim;
    Animation animFadeIn, animFadeOut, animBlink, animZoomIn, animRotate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_five);

        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar_task_five);
        setSupportActionBar(toolbar);

        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }

        textAnim = (TextView) findViewById(R.id.txt_anim);

        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
        animBlink = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        animZoomIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
        animRotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);

        findViewById(R.id.btn_fade_in).setOnClickListener(clickListener);
        findViewById(R.id.btn_fade_out).setOnClickListener(clickListener);
        findViewById(R.id.btn_blink).setOnClickListener(clickListener);
        findViewById(R.id.btn_zoom_in).setOnClickListener(clickListener);
        findViewById(R.id.btn_rotate).setOnClickListener(clickListener);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                overridePendingTransition(R.anim.stay, R.anim.slide_out);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_fade_in:
                    textAnim.startAnimation(animFadeIn);
                    break;
                case R.id.btn_fade_out:
                    textAnim.startAnimation(animFadeOut);
                    break;
                case R.id.btn_blink:
                    textAnim.startAnimation(animBlink);
                    break;
                case R.id.btn_zoom_in:
                    textAnim.startAnimation(animZoomIn);
                    break;
                case R.id.btn_rotate:
                    textAnim.startAnimation(animRotate);
                    break;
            }
        }
    };

}
