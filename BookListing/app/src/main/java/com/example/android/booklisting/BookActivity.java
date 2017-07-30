package com.example.android.booklisting;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.id;

public class BookActivity extends AppCompatActivity implements android.app.LoaderManager.LoaderCallbacks<List<Books>> {

    public static final String LOG_TAG = BookActivity.class.getName();
    private static final String BOOKSURL = "https://content.guardianapis.com/search";
    private BooksAdapter mAdapter;
    private static final int i = 1;
    private TextView emptyView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        emptyView= (TextView) findViewById(R.id.empty_view);
        emptyView.setText("Please Search A Book For Results");
        mAdapter = new BooksAdapter(this, new ArrayList<Books>());


        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);




        earthquakeListView.setAdapter(mAdapter);
        earthquakeListView.setEmptyView(emptyView);




        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();


        if (networkInfo != null && networkInfo.isConnected()) {

            android.app.LoaderManager loaderManager=getLoaderManager();
            loaderManager.initLoader(id, null, this);
        }
        else
        {
            View loadingIndicator = findViewById(R.id.progress);
            loadingIndicator.setVisibility(View.GONE);
            emptyView.setText("No internet connection");
        }


    }

    @Override
    public android.content.Loader<List<Books>> onCreateLoader(int i, Bundle bundle) {

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        String q = sharedPrefs.getString(
                getString(R.string.settings_name_key),
                getString(R.string.settings_name_default));
        String orderBy = sharedPrefs.getString(
                getString(R.string.settings_order_by_key),
                getString(R.string.settings_order_by_default)
        );Uri baseUri = Uri.parse(BOOKSURL);
        Uri.Builder uriBuilder = baseUri.buildUpon();


        uriBuilder.appendQueryParameter("q", q);
        uriBuilder.appendQueryParameter("orderBy", orderBy);

        return new BooksLoader(this, uriBuilder.toString());
    }

    @Override
    public void onLoadFinished(android.content.Loader<List<Books>> loader, List<Books> books) {

        View loadingIndicator = findViewById(R.id.progress);
        loadingIndicator.setVisibility(View.GONE);
        mAdapter.clear();


        if (books != null && !books.isEmpty()) {
            mAdapter.addAll(books);
        }

    }

    @Override
        public void onLoaderReset(android.content.Loader<List<Books>> loader) {
        mAdapter.clear();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent settingsIntent = new Intent(this, Settings.class);
            startActivity(settingsIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
