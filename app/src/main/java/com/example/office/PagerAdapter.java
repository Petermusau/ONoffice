package com.example.office;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNoOfTabs;
    public  PagerAdapter(FragmentManager fm, int NumberOfTabs )
    { super(fm);
        this.mNoOfTabs=NumberOfTabs;


    }
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                Staff tab1= new Staff();
                return tab1;

            case 1:
                Goods tab2=new Goods();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {

        return mNoOfTabs;
    }
}



