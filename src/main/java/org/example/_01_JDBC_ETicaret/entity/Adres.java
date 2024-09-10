package org.example._01_JDBC_ETicaret.entity;

public class Adres extends BaseEntity{

    private int id;
    private Integer muster_id;
    private String il;
    private String ilce;
    private String mahalle;
    private String adres;

    public Adres() {

    }

    public Adres(Integer muster_id, String il, String ilce, String mahalle, String adres) {
        this.muster_id = muster_id;
        this.il = il;
        this.ilce = ilce;
        this.mahalle = mahalle;
        this.adres = adres;
    }

    public Adres(int id, Integer muster_id, String il, String ilce, String mahalle, String adres) {
        this.id = id;
        this.muster_id = muster_id;
        this.il = il;
        this.ilce = ilce;
        this.mahalle = mahalle;
        this.adres = adres;
    }

    public Adres(int id, Integer muster_id, String il, String ilce, String mahalle, String adres,Integer state, Long createat, Long updateat) {
        super(state, createat, updateat);
        this.id = id;
        this.muster_id = muster_id;
        this.il = il;
        this.ilce = ilce;
        this.mahalle = mahalle;
        this.adres = adres;
    }

    @Override
    public String toString() {
        return "Adres{" +
                "id=" + id +
                ", muster_id=" + muster_id +
                ", il='" + il + '\'' +
                ", ilce='" + ilce + '\'' +
                ", mahalle='" + mahalle + '\'' +
                ", adres='" + adres + '\'' +
                ", state=" + getState() +
                ", createat=" + getCreateat() +
                ", updateat=" + getUpdateat() +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getMuster_id() {
        return muster_id;
    }

    public void setMuster_id(Integer muster_id) {
        this.muster_id = muster_id;
    }

    public String getIl() {
        return il;
    }

    public void setIl(String il) {
        this.il = il;
    }

    public String getIlce() {
        return ilce;
    }

    public void setIlce(String ilce) {
        this.ilce = ilce;
    }

    public String getMahalle() {
        return mahalle;
    }

    public void setMahalle(String mahalle) {
        this.mahalle = mahalle;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
}
