package com.example.android.booklisting;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

import static com.example.android.booklisting.QueryUtils.extractBooks;

/**
 * Created by Lucifer on 21-10-2017.
 */

public class BooksLoader extends AsyncTaskLoader<List<Books>> {
    String murl;

    public BooksLoader(Context context, String url)
    {
        super(context);
        murl=url;
    }
    @Override
    public void onStartLoading()
    {
        forceLoad();
    }
    public List<Books> loadInBackground()
    {
        if(murl==null)
        {
            return null;
        }
        else
        {
            return extractBooks(murl);
        }
    }
}
