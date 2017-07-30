package com.example.android.booklisting;

/**
 * Created by Lucifer on 21-10-2017.
 */

public class Books {

        private String mtitle;
        private String mauthor;
        private String mpublishdate;

        public Books(String title, String author , String publishdate)
        {
            mtitle=title;
            mauthor=author;
            mpublishdate=publishdate;
        }
        public String gettitle()
        {
            return mtitle;
        }
        public String getauthor()
        {
            return mauthor;
        }
        public String getpublishdate()
        {
            return mpublishdate;
        }
    }


