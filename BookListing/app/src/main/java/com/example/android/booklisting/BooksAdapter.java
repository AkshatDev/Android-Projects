package com.example.android.booklisting;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import static android.R.attr.id;

/**
 * Created by Lucifer on 21-10-2017.
 */

public class BooksAdapter extends ArrayAdapter<Books> {
    public BooksAdapter(Context context, List<Books> books)
    {
        super(context,0,books);
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


       Books currentbook = getItem(position);


        TextView name = (TextView) listItemView.findViewById(R.id.name);

        name.setText(currentbook.gettitle());

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView author = (TextView) listItemView.findViewById(R.id.author);

        author.setText(currentbook.getauthor());

        TextView date = (TextView) listItemView.findViewById(R.id.date);

        date.setText(currentbook.getpublishdate());

        return listItemView;
    }

}
