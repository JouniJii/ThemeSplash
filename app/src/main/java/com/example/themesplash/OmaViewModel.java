package com.example.themesplash;

import androidx.lifecycle.ViewModel;

public class OmaViewModel extends ViewModel {

    private String text;
    private boolean editTextState;

    public void setText(String s) {
        this.text = s;
    }

    public String getText() {
        return this.text;
    }
}
