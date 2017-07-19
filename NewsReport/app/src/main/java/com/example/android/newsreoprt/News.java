package com.example.android.newsreoprt;

import static android.R.attr.author;

/**
 * Created by Lucifer on 22-10-2017.
 */

public class News {
    private String mwriter;
    private String mtitle;
    private String mpublishdate;
    String murl;

    public News(String name, String title , String publishdate,String url)
    {
        mtitle=title;
        mwriter=name;
        mpublishdate=publishdate;
        murl=url;
    }
    public String gettitle()
    {
        return mtitle;
    }
    public String getwriter()
    {
        return mwriter;
    }
    public String getpublishdate()
    {
        return mpublishdate;
    }
    public String geturl(){ return murl;}
}
