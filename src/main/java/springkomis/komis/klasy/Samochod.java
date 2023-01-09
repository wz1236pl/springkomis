package springkomis.komis.klasy;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.ArrayList;
import java.util.List;;

@Entity
@Table(name="samochod") 
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
    private int moc;
    private int pojemnosc;
    private int cena;
    @Column(nullable = true)
    private Date dataUbezpieczenia;
    @Column(nullable = true)
    private Date dataPrzeglad;
    private Date dataDodania;
    private int sprzedany;
    @OneToMany(mappedBy = "samochod")
    private List<ImgUrl> images = new ArrayList<ImgUrl>();

    public Samochod() {
        this.rok = 0;
        this.przebieg = 0;
        this.moc = 0;
        this.pojemnosc = 0;
        this.cena = 0;
        this.dataUbezpieczenia = null;
        this.dataPrzeglad = null;
        this.sprzedany=0;
    }

    public Samochod(Integer id, String vin, String nrRej, String marka, String model, String typ, String paliwo,
            String kolor, int rok, int przebieg, int moc, int pojemnosc, int cena, Date dataUbezpieczenia, Date dataPrzeglad) {
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
        this.dataUbezpieczenia = dataUbezpieczenia;
        this.dataPrzeglad = dataPrzeglad;
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

    public int getMoc() {
        return moc;
    }

    public void setMoc(int moc) {
        this.moc = moc;
    }

    public int getPojemnosc() {
        return pojemnosc;
    }

    public void setPojemnosc(int pojemnosc) {
        this.pojemnosc = pojemnosc;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public Date getDataDodania() {
        return dataDodania;
    }

    public void setDataDodania(Date dataDodania) {
        this.dataDodania = dataDodania;
    }

    public Date getDataUbezpieczenia() {
        return dataUbezpieczenia;
    }

    public void setDataUbezpieczenia(Date dataUbezpieczenia) {
            this.dataUbezpieczenia = dataUbezpieczenia;
    }

    public Date getDataPrzeglad() {
        return dataPrzeglad;
    }

    public void setDataPrzeglad(Date dataPrzeglad) {
        this.dataPrzeglad = dataPrzeglad;
    }

    public int getSprzedany() {
        return sprzedany;
    }

    public void setSprzedany(int sprzedany) {
        this.sprzedany = sprzedany;
    }

    @Override
    public String toString() {
        return "Samochod [id=" + id + ", vin=" + vin + ", nrRej=" + nrRej + ", marka=" + marka + ", model=" + model
                + ", typ=" + typ + ", paliwo=" + paliwo + ", kolor=" + kolor + ", rok=" + rok + ", przebieg=" + przebieg
                + ", moc=" + moc + ", pojemnosc=" + pojemnosc + ", cena=" + cena + ", dataUbezpieczenia="
                + dataUbezpieczenia + ", dataPrzeglad=" + dataPrzeglad + ", dataDodania=" + dataDodania + ", sprzedany="
                + sprzedany + "]";
    }

    
   
}
