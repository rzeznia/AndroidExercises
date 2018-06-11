package lab.mrzeznik.com.laboratorium3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.orm.SchemaGenerator;
import com.orm.SugarContext;
import com.orm.SugarDb;

import java.util.List;


import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
    TextView db_ctr; Button add_r; Button del_r; EditText name; EditText number; Kontakt kontakt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SugarContext.init( this );
        SchemaGenerator schemaGenerator = new SchemaGenerator( this );
        schemaGenerator.createDatabase(new SugarDb( this ).getDB());

        db_ctr = findViewById(R.id.db_contains);
        add_r = findViewById(R.id.add_record);
        del_r = findViewById(R.id.del_record);
        name = findViewById(R.id.edit_nazwa);
        number = findViewById(R.id.edit_number);

        refreshRecordTextview();
    }
    public void tryToAddRecord(View view)
    {
        if(TextUtils.isEmpty(name.getText()) == true || TextUtils.isEmpty(number.getText()) == true)
        {
            Toast toast = Toast.makeText(getApplicationContext(), "Wprowadź poprawne dane wejściowe!", LENGTH_SHORT);
            toast.show();
        }
        else
        {
            Kontakt temp_kontakt = new Kontakt(name.getText().toString(), number.getText().toString());
            temp_kontakt.save();
            refreshRecordTextview();
        }
    }
    public void tryToDelete(View view)
    {
        List<Kontakt> kontakty = Kontakt.listAll(Kontakt.class);
        int size = kontakty.size();
        if(size == 0)
        {
            Toast del = Toast.makeText(getApplicationContext(), "Tabela pusta - nic do usunięcia", LENGTH_SHORT);
            del.show();
        }else
        {
            kontakty.get(size-1).delete();
            refreshRecordTextview();
        }
    }
    public void refreshRecordTextview()
    {
        List<Kontakt> kontakty = Kontakt.listAll(Kontakt.class);
        if(kontakty.size() == 0)
        {
            db_ctr.setText("Tabela pusta - brak danych");
        }
        else
        {
            String content = "";
            for(Kontakt kontakt:kontakty)
            {
                content = content + kontakt.getFullKontakt();
            }
            db_ctr.setText(content);
        }
    }
}
