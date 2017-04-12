package com.gionee.amisystem;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.gionee.amisystem.view.CellPagerAdapter;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new CellPagerAdapter(this));

        int count = mViewPager.getAdapter().getCount();
        Log.d(TAG, "onCreate: count = " +  count);
    }
}
