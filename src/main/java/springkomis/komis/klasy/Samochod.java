package springkomis.komis.klasy;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Samochod {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String vin;
    private String nrRej;
    private String marka;
    private String model;
    private String typ;
    private String paliwo;
    private String kolor;
    private int rok;
    private int przebieg;
    private Double moc;
    private Double pojemnosc;
    private Double cena;
    private Date dataDodania;

    public Samochod() {}

    public Samochod(Integer id, String vin, String nrRej, String marka, String model, String typ, String paliwo,
            String kolor, int rok, int przebieg, Double moc, Double pojemnosc, Double cena) {
        this.id = id;
        this.vin = vin;
        this.nrRej = nrRej;
        this.marka = marka;
        this.model = model;
        this.typ = typ;
        this.paliwo = paliwo;
        this.kolor = kolor;
        this.rok = rok;
        this.przebieg = przebieg;
        this.moc = moc;
        this.pojemnosc = pojemnosc;
        this.cena = cena;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getNrRej() {
        return nrRej;
    }

    public void setNrRej(String nrRej) {
        this.nrRej = nrRej;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getPaliwo() {
        return paliwo;
    }

    public void setPaliwo(String paliwo) {
        this.paliwo = paliwo;
    }

    public String getKolor() {
        return kolor;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    public int getRok() {
        return rok;
    }

    public void setRok(int rok) {
        this.rok = rok;
    }

    public int getPrzebieg() {
        return przebieg;
    }

    public void setPrzebieg(int przebieg) {
        this.przebieg = przebieg;
    }

    public Double getMoc() {
        return moc;
    }

    public void setMoc(Double moc) {
        this.moc = moc;
    }

    public Double getPojemnosc() {
        return pojemnosc;
    }

    public void setPojemnosc(Double pojemnosc) {
        this.pojemnosc = pojemnosc;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public Date getDataDodania() {
        return dataDodania;
    }

    public void setDataDodania(Date dataDodania) {
        this.dataDodania = dataDodania;
    }

    @Override
    public String toString() {
        return "Samochod [id=" + id + ", vin=" + vin + ", nrRej=" + nrRej + ", marka=" + marka + ", model=" + model
                + ", typ=" + typ + ", paliwo=" + paliwo + ", kolor=" + kolor + ", rok=" + rok + ", przebieg=" + przebieg
                + ", moc=" + moc + ", pojemnosc=" + pojemnosc + ", cena=" + cena + ", dataDodania=" + dataDodania + "]";
    }

}
