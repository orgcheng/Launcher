package com.gionee.amisystem;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.gionee.amisystem.view.CellPagerAdapter;
import com.gionee.amisystem.view.YourPageFragment;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    ViewPager mViewPager;
    int mCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new CellPagerAdapter(this));
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                try {
                    Log.d(TAG, "onPageSelected: position = " +position);
                    if(mCount == 2){
                        YourPageFragment view = (YourPageFragment) mViewPager.getChildAt(0);
                        view.onYourPageSelected(position == 0 ? true : false);
                        Log.d(TAG, "onPageSelected: " +(position == 0 ? true : false));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mCount = mViewPager.getAdapter().getCount();

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(mCount == 2){
            try {
                YourPageFragment view = (YourPageFragment) mViewPager.getChildAt(0);
                view.onYourPageResume();
                Log.d(TAG, "onYourPageResume: ");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mCount == 2){
            try {
                YourPageFragment view = (YourPageFragment) mViewPager.getChildAt(0);
                view.onYourPagePause();
                Log.d(TAG, "onYourPagePause: ");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mCount == 2){
            try {
                YourPageFragment view = (YourPageFragment) mViewPager.getChildAt(0);
                view.onYourPageRemove();
                Log.d(TAG, "onYourPageRemove: ");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
