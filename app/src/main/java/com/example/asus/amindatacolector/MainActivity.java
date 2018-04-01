package com.example.asus.amindatacolector;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.asus.amindatacolector.Fragments.FourFragment;
import com.example.asus.amindatacolector.Fragments.OneFragment;
import com.example.asus.amindatacolector.Fragments.Rating;
import com.example.asus.amindatacolector.Fragments.ThreeFragment;
import com.example.asus.amindatacolector.Fragments.TwoFragment;

import java.util.HashMap;

import wiadevelopers.com.bottomnavigationlib.BottomNav.BottomNavigationView;
import wiadevelopers.com.bottomnavigationlib.Utils;

public class MainActivity extends AppCompatActivity
{
    ViewPager viewPager;

    BottomNavigationView bottomNavigationView;

    private OneFragment oneFragment;
    private TwoFragment twoFragment;
    private ThreeFragment threeFragment;
    private FourFragment fourFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager)findViewById(R.id.viewPager);
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottomNavigationView);

        setupVewPager(viewPager);
    }

    private void setupVewPager(final ViewPager viewPager)
    {
        oneFragment = new OneFragment();
        twoFragment = new TwoFragment();
        threeFragment = new ThreeFragment();
        fourFragment = new FourFragment();

        Utils.ViewPagerAdapter adapter = new Utils.ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(oneFragment);
        adapter.addFragment(twoFragment);
        adapter.addFragment(threeFragment);
        adapter.addFragment(fourFragment);

        Utils.setUpViewPager(MainActivity.this, viewPager, adapter, bottomNavigationView,
                R.menu.bottom_navigation_items, 3, 0);
    }
}
