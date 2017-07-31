package com.example.android.inventory1;

import android.content.ContentValues;
import android.content.Loader;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.android.inventory1.data.ProductsContract;
import com.example.android.inventory1.data.ProductsDbHelper;

/**
 * Created by Lucifer on 06-11-2017.
 */

public class EditorActivity extends AppCompatActivity {


    private EditText mNameEditText;


    private EditText mPricedEditText;


    private EditText mQuantityEditText;


    private EditText mSuppname;

    private EditText mSuppphone;

    private EditText mSuppemail;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        // Find all relevant views that we will need to read user input from
        mNameEditText = (EditText) findViewById(R.id.edit_product_name);
        mPricedEditText=(EditText) findViewById(R.id.edit_product_price);
        mQuantityEditText=(EditText) findViewById(R.id.product_quantity);
        mSuppname=(EditText) findViewById(R.id.edit_spu_name);
        mSuppemail=(EditText) findViewById(R.id.edit_spu_email);
       mSuppphone=(EditText) findViewById(R.id.edit_spu_phone);



    }

    private void insertProducts() {
        // Read from input fields
        // Use trim to eliminate leading or trailing white space
        String nameString = mNameEditText.getText().toString().trim();
        String priceString = mPricedEditText.getText().toString().trim();
        String quantityString = mQuantityEditText.getText().toString().trim();
        String sellernameString = mSuppname.getText().toString().trim();
        int sellernoString = Integer.parseInt(mSuppphone.getText().toString());
        String selleremailString = mSuppemail.getText().toString().trim();


        // Create database helper
        ProductsDbHelper mDbHelper = new ProductsDbHelper(this);

        // Gets the database in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a ContentValues object where column names are the keys,
        // and product attributes from the editor are the values.
        ContentValues values = new ContentValues();


        values.put(ProductsContract.ProductsEntry.COLUMN_NAME, nameString);
        values.put(ProductsContract.ProductsEntry.COLUMN_PRICE, priceString);
        values.put(ProductsContract.ProductsEntry.COLUMN_QUANTITY, quantityString);
        values.put(ProductsContract.ProductsEntry.COLUMN_SUPPLIER_NAME, sellernameString);
        values.put(ProductsContract.ProductsEntry.COLUMN_SUPPLIER_PHONE,sellernoString);
        values.put(ProductsContract.ProductsEntry.COLUMN_SUPPLIER_EMAIL, selleremailString);


        // Insert a new row for product in the database, returning the ID of that new row.
        long newRowId = db.insert(ProductsContract.ProductsEntry.TABLE_NAME, null, values);

        // Show a toast message depending on whether or not the insertion was successful
        if (newRowId == -1) {
            // If the row ID is -1, then there was an error with insertion.
            Toast.makeText(this, "Error with saving product", Toast.LENGTH_SHORT).show();
        } else {
            // Otherwise, the insertion was successful and we can display a toast with the row ID.
            Toast.makeText(this, "Product saved with row id: " + newRowId, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_editor.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Save" menu option
            case R.id.action_save:
                // Save pet to database
                insertProducts();
                // Exit activity
                finish();
                return true;
            // Respond to a click on the "Delete" menu option
            case R.id.action_delete:
                // Do nothing for now
                return true;
            // Respond to a click on the "Up" arrow button in the app bar
            case android.R.id.home:
                // Navigate back to parent activity (CatalogActivity)
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}