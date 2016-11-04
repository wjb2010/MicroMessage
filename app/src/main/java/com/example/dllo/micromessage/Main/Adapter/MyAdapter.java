package com.example.dllo.micromessage.Main.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/25.
 */

public class MyAdapter extends FragmentPagerAdapter{
    private ArrayList<Fragment> data;
    private String[] title={"拨号","通话记录","联系人","短语"};

    public MyAdapter(FragmentManager fm,ArrayList<Fragment> data) {
        super(fm);
        this.data=data;
    }



    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }



       @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }


}
