package com.babbobastardo.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.babbobastardo.model.Gifter;

/**
 * A class that manages the local storage.
 *
 * <pre>
 * Un veloce formulario su SQLite:
 * Tipi:
 *      - TEXT (sostituto di VARCHAR, esso si comporta come il tipo String)
 *      - INTEGER
 * </pre>
 **/
public class LocalDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "BabboBastardoDB";
    // If you change the database schema, you must increment the database version.
    private static final int DATABASE_VERSION = 1;

    // GIFTER
    private static final String GIFTER_TABLE_NAME = "Gifter";
    private static final String GIFTER_COLUMN_1 = "name";
    private static final String GIFTER_COLUMN_2 = "email";
    private static final String GIFTER_COLUMN_3 = "giftedName";

    // GIFTED
    private static final String GIFTED_TABLE_NAME = "Gifted";
    private static final String GIFTED_COLUMN_1 = "name";

    public LocalDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + GIFTED_TABLE_NAME + "("
                + GIFTED_COLUMN_1 + " TEXT PRIMARY KEY"
                + ");";
        db.execSQL(CREATE_TABLE);

        CREATE_TABLE = "CREATE TABLE " + GIFTER_TABLE_NAME + "("
                + GIFTER_COLUMN_1 + " TEXT NOT NULL UNIQUE,"
                + GIFTER_COLUMN_2 + " TEXT PRIMARY KEY,"
                + GIFTER_COLUMN_3 + " TEXT,"
                + "FOREIGN KEY (" + GIFTER_COLUMN_3 + ") REFERENCES " + GIFTED_TABLE_NAME + "(" + GIFTED_COLUMN_1 + ")"
                + ");";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + GIFTED_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + GIFTER_TABLE_NAME);
        onCreate(db);
    }

    public void addGifter(Gifter gifter) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(GIFTER_COLUMN_1, gifter.getName());
        values.put(GIFTER_COLUMN_2, gifter.getEmail());
        db.insert(GIFTER_TABLE_NAME, null, values);
        db.close();
    }

    // Other methods to update, delete and retrieve data...
}
