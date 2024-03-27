package com.babbobastardo.control;

import android.content.Context;
import android.content.Intent;

import androidx.lifecycle.MutableLiveData;

import com.babbobastardo.model.Gifted;
import com.babbobastardo.model.Gifter;
import com.babbobastardo.repository.LocalDatabase;
import com.babbobastardo.tools.PopupGeneratorOf;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditGiftersController extends ParentController {
    private static EditGiftersController instance = null;
    private MutableLiveData<GifterFormState> gifterFormState = new MutableLiveData<>();

    public static EditGiftersController getInstance(Context context) {
        if (instance == null) {
            instance = new EditGiftersController(context);
        }
        return instance;
    }


    public MutableLiveData<GifterFormState> getGifterFormState() {
        return gifterFormState;
    }

    public void gifterInputChanged(String name, String email) {
        if (!isUsernameFormatValid(name)) {
            gifterFormState.setValue(new GifterFormState("Invalid name format", null));
        } else if (!isEmailFormatValid(email)) {
            gifterFormState.setValue(new GifterFormState(null, "Invalid email format"));
        } else {
            gifterFormState.setValue(new GifterFormState(true));
        }
    }

    private static boolean isUsernameFormatValid(String username) {
        if (username == null)
            return false;

        final String regular_expression = "^[A-Za-z][\\w!#$%&'*+/=?`{|}~^-]{0,29}$";
        Pattern pattern = Pattern.compile(regular_expression);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    private static boolean isEmailFormatValid(String email) {
        if (email == null || email.length()>320) {
            return false;
        }

        final String regular_expression = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regular_expression);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private EditGiftersController(Context context) {
        super(context);
    }

    public void addGifter(String name, String email) {
        Gifter gifter = new Gifter(name, email);
        gifters.add(gifter);
        giftersRepository.addGifter(gifter);
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

    public void sendEmails(Context context) {
        for (Gifter gifter : gifters) {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("message/rfc822");
            i.putExtra(Intent.EXTRA_EMAIL  , new String[]{gifter.getEmail()});
            i.putExtra(Intent.EXTRA_SUBJECT, "BABBO NATALE SEGRETO");
            i.putExtra(Intent.EXTRA_TEXT   , "Tu sarai il babbo natale segreto di " + gifter.getGifted().getName() + "!");
            try {
                context.startActivity(Intent.createChooser(i, "Send mail..."));
            } catch (android.content.ActivityNotFoundException ex) {
                PopupGeneratorOf.errorPopup(context, "There are no email clients installed.");
            }
        }
    }

    public void deleteGifter(Gifter gifter) {
        gifters.remove(gifter);
        giftersRepository.deleteGifter(gifter);
    }

}
