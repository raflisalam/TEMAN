package com.raflisalam.appteman.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.raflisalam.appteman.slider.AdapterSlider;
import com.raflisalam.appteman.R;

public class MainActivity extends AppCompatActivity {

    ViewPager slider;
    int total = 3 , count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slider = findViewById(R.id.slider);
        slider.setAdapter(new AdapterSlider(getSupportFragmentManager()));

        slider.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                count = 0;
                count = position + 1;

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

}