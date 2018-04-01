package com.example.asus.amindatacolector.Fragments;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;
import com.example.asus.amindatacolector.R;



public class Rating extends Fragment
{
    Button btnSet;
    RatingBar rating;

    public Rating()
    {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.rating, container, false);
        btnSet = (Button)view.findViewById(R.id.btn_set);
        rating = (RatingBar)view.findViewById(R.id.rating_bar);

        btnSet.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                MediaPlayer mp = MediaPlayer.create(getContext(), R.raw.button_sound);
                mp.start();
                try
                {
                    String str = String.valueOf(rating.getRating());
                    Toast.makeText(getContext(), "Your Rate Is:" + str, Toast.LENGTH_SHORT).show();
                }
                catch (Exception ex)
                {
                    ex.fillInStackTrace();
                }
            }
        });
        return view;
    }
}
