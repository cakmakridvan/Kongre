package com.rota.kongresistem.model.bildiriList;

public class ModelBildiri {

    private String No;
    private String konusu;
    private String turu;
    private String basligi;
    private String yazarBilgileri;
    private String bildiriDurumu;

    public String getNo() {
        return No;
    }

    public void setNo(String no) {
        No = no;
    }

    public String getKonusu() {
        return konusu;
    }

    public void setKonusu(String konusu) {
        this.konusu = konusu;
    }

    public String getTuru() {
        return turu;
    }

    public void setTuru(String turu) {
        this.turu = turu;
    }

    public String getBasligi() {
        return basligi;
    }

    public void setBasligi(String basligi) {
        this.basligi = basligi;
    }

    public String getYazarBilgileri() {
        return yazarBilgileri;
    }

    public void setYazarBilgileri(String yazarBilgileri) {
        this.yazarBilgileri = yazarBilgileri;
    }

    public String getBildiriDurumu() {
        return bildiriDurumu;
    }

    public void setBildiriDurumu(String bildiriDurumu) {
        this.bildiriDurumu = bildiriDurumu;
    }

}
