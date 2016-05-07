package com.mad.hovansu.soccersocialnetwork.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Hovansu on 29/04/2016.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment frag=null;
        switch (position){
            case 0:
                frag = new MatchFragment();
                break;
            case 1:
                frag = new FieldsFragment();
                break;
            case 2:
                frag=new ProfileFragment();
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title=" ";
        switch (position){
            case 0:
                title="Matches";
                break;
            case 1:
                title="Fields";
                break;
            case 2:
                title="Profile";
                break;
        }

        return title;
    }
}
