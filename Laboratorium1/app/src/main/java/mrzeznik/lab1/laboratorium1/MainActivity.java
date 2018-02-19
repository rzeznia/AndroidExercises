package mrzeznik.lab1.laboratorium1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView wynik; EditText liczba1; EditText liczba2; int temp1; int temp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wynik=findViewById(R.id.wynikTextView);
        liczba1=findViewById(R.id.liczba1EditText);
        liczba2=findViewById(R.id.liczba2EditText);
    }
    public void dodawanieOnClick(View view)
    {
        temp1 = Integer.parseInt(liczba1.getText().toString());
        temp2 = Integer.parseInt(liczba2.getText().toString());
        wynik.setText(String.valueOf(temp1+temp2));
    }
    public void odejmowanieOnClick(View view)
    {
        temp1 = Integer.parseInt(liczba1.getText().toString());
        temp2 = Integer.parseInt(liczba2.getText().toString());
        wynik.setText(String.valueOf(temp1-temp2));
    }
    public void mnozenieOnClick(View view)
    {
        temp1 = Integer.parseInt(liczba1.getText().toString());
        temp2 = Integer.parseInt(liczba2.getText().toString());
        wynik.setText(String.valueOf(temp1*temp2));
    }
    public void dzielenieOnClick(View view)
    {
        temp1 = Integer.parseInt(liczba1.getText().toString());
        temp2 = Integer.parseInt(liczba2.getText().toString());
        wynik.setText(String.valueOf(temp1/temp2));
    }
}
