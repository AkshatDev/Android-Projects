package com.example.android.tourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import static com.example.android.tourguide.R.string.Events;

/**
 * Created by Lucifer on 03-11-2017.
 */

public class CategoryAdapter extends FragmentPagerAdapter {


    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new Famous_Events();
        } else if (position == 1) {
                return new Places();
        }
        else if(position==2)
        {
            return new Hotels();
        }
        else  {
            return new Traditional_Food();
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(Events);
        } else if (position == 1) {
            return mContext.getString(R.string.places);
        }
        else if(position==2)
        {
            return mContext.getString(R.string.Hotels);
        }
        else  {
            return mContext.getString(R.string.food);
        }
    }
}
