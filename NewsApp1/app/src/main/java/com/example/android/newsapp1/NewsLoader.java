package com.example.android.newsapp1;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

import static com.example.android.newsapp1.QueryUtils.extractnews;

/**
 * Created by Lucifer on 07-11-2017.
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
