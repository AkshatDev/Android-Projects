package com.example.android.inventory1.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.os.FileObserver.CREATE;

/**
 * Created by Lucifer on 06-11-2017.
 */

public class ProductsDbHelper extends SQLiteOpenHelper {

        public static final String LOG_TAG = ProductsDbHelper.class.getSimpleName();

        /** Name of the database file */
        private static final String DATABASE_NAME = "PRODUCTS.db";

        /**
         * Database version. If you change the database schema, you must increment the database version.
         */
        private static final int DATABASE_VERSION = 2;

        /**
         
         *
         * @param context of the app
         */
        public ProductsDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        /**
         * This is called when the database is created for the first time.
         */
        @Override
        public void onCreate(SQLiteDatabase db) {
            // Create a String that contains the SQL statement to create the products table
             String CREATE_TABLE_PRODUCT = "CREATE TABLE " +
                    ProductsContract.ProductsEntry.TABLE_NAME + "(" +
                    ProductsContract.ProductsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    ProductsContract.ProductsEntry.COLUMN_NAME + " TEXT NOT NULL," +
                    ProductsContract.ProductsEntry.COLUMN_PRICE + " NUMBER NOT NULL," +
                    ProductsContract.ProductsEntry.COLUMN_QUANTITY + " INTEGER NOT NULL DEFAULT 0," +
                    ProductsContract.ProductsEntry.COLUMN_SUPPLIER_NAME + " TEXT NOT NULL," +
                    ProductsContract.ProductsEntry.COLUMN_SUPPLIER_PHONE + " int NOT NULL," +
                    ProductsContract.ProductsEntry.COLUMN_SUPPLIER_EMAIL + " TEXT NOT NULL);";
            // Execute the SQL statement
            db.execSQL(CREATE_TABLE_PRODUCT);
        }

        /**
         * This is called when the database needs to be upgraded.
         */
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // The database is still at version 2, so there's nothing to do be done here.
        }
    }

