package mrzeznik.lab1.laboratorium1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    TextView wynik; EditText liczba1; EditText liczba2; int temp1; int temp2; Toast zeroDiv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wynik=findViewById(R.id.wynikTextView);
        liczba1=findViewById(R.id.liczba1EditText);
        liczba2=findViewById(R.id.liczba2EditText);
    }
    public boolean checkValues()
    {
        if(TextUtils.isEmpty(liczba1.getText()) == true && TextUtils.isEmpty(liczba2.getText()) == true) {
            Toast.makeText(getApplicationContext(), "Wprowadź wymagane dane wejściowe", Toast.LENGTH_SHORT).show();
            return false;
        }
        else
        {
            temp1 = Integer.parseInt(liczba1.getText().toString());
            temp2 = Integer.parseInt(liczba2.getText().toString());
            return true;
        }
    }
    public void dodawanieOnClick(View view)
    {
        if(checkValues() == true)
            wynik.setText(String.valueOf(temp1 + temp2));
    }
    public void odejmowanieOnClick(View view)
    {
        if(checkValues() == true)
            wynik.setText(String.valueOf(temp1 - temp2));
    }
    public void mnozenieOnClick(View view)
    {
        if(checkValues() == true)
            wynik.setText(String.valueOf(temp1 * temp2));
    }
    public void dzielenieOnClick(View view)
    {
        if(checkValues() == true)
        {
            if (temp2 == 0) {
                Toast.makeText(getApplicationContext(), "Nie można dzielić przez zero!", Toast.LENGTH_SHORT).show();
                wynik.setText("Error!");
            }
            else
                wynik.setText(String.valueOf(temp1 / temp2));

        }
    }
    public void clrBtnOnClick(View view)
    {
        liczba1.setText(null);
        liczba2.setText(null);
        wynik.setText("0");
    }
}
