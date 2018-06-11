package mrzeznik.lab.laboratorium4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {

    TextView imie; TextView nazwisko; TextView note; RatingBar rate;
    String url = "http://10.253.8.176:8080/opinion/save";
    public Rate new_rate = new Rate();
    public Author new_author = new Author();
    public Opinion new_opinion = new Opinion();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imie=findViewById(R.id.nameEdit);
        nazwisko = findViewById(R.id.surnameEdit);
        note = findViewById(R.id.noteEdit);
        rate = findViewById(R.id.ratingBar);


    }
    public void WyśłijOnClick(View v)
    {
        if(checkValues() == true)
            populateObjects();
    }
    public boolean checkValues()
    {
        if(TextUtils.isEmpty(imie.getText()) == true && TextUtils.isEmpty(nazwisko.getText()) == true && TextUtils.isEmpty(note.getText()) == true) {
            Toast.makeText(getApplicationContext(), "Wprowadź wymagane dane wejściowe", Toast.LENGTH_SHORT).show();
            return false;
        }
        else
            return true;
    }
    public void populateObjects() {
        new_author.firstName = imie.getText().toString();
        new_author.lastName = nazwisko.getText().toString();
        new_rate.note = note.getText().toString();
        new_rate.ratePoints = rate.getRating();
        new_opinion.author = new_author;
        new_opinion.rate = new_rate;
        final String opinionJson = new Gson().toJson(new_opinion);
        RequestQueue queue = Volley.newRequestQueue(this);



        StringRequest postRequest = new StringRequest(Request.Method.POST,
                url, new Response.Listener<String>() {
            @Override
            public void onResponse (String response) {
                Toast.makeText(getApplicationContext(), "Odpowiedź serwera", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse (VolleyError error) {
                Toast.makeText(getApplicationContext(), "Błąd komunikacji", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            public String getBodyContentType () {
                return "application/json; charset=utf-8" ;
            }
            @Override
            public byte [] getBody() throws AuthFailureError {
                try {
                    return opinionJson == null ? null :
                            opinionJson.getBytes( "utf-8" );
                } catch (UnsupportedEncodingException uee) {
                    return null ;
                }
            }
        };
        queue.add(postRequest);
        queue.start();
    }
}
