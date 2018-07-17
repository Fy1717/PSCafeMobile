package com.example.x.ultrapskafe;

public class Masa {

    private String ID ;
    private String MASA_NO ;
    private String MASA_TURU_ID ;
    private String MASA_DURUMU ;
    private String KOL_SAYISI ;
    private String ACILIS_SAATI;
    private String KAPANIS_SAATI;
    private String UCRET ;





    public Masa(String ID,String MASA_NO,String MASA_TURU_ID,String MASA_DURUMU,String KOL_SAYISI,String ACILIS_SAATI,String KAPANIS_SAATI,String UCRET){

        super();

        this.ID=ID;
        this.MASA_NO=MASA_NO;
        this.MASA_TURU_ID=MASA_TURU_ID;
        this.MASA_DURUMU=MASA_DURUMU;
        this.KOL_SAYISI=KOL_SAYISI;
        this.ACILIS_SAATI=ACILIS_SAATI;
        this.KAPANIS_SAATI=KAPANIS_SAATI;
        this.UCRET=UCRET;


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

    public String getMASA_TURU_ID() {
        return MASA_TURU_ID;
    }

    public void setMASA_TURU_ID(String MASA_TURU_ID) {
        this.MASA_TURU_ID = MASA_TURU_ID;
    }

    public String getMASA_DURUMU() {
        return MASA_DURUMU;
    }

    public void setMASA_DURUMU(String MASA_DURUMU) {
        this.MASA_DURUMU = MASA_DURUMU;
    }

    public String getKOL_SAYISI() {
        return KOL_SAYISI;
    }

    public void setKOL_SAYISI(String KOL_SAYISI) {
        this.KOL_SAYISI = KOL_SAYISI;
    }

    public String getACILIS_SAATI() {
        return ACILIS_SAATI;
    }

    public void setACILIS_SAATI(String ACILIS_SAATI) {
        this.ACILIS_SAATI = ACILIS_SAATI;
    }

    public String getKAPANIS_SAATI() {
        return KAPANIS_SAATI;
    }

    public void setKAPANIS_SAATI(String KAPANIS_SAATI) {
        this.KAPANIS_SAATI = KAPANIS_SAATI;
    }

    public String getUCRET() {
        return UCRET;
    }

    public void setUCRET(String UCRET) {
        this.UCRET = UCRET;
    }


}
