package com.babbobastardo.control;

import com.babbobastardo.model.Gifted;
import com.babbobastardo.model.Gifter;

import java.util.ArrayList;

public class Controller {
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

    public static void decidiChiRegalare(ArrayList<Gifter> gifters, ArrayList<Gifted> gifteds) {
        for (Gifter gifter : gifters) {
            if (gifter.getGifted() == null) {
                int index = (int) (Math.random() * gifteds.size());
                gifter.setGifted(gifteds.get(index));
                gifteds.remove(index);
            }
        }
    }
}
