package org.example._01_JDBC_ETicaret.entity;

import java.time.LocalDate;

public class Musteri extends BaseEntity{

    private int id;
    private String ad;
    private String soyad;
    private String cinsiyet;
    private LocalDate date;
    private String email;
    private String sehir;
    private String tel;

    public Musteri() {

    }

    //id'siz constructor
    public Musteri(String ad, String soyad, String cinsiyet, LocalDate date, String email, String sehir, String tel) {
        this.ad = ad;
        this.soyad = soyad;
        this.cinsiyet = cinsiyet;
        this.date = date;
        this.email = email;
        this.sehir = sehir;
        this.tel = tel;
    }

    public Musteri(int id, String ad, String soyad, String cinsiyet, LocalDate date, String email, String sehir, String tel) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.cinsiyet = cinsiyet;
        this.date = date;
        this.email = email;
        this.sehir = sehir;
        this.tel = tel;
    }

    public Musteri(int id, String ad, String soyad, String cinsiyet, LocalDate date, String email, String sehir, String tel,
    Integer state, Long createat, Long updateat ) {
        super(state, createat, updateat);
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.cinsiyet = cinsiyet;
        this.date = date;
        this.email = email;
        this.sehir = sehir;
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Musteri{" +
                "id=" + id +
                ", ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                ", cinsiyet='" + cinsiyet + '\'' +
                ", date=" + date +
                ", email='" + email + '\'' +
                ", sehir='" + sehir + '\'' +
                ", sehir='" + tel + '\'' +
                ", state=" + getState() +
                ", createat=" + getCreateat() +
                ", updateat=" + getUpdateat() +
                '}';
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }


}
