package com.adinda.meetup.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.adinda.meetup.fragment.EventFragment;
import com.adinda.meetup.fragment.ExploreFragment;
import com.adinda.meetup.fragment.GroupFragment;
import com.adinda.meetup.fragment.HomeFragment;
import com.adinda.meetup.fragment.ProfileFragment;

public class PageAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public PageAdapter(FragmentManager fm, int NumberOfTabs)
    {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        switch(position)
        {

            case 0:
                HomeFragment tab1 = new HomeFragment();
                return tab1;
            case 1:
                GroupFragment tab2 = new GroupFragment();
                return  tab2;
            case 2:
                ExploreFragment tab3 = new ExploreFragment();
                return  tab3;
            case 3:
                EventFragment tab4 = new EventFragment();
                return  tab4;
            case 4:
                ProfileFragment tab5 = new ProfileFragment();
                return  tab5;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}

