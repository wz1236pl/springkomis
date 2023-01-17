package springkomis.komis.klasy;

public class Wyszukiwanie {
    private int przebiegOd;
    private int przebiegDo;
    private int rokOd;
    private int rokDo;
    private int mocOd;
    private int mocDo;
    private String paliwo;
    private String typ;

    public Wyszukiwanie() {
    }
    public Wyszukiwanie(int przebiegOd, int przebiegDo, int rokOd, int rokDo, int mocOd, int mocDo, String paliwo,
            String typ) {
        this.przebiegOd = przebiegOd;
        this.przebiegDo = przebiegDo;
        this.rokOd = rokOd;
        this.rokDo = rokDo;
        this.mocOd = mocOd;
        this.mocDo = mocDo;
        this.paliwo = paliwo;
        this.typ = typ;
    }
    public int getPrzebiegOd() {
        return przebiegOd;
    }
    public void setPrzebiegOd(int przebiegOd) {
        this.przebiegOd = przebiegOd;
    }
    public int getPrzebiegDo() {
        return przebiegDo;
    }
    public void setPrzebiegDo(int przebiegDo) {
        this.przebiegDo = przebiegDo;
    }
    public int getRokOd() {
        return rokOd;
    }
    public void setRokOd(int rokOd) {
        this.rokOd = rokOd;
    }
    public int getRokDo() {
        return rokDo;
    }
    public void setRokDo(int rokDo) {
        this.rokDo = rokDo;
    }
    public int getMocOd() {
        return mocOd;
    }
    public void setMocOd(int mocOd) {
        this.mocOd = mocOd;
    }
    public int getMocDo() {
        return mocDo;
    }
    public void setMocDo(int mocDo) {
        this.mocDo = mocDo;
    }
    public String getPaliwo() {
        return paliwo;
    }
    public void setPaliwo(String paliwo) {
        this.paliwo = paliwo;
    }
    public String getTyp() {
        return typ;
    }
    public void setTyp(String typ) {
        this.typ = typ;
    }
    @Override
    public String toString() {
        return "Wyszukiwanie [przebiegOd=" + przebiegOd + ", przebiegDo=" + przebiegDo + ", rokOd=" + rokOd + ", rokDo="
                + rokDo + ", mocOd=" + mocOd + ", mocDo=" + mocDo + ", paliwo=" + paliwo + ", typ=" + typ + "]";
    }

    
}
