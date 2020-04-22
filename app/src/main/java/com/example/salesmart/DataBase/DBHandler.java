package com.example.salesmart.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Product.db";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Product.items.TABLE_NAME + " (" +
                    Product.items._ID + " INTEGER PRIMARY KEY," +
                    Product.items.COLUMN_1+ " TEXT," +
                    Product.items.COLUMN_2+ " TEXT," +
                    Product.items.COLUMN_3+ " TEXT," +
                    Product.items.COLUMN_4 + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Product.items.TABLE_NAME;

    public long addInfo(String name,String description,String status,String price){
        // Gets the data repository in write mode
        SQLiteDatabase db = getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(Product.items.COLUMN_1, name);
        values.put(Product.items.COLUMN_2, description);
        values.put(Product.items.COLUMN_3, status);
        values.put(Product.items.COLUMN_4, price);


// Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(Product.items.TABLE_NAME, null, values);

        return newRowId;
    }

    public boolean updateInfo(String name,String description,String status,String price){
        SQLiteDatabase db = getWritableDatabase();

// New value for one column

        ContentValues values = new ContentValues();
        values.put(Product.items.COLUMN_2, description);
        values.put(Product.items.COLUMN_3, status);
        values.put(Product.items.COLUMN_4, price);

// Which row to update, based on the title
        String selection = Product.items.COLUMN_1 + " LIKE ?";
        String[] selectionArgs = { name };

        int count = db.update(
                Product.items.TABLE_NAME,
                values,
                selection,
                selectionArgs);

        if (count >=1){
            return true;
        }
        else {
            return false;
        }
    }

    public void deleteInfo(String name){
        SQLiteDatabase db = getWritableDatabase();
        // Define 'where' part of query.
        String selection = Product.items.COLUMN_1 + " LIKE ?";
       // Specify arguments in placeholder order.
        String[] selectionArgs = { name };
        // Issue SQL statement.
        int deletedRows = db.delete(Product.items.TABLE_NAME, selection, selectionArgs);

    }
}