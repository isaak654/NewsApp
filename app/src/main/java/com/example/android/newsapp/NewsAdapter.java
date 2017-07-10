package com.example.android.newsapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * A {@link NewsAdapter} knows how to create a list item layout for each article
 * in the data source (a list of {@link News} objects).
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(Activity context, ArrayList<News> news) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for multiple TextViews, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, news);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link News} object located at this position in the list
        News currentArticle = getItem(position);

        // Find the TextView with view ID title
        TextView titleView = (TextView) listItemView.findViewById(R.id.title);
        // Display the title of the current article in that TextView
        titleView.setText(currentArticle.getTitle());

        // Find the TextView with view ID category
        TextView authorView = (TextView) listItemView.findViewById(R.id.category);
        // Display the category of the current article in that TextView
        authorView.setText(currentArticle.getCategory());

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        //Display the year of the current article in that TextView
        dateView.setText(getFormartedDate(currentArticle.getDate()));

        // Return the whole list item layout that is now showing the appropriate data
        return listItemView;
    }

    public String getFormartedDate(String pubDate) {
        // get date, convert date to readable format and assign to ID
        SimpleDateFormat inputDate = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss'Z'", Locale.US);
        Date date = null;
        try {
            date = inputDate.parse(pubDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        DateFormat outputDate = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
        return outputDate.format(date);
    }

}