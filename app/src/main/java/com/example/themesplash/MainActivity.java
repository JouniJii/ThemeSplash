package com.example.themesplash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button enable_button;
    private boolean editText_enabled = true;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        if (savedInstanceState == null ) {
            // Pause for 3,5 seconds.
            sleep(3500);
        }
        // Theme must be set before super.onCreate().
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);

        enable_button = findViewById(R.id.button);
        enable_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText_enabled = editText_enabled ? false : true;
                editText.setEnabled(editText_enabled);
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(String.valueOf(R.id.editText), editText_enabled);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        editText_enabled = savedInstanceState.getBoolean(String.valueOf(R.id.editText));
        editText.setEnabled(editText_enabled);
    }

    public void sleep (int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
