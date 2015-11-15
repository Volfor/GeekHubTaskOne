package com.vtrifonov.geekhub.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.vtrifonov.geekhub.R;
import com.vtrifonov.geekhub.fragments.ArticlesFragment;
import com.vtrifonov.geekhub.fragments.DetailsFragment;

public class TaskSixActivity extends AppCompatActivity implements ArticlesFragment.OnArticleSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_six);

        if (findViewById(R.id.articles_container) != null) {
            if (getSupportFragmentManager().findFragmentByTag("details fragment") == null) {
                ArticlesFragment articlesFragment = new ArticlesFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.articles_container, articlesFragment).commit();
            }
        } else {
            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

            Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar_task_six);
            setSupportActionBar(toolbar);

            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setDisplayHomeAsUpEnabled(true);
            }

            DetailsFragment detailsFragment = (DetailsFragment)
                    getSupportFragmentManager().findFragmentById(R.id.details_fragment);

            detailsFragment.updateDetailsView(0);
        }
    }

    @Override
    public void onArticleSelected(int position) {
        DetailsFragment detailsFragment = (DetailsFragment)
                getSupportFragmentManager().findFragmentById(R.id.details_fragment);

        if (findViewById(R.id.details_fragment) != null) {
            if (detailsFragment != null) {
                detailsFragment.updateDetailsView(position);
            }
        } else {
            DetailsFragment newDetailsFragment = new DetailsFragment();
            Bundle args = new Bundle();
            args.putInt(DetailsFragment.ARG_POSITION, position);
            newDetailsFragment.setArguments(args);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.articles_container, newDetailsFragment, "details fragment")
                    .addToBackStack(null)
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                    getSupportFragmentManager().popBackStack();
                } else {
                    finish();
                }
                overridePendingTransition(R.anim.stay, R.anim.slide_out);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
