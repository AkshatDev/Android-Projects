package com.example.android.newsreoprt;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

import static com.example.android.newsreoprt.QueryUtils.extractnews;

/**
 * Created by Lucifer on 22-10-2017.
 */

public class NewsLoader extends AsyncTaskLoader<List<News>> {
    String murl;

    public NewsLoader(Context context, String url)
    {
        super(context);
        murl=url;
    }
    @Override
    public void onStartLoading()
    {
        forceLoad();
    }
    public List<News> loadInBackground()
    {
        if(murl==null)
        {
            return null;
        }
        else
        {
            return extractnews(murl);
        }
    }
}
