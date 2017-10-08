package com.sanke.ilafedoseev.talkchat.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.sanke.ilafedoseev.talkchat.Fragments.ChatFragment;
import com.sanke.ilafedoseev.talkchat.Fragments.PeopleFragment;

/**
 * Created by ilafedoseev on 08/08/2017.
 */

public class FragmentPageAdapter extends FragmentPagerAdapter {

    private final static int PAGE_COUNT = 2;
    private String tabTitles[] = new String[] { "People", "Chat" };
    private Context context;

    public FragmentPageAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
           return new PeopleFragment();
        } else {
            return new ChatFragment();
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
