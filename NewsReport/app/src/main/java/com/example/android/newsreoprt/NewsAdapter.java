package com.example.android.newsreoprt;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Lucifer on 22-10-2017.
 */

public class NewsAdapter extends ArrayAdapter<News> {
    public NewsAdapter(Context context, List<News> earthquakes)
    {
        super(context,0,earthquakes);
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


        News currentnews = getItem(position);


        TextView name = (TextView) listItemView.findViewById(R.id.writer);

        name.setText(currentnews.getwriter());

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView author = (TextView) listItemView.findViewById(R.id.title);

        author.setText(currentnews.gettitle());

        TextView date = (TextView) listItemView.findViewById(R.id.date);

        date.setText(currentnews.getpublishdate());

        return listItemView;
    }

}
