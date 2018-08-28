package com.example.x.ultrapskafe;

public class Kayıt {

    private String ID ;
    private String MASA_NO ;
    private String YAPILAN_ISLER ;
    private String TARIH_SAAT ;
    private String KAZANC ;


    public Kayıt(String ID,String MASA_NO,String YAPILAN_ISLER,String TARIH_SAAT,String KAZANC){
        this.ID=ID;
        this.MASA_NO=MASA_NO;
        this.YAPILAN_ISLER=YAPILAN_ISLER;
        this.TARIH_SAAT=TARIH_SAAT;
        this.KAZANC=KAZANC;

    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMASA_NO() {
        return MASA_NO;
    }

    public void setMASA_NO(String MASA_NO) {
        this.MASA_NO = MASA_NO;
    }

    public String getYAPILAN_ISLER() {
        return YAPILAN_ISLER;
    }

    public void setYAPILAN_ISLER(String YAPILAN_ISLER) {
        this.YAPILAN_ISLER = YAPILAN_ISLER;
    }

    public String getTARIH_SAAT() {
        return TARIH_SAAT;
    }

    public void setTARIH_SAAT(String TARIH_SAAT) {
        this.TARIH_SAAT = TARIH_SAAT;
    }

    public String getKAZANC() {
        return KAZANC;
    }

    public void setKAZANC(String KAZANC) {
        this.KAZANC = KAZANC;
    }
}
