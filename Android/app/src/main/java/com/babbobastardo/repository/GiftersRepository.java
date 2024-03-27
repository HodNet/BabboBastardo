package com.babbobastardo.repository;

import static com.babbobastardo.repository.LocalDatabase.GIFTER_COLUMN_1;
import static com.babbobastardo.repository.LocalDatabase.GIFTER_COLUMN_2;
import static com.babbobastardo.repository.LocalDatabase.GIFTER_COLUMN_3;
import static com.babbobastardo.repository.LocalDatabase.GIFTER_TABLE_NAME;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.babbobastardo.model.Gifted;
import com.babbobastardo.model.Gifter;

import java.util.LinkedList;
import java.util.List;

public class GiftersRepository {
    private LocalDatabase localDatabase;

    public GiftersRepository(LocalDatabase localDatabase) {
        this.localDatabase = localDatabase;
    }

    public void addGifter(Gifter gifter) {
        if (gifter == null)
            return;

        SQLiteDatabase db = localDatabase.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(GIFTER_COLUMN_1, gifter.getName());
        values.put(GIFTER_COLUMN_2, gifter.getEmail());
        if(gifter.getGifted() == null)
            values.put(GIFTER_COLUMN_3, (String) null);
        else
            values.put(GIFTER_COLUMN_3, gifter.getGifted().getName());
        db.insert(GIFTER_TABLE_NAME, null, values);

        db.close();
    }

    public List<Gifter> getGifters() {
        SQLiteDatabase db = localDatabase.getReadableDatabase();

        String[] columns = {GIFTER_COLUMN_1, GIFTER_COLUMN_2, GIFTER_COLUMN_3};
        Cursor cursor = db.query(GIFTER_TABLE_NAME, columns, null, null, null, null, null);
        LinkedList<Gifter> gifters = new LinkedList<>();
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndexOrThrow(GIFTER_COLUMN_1));
            String email = cursor.getString(cursor.getColumnIndexOrThrow(GIFTER_COLUMN_2));
            String giftedName = cursor.getString(cursor.getColumnIndexOrThrow(GIFTER_COLUMN_3));
            gifters.add(new Gifter(name, email, new Gifted(giftedName)));
        }

        cursor.close();
        return gifters;
    }

    public void deleteGifter(Gifter gifter) {
        SQLiteDatabase db = localDatabase.getWritableDatabase();
        db.delete(GIFTER_TABLE_NAME, GIFTER_COLUMN_2 + " = ?", new String[]{gifter.getEmail()});
        db.close();
    }
}
