package com.adinda.meetup.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import com.adinda.meetup.fragment.ExploreFragment;
import com.adinda.meetup.fragment.FriendFragment;
import com.adinda.meetup.fragment.ChatFragment;

public class CustomFragmentPageAdapter extends FragmentPagerAdapter {
    private static final String TAG = CustomFragmentPageAdapter.class.getSimpleName();
    private static final int FRAGMENT_COUNT = 4;
    public CustomFragmentPageAdapter(FragmentManager fm) {

        super (fm);
    }
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ExploreFragment();
                case 1:
                return new ChatFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return FRAGMENT_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Home";
            case 1:
                return "Explore";
            case 2:
                return "Messages";
        }
        return null;
    }
   }
