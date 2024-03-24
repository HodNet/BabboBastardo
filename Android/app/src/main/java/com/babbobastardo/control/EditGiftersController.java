package com.babbobastardo.control;

import android.content.Context;

import com.babbobastardo.model.Gifted;
import com.babbobastardo.model.Gifter;
import com.babbobastardo.repository.LocalDatabase;

import java.util.ArrayList;

public class EditGiftersController extends ParentController {
    private static EditGiftersController instance = null;
    private LocalDatabase localDatabase;

    public static EditGiftersController getInstance(Context context) {
        if (instance == null) {
            instance = new EditGiftersController(context);
        }
        return instance;
    }

    private EditGiftersController(Context context) {
        localDatabase = new LocalDatabase(context);
    }

    public void addGifter(Gifter gifter) {
        gifters.add(gifter);
        localDatabase.addGifter(gifter);
    }

    public void decidiChiRegalare() {
        ArrayList<Gifted> gifteds = new ArrayList<>(gifters.size());
        for (Gifter gifter : gifters) {
            gifteds.add(new Gifted(gifter));
        }

        for (Gifter gifter : gifters) {
            if (gifter.getGifted() == null) {
                int index = (int) (Math.random() * gifteds.size());
                gifter.setGifted(gifteds.get(index));
                gifteds.remove(index);
            }
        }
    }
}
