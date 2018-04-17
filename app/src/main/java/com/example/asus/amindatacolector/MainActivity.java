package com.example.asus.amindatacolector;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.crashlytics.android.Crashlytics;
import com.example.asus.amindatacolector.Fragments.FourFragment;
import com.example.asus.amindatacolector.Fragments.OneFragment;
import com.example.asus.amindatacolector.Fragments.ThreeFragment;

import io.fabric.sdk.android.Fabric;
import wiadevelopers.com.bottomnavigationlib.BottomNav.BottomNavigationView;
import wiadevelopers.com.bottomnavigationlib.Utils;

public class MainActivity extends AppCompatActivity
{
    ViewPager viewPager;

    BottomNavigationView bottomNavigationView;

    private OneFragment oneFragment;
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
        threeFragment = new ThreeFragment();
        fourFragment = new FourFragment();

        Utils.ViewPagerAdapter adapter = new Utils.ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(oneFragment);
        adapter.addFragment(threeFragment);
        adapter.addFragment(fourFragment);

        Utils.setUpViewPager(MainActivity.this, viewPager, adapter, bottomNavigationView,
                R.menu.bottom_navigation_items, 3, 0);
    }
}
