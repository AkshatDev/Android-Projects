package com.example.android.booklisting;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import static com.example.android.booklisting.BookActivity.LOG_TAG;

/**
 * Created by Lucifer on 21-10-2017.
 */

public final class QueryUtils {


    public static List<Books> extractBooks(String url) {

        URL u = createUrl(url);
        // Create an empty ArrayList that we can start adding books to
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpsRequest(u);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error closing input stream", e);
        }
        List<Books>books = extractFeatureFromJson(jsonResponse);
        return books;
    }

    // Try to parse the SAMPLE_JSON_RESPONSE. If there's a problem with the way the JSON
    // is formatted, a JSONException exception object will be thrown.
    // Catch the exception so the app doesn't crash, and print the error message to the logs.
    private static List<Books> extractFeatureFromJson(String jsonResponse){

        if (TextUtils.isEmpty(jsonResponse)) {
            return null;
        }
        List<Books> earthquakes=new ArrayList<>();

        try {

            // TODO: Parse the response given by the SAMPLE_JSON_RESPONSE string and
            // build up a list of Books objects with the corresponding data.

            JSONObject basejasonresponse = new JSONObject(jsonResponse);
            JSONArray array= basejasonresponse.getJSONArray("items");
            for (int i = 0; i<array.length(); i++ )
            {
                JSONObject a=array.getJSONObject(i);
                JSONObject b=a.getJSONObject("volumeInfo");
                String title=b.getString("title");
                String publishedDate=b.getString("publishedDate");
                JSONArray c=b.getJSONArray("authors");
                String strings[] = new String[c.length()];
                for(int j=0;j<c.length();j++) {
                    strings[j] = c.getString(j);
                }
                StringBuilder z=new StringBuilder();
                for(int j=0;j<strings.length;j++) {
                    z.append(strings[j]);
                    z.append(" ");
                }
                Books book = new Books(title,z.toString(),publishedDate);
                earthquakes.add(book);
            }
        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the book JSON results", e);
        }

        // Return the list of earthquakes
        return earthquakes;
    }


    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Error with creating URL ", e);
        }
        return url;
    }



    private static String makeHttpsRequest(URL url) throws IOException {
        String jsonResponse = "";

        // If the URL is null, then return early.
        if (url == null) {
            return jsonResponse;
        }

        HttpsURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving the book JSON results.", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return jsonResponse;
    }
    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

}