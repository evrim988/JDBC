package org.example._02_JDBC_Forum.entites;

import org.example._01_JDBC_ETicaret.entity.BaseEntity;

public class User extends BaseEntity {
    private int id;
    private String ad;
    private String soyad;
    private String username;
    private String password;

    public User() {
    }

    public User(String ad, String soyad, String username, String password) {
        this.ad = ad;
        this.soyad = soyad;
        this.username = username;
        this.password = password;
    }

    public User(int id, String ad, String soyad, String username, String password) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.username = username;
        this.password = password;
    }

    public User(int id, String ad, String soyad, String username, String password,Integer state,Long createat, Long updateat) {
        super(state, createat, updateat);
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + getId() + ", ad='" + getAd() + '\'' + ", soyad='" + getSoyad() + '\'' + ", username='" + getUsername() + '\'' + ", password='" + getPassword() + '\'' + ", state=" + getState() + ", createat=" + getCreateat() + ", updateat=" + getUpdateat() + '}';
    }
}
