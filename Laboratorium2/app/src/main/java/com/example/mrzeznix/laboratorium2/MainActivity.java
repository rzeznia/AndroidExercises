package com.example.mrzeznix.laboratorium2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText Login; EditText Pass; TextView Valid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Login = findViewById(R.id.loginEdit);
        Pass = findViewById(R.id.passEdit);
        Valid = findViewById(R.id.testText);
    }
    public void login_btn_OnClick(View view)
    {
        String login = "kopytko";
        String pass = "1234";
        if(Login.getText().toString().equals(login) && Pass.getText().toString().equals(pass))
        {
            //Valid.setText("DANE POPRAWNE");
            Intent i = new Intent(getBaseContext(), Main2Activity.class);
            startActivity(i);
        }
        else
            showWrongCredentialsDialog();



    }
    public void showWrongCredentialsDialog() {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Błąd logowania");
        alertDialog.setMessage("Wprowadzono błedny login lub hasło");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL,"Ok",
                new DialogInterface.OnClickListener(){public void onClick (DialogInterface dialog, int which) {dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
