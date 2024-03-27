package com.babbobastardo.control;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.babbobastardo.model.Gifted;
import com.babbobastardo.model.Gifter;
import com.babbobastardo.repository.GiftersRepository;
import com.babbobastardo.repository.LocalDatabase;

import java.util.ArrayList;
import java.util.LinkedList;

public abstract class ParentController {
    protected LinkedList<Gifter> gifters;
    protected LocalDatabase localDatabase;
    protected GiftersRepository giftersRepository;

    protected ParentController(Context context) {
        localDatabase = new LocalDatabase(context);
        giftersRepository = new GiftersRepository(localDatabase);
        gifters = (LinkedList<Gifter>) giftersRepository.getGifters();
    }

    public LinkedList<Gifter> getGifters() {
        return gifters;
    }

    /*public static void sendEmail() {
        Log.i("Send email", "");

        String[] TO = {"someone@gmail.com"};
        String[] CC = {"xyz@gmail.com"};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

        try {
            startActivity(Intent.createChooser(emailIntent, "Mandando il piccione..."));
            finish();
            Log.i("Piccione ricevuto", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this,
                    "Non ci sono piccionaie (non è installato il client email).", Toast.LENGTH_SHORT).show();
        }
    }*/
}
