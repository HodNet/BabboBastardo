package com.babbobastardo.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.babbobastardo.model.Gifter;

public class GiftersDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GiftersDatabase";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Gifter";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";

    public GiftersDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_NAME + " TEXT,"
                + COLUMN_EMAIL + " TEXT" + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addGifter(Gifter gifter) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, gifter.getName());
        values.put(COLUMN_EMAIL, gifter.getEmail());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    // Other methods to update, delete and retrieve data...
}
