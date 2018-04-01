package com.example.asus.amindatacolector.Fragments;


import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.asus.amindatacolector.Adapter.CustomAdapter;
import com.example.asus.amindatacolector.Main2Activity;
import com.example.asus.amindatacolector.Model.Data;
import com.example.asus.amindatacolector.R;

import java.util.ArrayList;

public class TwoFragment extends Fragment
{
    View view;
    EditText edt_search_profile_fragment_two;
    ImageView ic_search;

    public TwoFragment()
    {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_two_search, container, false);

        initDeclare();

        return view;
    }

    public void initDeclare()
    {
        edt_search_profile_fragment_two = (EditText)view.findViewById(R.id.edt_search_profile_fragment_two);
        ic_search = (ImageView)view.findViewById(R.id.ic_search);
    }
}
