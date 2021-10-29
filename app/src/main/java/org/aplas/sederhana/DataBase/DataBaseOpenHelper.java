package org.aplas.sederhana.DataBase;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DataBaseOpenHelper extends SQLiteAssetHelper {

    public static final String DATABASE_NAME = "mycashbook.db"; //database name
    public static final int DATABASE_VERSION = 3;

    public DataBaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
