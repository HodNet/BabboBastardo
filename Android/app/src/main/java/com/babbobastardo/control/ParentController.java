package com.babbobastardo.control;

import com.babbobastardo.model.Gifted;
import com.babbobastardo.model.Gifter;

import java.util.ArrayList;
import java.util.LinkedList;

public abstract class ParentController {
    protected LinkedList<Gifter> gifters = new LinkedList<>();

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
