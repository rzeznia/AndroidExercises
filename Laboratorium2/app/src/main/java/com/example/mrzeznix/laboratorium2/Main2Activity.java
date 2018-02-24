package com.example.mrzeznix.laboratorium2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.security.cert.CertPathValidatorException;

public class Main2Activity extends AppCompatActivity {

    DatePicker chosenDate; EditText reason;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        chosenDate = findViewById(R.id.datePicker);
        reason = findViewById(R.id.reasonText);

    }
    public void saveOnClick(View view)
    {
        if(TextUtils.isEmpty(reason.getText()) == true ) {
            Toast.makeText(getApplicationContext(), "Wprowadź uzasadnienie", Toast.LENGTH_SHORT).show();
        }
        else
        {
            String date = String.valueOf(chosenDate.getDayOfMonth()) +"/" + String.valueOf(chosenDate.getMonth()) + "/" + String.valueOf(chosenDate.getYear());
            prepareDialog(date, reason.getText().toString());
        }


    }
    public void prepareDialog(String date, String reason)
    {
        AlertDialog alertDialog = new AlertDialog.Builder(Main2Activity.this).create();
        alertDialog.setTitle("Nieobecność dnia: " + date);
        alertDialog.setMessage(reason);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,"Ok",
                new DialogInterface.OnClickListener(){public void onClick (DialogInterface dialog, int which) {dialog.dismiss();
                }
                });
        alertDialog.show();
    }
}

