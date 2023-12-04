package com.raflisalam.appteman.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseUser extends SQLiteOpenHelper {

    private static String namaDatabase="db_user";

    public DatabaseUser (Context context) {
        super(context, namaDatabase, null,1);
    }

    public void tabel_user(SQLiteDatabase db) {
                db.execSQL("Create Table If Not Exists tbl_user "
                + "(id Integer Primary Key AutoIncrement, nUsername Text, nEmail Text, nPassowrd Text)");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {

    }
}
