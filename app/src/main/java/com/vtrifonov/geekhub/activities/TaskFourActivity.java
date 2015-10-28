package com.vtrifonov.geekhub.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.vtrifonov.geekhub.fragments.MainFragment;
import com.vtrifonov.geekhub.Navigator;
import com.vtrifonov.geekhub.fragments.NextFragment;
import com.vtrifonov.geekhub.fragments.PreviousFragment;
import com.vtrifonov.geekhub.R;

public class TaskFourActivity extends BaseActivity implements Navigator {

    private FragmentManager manager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean isAddFragment() {
        return true;
    }

    @Override
    public void addFragment() {
        manager.beginTransaction().add(R.id.fragment_container, new MainFragment()).commit();
    }

    @Override
    public void showPrevious() {
        manager.beginTransaction().replace(R.id.fragment_container, new PreviousFragment()).addToBackStack(null).commit();
    }

    @Override
    public void showNext() {
        manager.beginTransaction().replace(R.id.fragment_container, new NextFragment()).addToBackStack(null).commit();
    }

}
