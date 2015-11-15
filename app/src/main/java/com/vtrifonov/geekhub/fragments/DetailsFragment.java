package com.vtrifonov.geekhub.fragments;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vtrifonov.geekhub.R;

public class DetailsFragment extends Fragment {

    public final static String ARG_POSITION = "position";
    int mCurrentPosition = -1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle args = getArguments();
        if (args != null) {
            updateDetailsView(args.getInt(ARG_POSITION));
        } else if (mCurrentPosition != -1) {
            updateDetailsView(mCurrentPosition);
        }

        if (getActivity().findViewById(R.id.articles_container) != null) {
            Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.details_toolbar);
            ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

            ActionBar supportActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setDisplayHomeAsUpEnabled(true);
            }

            CollapsingToolbarLayout collapsingToolbar =
                    (CollapsingToolbarLayout) getActivity().findViewById(R.id.collapsing_toolbar);
            collapsingToolbar.setTitle(getResources().getStringArray(R.array.articles_array)[mCurrentPosition]);
            collapsingToolbar.setExpandedTitleTextAppearance(R.style.CollapsedAppBar);
        }
    }

    public void updateDetailsView(int position) {
        TypedArray images = getResources().obtainTypedArray(R.array.details_pictures);
        String[] text = getResources().getStringArray(R.array.details_text);

        ImageView image = (ImageView) getActivity().findViewById(R.id.image);
        image.setImageDrawable(images.getDrawable(position));

        TextView article = (TextView) getActivity().findViewById(R.id.txt_details_description);
        article.setText(text[position]);

        TextView description = (TextView) getActivity().findViewById(R.id.txt_description);
        description.setVisibility(View.VISIBLE);

        images.recycle();

        mCurrentPosition = position;
    }

}
