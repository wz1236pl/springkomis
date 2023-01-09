package springkomis.komis.klasy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="imgurl") 
public class ImgUrl {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    private Samochod samochod;
    private String url;

    public ImgUrl() {
    }

    public ImgUrl(Integer id, Samochod samochod, String url) {
        this.id = id;
        this.samochod = samochod;
        this.url = url;
    }
    public ImgUrl(Samochod samochod, String url) {
        this.samochod = samochod;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Samochod getSamochod() {
        return samochod;
    }
    public void setSamochod(Samochod samochod) {
        this.samochod = samochod;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ImgUrl [id=" + id + ", samochod=" + samochod + ", url=" + url + "]";
    }
    

    


}
