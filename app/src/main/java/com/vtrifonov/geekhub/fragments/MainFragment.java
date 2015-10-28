package com.vtrifonov.geekhub.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.vtrifonov.geekhub.Navigator;
import com.vtrifonov.geekhub.R;

public class MainFragment extends Fragment {

    private Button btnPrev;
    private Button btnNext;

    private Navigator navigator;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            navigator = (Navigator) activity;
        } catch (ClassCastException exception) {
            throw new ClassCastException(activity.toString() + " Must implement Navigator");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_task_four, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnPrev = (Button) view.findViewById(R.id.btn_prev);
        btnNext = (Button) view.findViewById(R.id.btn_next);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigator.showPrevious();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigator.showNext();
            }
        });
    }

}
