package com.example.android.inventory1;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.android.inventory1.data.ProductsContract;
import com.example.android.inventory1.data.ProductsDbHelper;

import java.math.BigInteger;

public class CatalogActivity extends AppCompatActivity {

    /** Database helper that will provide us access to the database */
    private ProductsDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        // Setup FAB to open EditorActivity
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CatalogActivity.this, EditorActivity.class);
                startActivity(intent);
            }
        });

        // To access our database, we instantiate our subclass of SQLiteOpenHelper
        // and pass the context, which is the current activity.
        mDbHelper = new ProductsDbHelper(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        displayDatabaseInfo();
    }

    /**
     * Temporary helper method to display information in the onscreen TextView about the state of
     * the products database.
     */
    private Cursor read_products()
    {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        String[] projection = {
                ProductsContract.ProductsEntry._ID,
                ProductsContract.ProductsEntry.COLUMN_NAME,
                ProductsContract.ProductsEntry.COLUMN_PRICE,
                ProductsContract.ProductsEntry.COLUMN_QUANTITY,

                ProductsContract.ProductsEntry.COLUMN_SUPPLIER_NAME,
                ProductsContract.ProductsEntry.COLUMN_SUPPLIER_PHONE,
                ProductsContract.ProductsEntry.COLUMN_SUPPLIER_EMAIL

        };

        // Perform a query on the current table
        Cursor cursor = db.query(
                ProductsContract.ProductsEntry.TABLE_NAME,   // The table to query
                projection,            // The columns to return
                null,                  // The columns for the WHERE clause
                null,                  // The values for the WHERE clause
                null,                  // Don't group the rows
                null,                  // Don't filter by row groups
                null);                 // The sort order
        return cursor;

    }
    private void displayDatabaseInfo() {
       Cursor cursor= read_products();

        TextView displayView = (TextView) findViewById(R.id.text_view_pet);

        try {
            // Create a header in the Text View that looks like this:
            //
            // Current table contains <number of rows in Cursor>table.

            //
            // In the while loop below, iterate through the rows of the cursor and display
            // the information from each column in this order.
            displayView.setText("The products table contains " + cursor.getCount() + " pets.\n\n");
            displayView.append(ProductsContract.ProductsEntry._ID + " - " +
                    ProductsContract.ProductsEntry.COLUMN_NAME +" - " +
                    ProductsContract.ProductsEntry.COLUMN_PRICE + " - " +
                    ProductsContract.ProductsEntry.COLUMN_QUANTITY + " - " +

                    ProductsContract.ProductsEntry.COLUMN_SUPPLIER_NAME+ " - " +
                    ProductsContract.ProductsEntry.COLUMN_SUPPLIER_PHONE + " - " +
                    ProductsContract.ProductsEntry.COLUMN_SUPPLIER_EMAIL + "\n");

            // Figure out the index of each column
            int idColumnIndex = cursor.getColumnIndex(ProductsContract.ProductsEntry._ID);
            int nameColumnIndex = cursor.getColumnIndex(ProductsContract.ProductsEntry.COLUMN_NAME);
            int priceColumnIndex = cursor.getColumnIndex(ProductsContract.ProductsEntry.COLUMN_PRICE);
            int quantityColumnIndex = cursor.getColumnIndex(ProductsContract.ProductsEntry.COLUMN_QUANTITY);
            int suppnameColumnIndex = cursor.getColumnIndex(ProductsContract.ProductsEntry.COLUMN_SUPPLIER_NAME);
            int suppphoneColumnIndex = cursor.getColumnIndex(ProductsContract.ProductsEntry.COLUMN_SUPPLIER_PHONE);
            int suppemailColumnIndex = cursor.getColumnIndex(ProductsContract.ProductsEntry.COLUMN_SUPPLIER_EMAIL);


            // Iterate through all the returned rows in the cursor
            while (cursor.moveToNext()) {
                // Use that index to extract the String or Int value of the word
                // at the current row the cursor is on.
                int currentID = cursor.getInt(idColumnIndex);
                String currentName = cursor.getString(nameColumnIndex);
                int currentPrice = cursor.getInt(priceColumnIndex);
                int currentQuantity = cursor.getInt(quantityColumnIndex);
                String currentSupname = cursor.getString(suppnameColumnIndex);
                int currentSupphone = cursor.getInt(suppphoneColumnIndex);
                String currentSupemail = cursor.getString(suppemailColumnIndex);
                // Display the values from each column of the current row in the cursor in the TextView
                displayView.append(("\n" + currentID + " - " +
                        currentName + " - " +
                        currentPrice + " - " +
                        currentQuantity + " - " +
                        currentSupname + " - "+
                        currentSupphone + " - "+
                        currentSupemail ));
            }
        } finally {
            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.
            cursor.close();
        }
    }


    private void insertProducts() {
        // Gets the database in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a ContentValues object where column names are the keys,

        ContentValues values = new ContentValues();
        values.put(ProductsContract.ProductsEntry.COLUMN_NAME, "Camera");
        values.put(ProductsContract.ProductsEntry.COLUMN_PRICE, "5");
        values.put(ProductsContract.ProductsEntry.COLUMN_QUANTITY,"1");
        values.put(ProductsContract.ProductsEntry.COLUMN_SUPPLIER_NAME, "ABC");
        values.put(ProductsContract.ProductsEntry.COLUMN_SUPPLIER_PHONE, 447554564);
        values.put(ProductsContract.ProductsEntry.COLUMN_SUPPLIER_EMAIL, "abc@xyz");

        long newRowId = db.insert(ProductsContract.ProductsEntry.TABLE_NAME, null, values);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_catalog.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_catalog, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Insert dummy data" menu option
            case R.id.action_insert_dummy_data:
                insertProducts();
                displayDatabaseInfo();
                return true;
            // Respond to a click on the "Delete all entries" menu option
            case R.id.action_delete_all_entries:
                // Do nothing for now
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
