package com.raflisalam.appteman.slider;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.raflisalam.appteman.slider.slide1;
import com.raflisalam.appteman.slider.slide2;
import com.raflisalam.appteman.slider.slide3;

public class AdapterSlider extends FragmentStatePagerAdapter {


    public AdapterSlider(@NonNull FragmentManager fm) {
        super(fm);
    }

    public AdapterSlider(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new slide1();
            case 1:
                return new slide2();
            case 2:
                return new slide3();
            default:
                return new slide1();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
