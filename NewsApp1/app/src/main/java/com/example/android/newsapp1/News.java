package com.example.android.newsapp1;

/**
 * Created by Lucifer on 07-11-2017.
 */

public class News {
    private String mtype;
    private String mtitle;
    private String mpublishdate;
    String murl;
    private String mname;


    public News(String type, String title , String publishdate,String url,String name)
    {
        mtitle=title;
        mtype=type;
        mpublishdate=publishdate;
        murl=url;
        mname=name;
    }
    public String gettitle()
    {
        return mtitle;
    }
    public String getwriter()
    {
        return mtype;
    }
    public String getpublishdate()
    {
        return mpublishdate;
    }
    public String geturl(){ return murl;}
    public String getmname(){return mname;}
}
