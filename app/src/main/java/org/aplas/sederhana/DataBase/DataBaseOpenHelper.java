package org.aplas.sederhana.DataBase;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DataBaseOpenHelper extends SQLiteAssetHelper {

    public static final String DATABASE_NAME = "db_mycashbook.db"; //databases name
    public static final int DATABASE_VERSION = 3;

    public DataBaseOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
