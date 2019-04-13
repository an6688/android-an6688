package com.example.winetracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ConfirmationPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_page);

        TextView confirmationMessage = findViewById(R.id.txtConfirmationMessage);
        wineKeeper confirmDetails = (wineKeeper) getIntent().getSerializableExtra("keeperForm");
        String message = "Hello" + confirmDetails.getWineName() + "Has been entered in your diary";
        confirmationMessage.setText(message);
    }
}
