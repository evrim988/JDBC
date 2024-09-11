package org.example._02_JDBC_Forum.entites;

import org.example._01_JDBC_ETicaret.entity.BaseEntity;

import java.time.LocalDateTime;

public class Post extends BaseEntity {

    private int id;
    private int user_id;
    private String baslik;
    private String icerik;
    private LocalDateTime paylasimTarihi;

    public Post() {

    }

    public Post(int user_id, String baslik, String icerik, LocalDateTime paylasimTarihi) {
        this.user_id = user_id;
        this.baslik = baslik;
        this.icerik = icerik;
        this.paylasimTarihi = paylasimTarihi;
    }

    public Post(int id, int user_id, String baslik, String icerik, LocalDateTime paylasimTarihi) {
        this.id = id;
        this.user_id = user_id;
        this.baslik = baslik;
        this.icerik = icerik;
        this.paylasimTarihi = paylasimTarihi;
    }

    public Post( int id, int user_id, String baslik, String icerik, LocalDateTime paylasimTarihi, Integer state, Long createat, Long updateat) {
        super(state, createat, updateat);
        this.id = id;
        this.user_id = user_id;
        this.baslik = baslik;
        this.icerik = icerik;
        this.paylasimTarihi = paylasimTarihi;
    }

    public int getId() {
        return id;
    }


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getIcerik() {
        return icerik;
    }

    public void setIcerik(String icerik) {
        this.icerik = icerik;
    }

    public LocalDateTime getPaylasimTarihi() {
        return paylasimTarihi;
    }

    public void setPaylasimTarihi(LocalDateTime paylasimTarihi) {
        this.paylasimTarihi = paylasimTarihi;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + getId() +
                ", user_id=" + getUser_id() +
                ", baslik='" + getBaslik() + '\'' +
                ", icerik='" + getIcerik() + '\'' +
                ", paylasimTarihi=" + getPaylasimTarihi() +
                ", state=" + getState() +
                ", createat=" + getCreateat() +
                ", updateat=" + getUpdateat() +
                '}';
    }
}
