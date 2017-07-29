package com.example.android.tourguide;

/**
 * Created by Lucifer on 04-11-2017.
 */

public class Info {

    private String description1;
    private String desctiption2;
    private int ss = -1;
    private int mImageResourceId = ss;


    public Info(String description1w, String desctiption2w, int imageresourceid) {
        description1 = description1w;
        desctiption2 = desctiption2w;
        mImageResourceId = imageresourceid;

    }

    public String getHeading() {
        return desctiption2;
    }

    public String getdDescription() {
        return description1;
    }

    public int getimagerosuorceid() {
        return mImageResourceId;
    }

}
