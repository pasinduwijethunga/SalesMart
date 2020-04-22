package com.example.salesmart.DataBase;

import android.provider.BaseColumns;

public final class Product {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private Product() {}

    /* Inner class that defines the table contents */
    public static class items implements BaseColumns {
        public static final String TABLE_NAME = "productInfo";
        public static final String COLUMN_1= "name";
        public static final String COLUMN_2 = "description";
        public static final String COLUMN_3 = "status";
        public static final String COLUMN_4 = "price";
    }
}