package com.example.android.newsreoprt;

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
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.id;

public class MainActivity extends AppCompatActivity implements android.app.LoaderManager.LoaderCallbacks<List<News>> {
    public static final String LOG_TAG = MainActivity.class.getName();
    private static final String Guardianurl = "https://content.guardianapis.com/search";
    private NewsAdapter mAdapter;
    private static final int i = 1;
    private TextView emptyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<News> n=new ArrayList();


        emptyView= (TextView) findViewById(R.id.empty_view);
        emptyView.setText("Empty");
        mAdapter = new NewsAdapter(this, n);



        // Find a reference to the {@link ListView} in the layout
        ListView NewsListView = (ListView) findViewById(R.id.list);




        NewsListView.setAdapter(mAdapter);
        NewsListView.setEmptyView(emptyView);

        NewsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                News z = n.get(position);
                Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(z.geturl()));
                startActivity(intent);
            }
        });



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
    public android.content.Loader<List<News>> onCreateLoader(int i, Bundle bundle) {


        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        String q = sharedPrefs.getString(
                getString(R.string.settings_name_key),
                getString(R.string.settings_name_default));
        String orderBy = sharedPrefs.getString(
                getString(R.string.settings_order_by_key),
                getString(R.string.settings_order_by_default)
        );Uri baseUri = Uri.parse(Guardianurl);
        Uri.Builder uriBuilder = baseUri.buildUpon();


        uriBuilder.appendQueryParameter("q", q);
        uriBuilder.appendQueryParameter("orderBy", orderBy);
        uriBuilder.appendQueryParameter("api-key","1a21a267-da72-4dba-be0d-8f6fe2edc38d");

        return new NewsLoader(this, uriBuilder.toString());
    }

    @Override
    public void onLoadFinished(android.content.Loader<List<News>> loader, List<News> news) {

        View loadingIndicator = findViewById(R.id.progress);
        loadingIndicator.setVisibility(View.GONE);
        mAdapter.clear();


        if (news != null && !news.isEmpty()) {
            mAdapter.addAll(news);
        }


    }

    @Override
    public void onLoaderReset(android.content.Loader<List<News>> loader) {
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
            Intent settingsIntent = new Intent(this, SettingsActivity.class);
            startActivity(settingsIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
