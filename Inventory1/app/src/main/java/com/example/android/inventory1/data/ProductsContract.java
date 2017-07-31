package com.example.android.inventory1.data;

import android.provider.BaseColumns;

/**
 * Created by Lucifer on 06-11-2017.
 */

public class ProductsContract {


        // To prevent someone from accidentally instantiating the contract class,
        // give it an empty constructor.
        public ProductsContract() {
        }

    public static final class ProductsEntry implements BaseColumns {

        public static final String TABLE_NAME = "product";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_QUANTITY = "quantity";
        public static final String COLUMN_SUPPLIER_NAME = "supplier_name";
        public static final String COLUMN_SUPPLIER_PHONE = "supplier_phone";
        public static final String COLUMN_SUPPLIER_EMAIL = "supplier_email";



    }
    }



