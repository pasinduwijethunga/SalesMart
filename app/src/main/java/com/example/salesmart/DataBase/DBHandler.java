package com.example.salesmart.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

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

    // insert

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

    public List readAllInfo(){
        String name = "Asvinash";
        SQLiteDatabase db = getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                Product.items.COLUMN_1,
                Product.items.COLUMN_2,
                Product.items.COLUMN_3,
                Product.items.COLUMN_4
        };

// Filter results WHERE "title" = 'My Title'
        String selection = Product.items.COLUMN_1 + " = ?";
        String[] selectionArgs = { name};

// How you want the results sorted in the resulting Cursor
        String sortOrder = Product.items.COLUMN_1 + " ASC";

        Cursor cursor = db.query(
                Product.items.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                 null,              // The columns for the WHERE clause
                 null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        List pname = new ArrayList<>();
        while(cursor.moveToNext()) {
            String  iname = cursor.getString(cursor.getColumnIndexOrThrow(Product.items.COLUMN_1));
           pname.add(iname );
        }
     cursor.close();
        return pname;
    }



    public ArrayList readAllInfo(String name){

        SQLiteDatabase db = getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.
        String[] projection = {
                BaseColumns._ID,
                Product.items.COLUMN_1,
                Product.items.COLUMN_2,
                Product.items.COLUMN_3,
                Product.items.COLUMN_4
        };

// Filter results WHERE "title" = 'My Title'
        String selection = Product.items.COLUMN_1 + " LIKE ?";
        String[] selectionArgs = { name};

// How you want the results sorted in the resulting Cursor
        String sortOrder = Product.items.COLUMN_1 + " ASC";

        Cursor cursor = db.query(
                Product.items.TABLE_NAME,   // The table to query
                projection,             // The array of columns to return (pass null to get all)
                selection,              // The columns for the WHERE clause
                selectionArgs ,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        ArrayList productInfo = new ArrayList<>();
        while(cursor.moveToNext()) {
            String  iname = cursor.getString(cursor.getColumnIndexOrThrow(Product.items.COLUMN_1));
            String  idescrip = cursor.getString(cursor.getColumnIndexOrThrow(Product.items.COLUMN_2));
            String  istatus = cursor.getString(cursor.getColumnIndexOrThrow(Product.items.COLUMN_3));
            String  iprice = cursor.getString(cursor.getColumnIndexOrThrow(Product.items.COLUMN_4));

            productInfo.add(iname );//0
            productInfo.add(idescrip );//1
            productInfo.add(istatus );//2
            productInfo.add(iprice );//3
        }
        cursor.close();
        return productInfo;
    }

}