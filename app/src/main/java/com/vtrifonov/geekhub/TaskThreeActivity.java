package com.vtrifonov.geekhub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class TaskThreeActivity extends AppCompatActivity {
    private String[] values = new String[]{"Android", "iPhone", "WindowsMobile",
            "Blackberry", "Ubuntu", "Windows7", "Mac OS X", "Linux", "Ubuntu", "Windows7",
            "Mac OS X", "Linux", "Ubuntu", "Windows7", "Android", "iPhone", "WindowsMobile"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_three);

        createAndShowNumbers();

        findViewById(R.id.button_1).setOnClickListener(clickListener);
        findViewById(R.id.button_2).setOnClickListener(clickListener);
        findViewById(R.id.button_3).setOnClickListener(clickListener);
        findViewById(R.id.button_4).setOnClickListener(clickListener);
    }

    private void createAndShowNumbers() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            list.add(values[i]);
        }

        String strings = TextUtils.join(", ", list);

        TextView text1 = (TextView) findViewById(R.id.text_1);
        text1.setText(strings);
    }

    private void reverseOrder() {
        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(values));

        Collections.reverse(list);

        String strings = TextUtils.join(", ", list);

        TextView text2 = (TextView) findViewById(R.id.text_2);
        text2.setText(strings);
    }

    private void removeEveryThird() {
        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(values));

        for (int i = 2; i < list.size(); i += 2) {
            list.remove(i);
        }

        String strings = TextUtils.join(", ", list);

        TextView text2 = (TextView) findViewById(R.id.text_2);
        text2.setText(strings);
    }

    private void removeDuplicates() {
        HashSet<String> set = new HashSet<>();
        set.addAll(Arrays.asList(values));

        String strings = TextUtils.join(", ", set);

        TextView text2 = (TextView) findViewById(R.id.text_2);
        text2.setText(strings);
    }

    private void sortValues() {
        ArrayList<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(values));

        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);

        String strings = TextUtils.join(", ", list);

        TextView text2 = (TextView) findViewById(R.id.text_2);
        text2.setText(strings);

    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button_1:
                    reverseOrder();
                    break;
                case R.id.button_2:
                    removeEveryThird();
                    break;
                case R.id.button_3:
                    removeDuplicates();
                    break;
                case R.id.button_4:
                    sortValues();
                    break;
            }
        }
    };
}
