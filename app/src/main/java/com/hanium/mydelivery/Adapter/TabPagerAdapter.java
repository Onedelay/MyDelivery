package com.hanium.mydelivery.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.hanium.mydelivery.Data.Shop;
import com.hanium.mydelivery.fragment.ListFragment;

/**
 * Created by sclab on 2017-07-04.
 */

public class TabPagerAdapter extends FragmentStatePagerAdapter {
    // Count number of tabs
    private int tabCount;

    public TabPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {

        // Returning the current tabs
        switch (position) {
            case 0:
                return ListFragment.newInstace(Shop.TYPE_KOREA);
            case 1:
                return ListFragment.newInstace(Shop.TYPE_CHINA);
            case 2:
                return ListFragment.newInstace(Shop.TYPE_JAPEN);
            case 3:
                return ListFragment.newInstace(Shop.TYPE_AMERI);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }

}
