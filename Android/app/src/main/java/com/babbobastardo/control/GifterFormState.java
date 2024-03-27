package com.babbobastardo.control;

public class GifterFormState {
    private String nameError;
    private String emailError;
    private boolean isDataValid;

    public GifterFormState(String nameError, String emailError) {
        this.nameError = nameError;
        this.emailError = emailError;
        this.isDataValid = false;
    }

    public GifterFormState(boolean isDataValid) {
        this.nameError = null;
        this.emailError = null;
        this.isDataValid = isDataValid;
    }

    public String getNameError() {
        return nameError;
    }

    public String getEmailError() {
        return emailError;
    }

    public boolean isDataValid() {
        return isDataValid;
    }
}
