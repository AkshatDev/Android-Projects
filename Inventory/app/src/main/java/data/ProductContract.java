package data;

import android.provider.BaseColumns;

/**
 * Created by Lucifer on 06-11-2017.
 */

public class ProductContract {

    public ProductContract() {
    }

    public static final class ProductEntry implements BaseColumns {

        public static final String TABLE_NAME = "product";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_QUANTITY = "quantity";
        public static final String COLUMN_SUPPLIER_NAME = "supplier_name";
        public static final String COLUMN_SUPPLIER_PHONE = "supplier_phone";
        public static final String COLUMN_SUPPLIER_EMAIL = "supplier_email";
        public static final String COLUMN_IMAGE = "image";

        public static final String CREATE_TABLE_STOCK = "CREATE TABLE " +
                ProductEntry.TABLE_NAME + "(" +
                ProductEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ProductEntry.COLUMN_NAME + " TEXT NOT NULL," +
                ProductEntry.COLUMN_PRICE + " TEXT NOT NULL," +
                ProductEntry.COLUMN_QUANTITY + " INTEGER NOT NULL DEFAULT 0," +
                ProductEntry.COLUMN_SUPPLIER_NAME + " TEXT NOT NULL," +
                ProductEntry.COLUMN_SUPPLIER_PHONE + " TEXT NOT NULL," +
                ProductEntry.COLUMN_SUPPLIER_EMAIL + " TEXT NOT NULL," +
                ProductEntry.COLUMN_IMAGE + " TEXT NOT NULL" + ");";
    }
}
