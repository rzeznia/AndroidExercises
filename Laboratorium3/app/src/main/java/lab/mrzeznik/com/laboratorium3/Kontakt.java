package lab.mrzeznik.com.laboratorium3;

import com.orm.SugarRecord;

public class Kontakt extends SugarRecord{
    public String nazwa;
    public String numer;

    public Kontakt(){}

    public Kontakt(String nazwa, String numer)
    {
        this.nazwa = nazwa; this.numer = numer;
    }
    public String getFullKontakt()
    {
        return "\n" + nazwa + " " + numer;
    }
}
