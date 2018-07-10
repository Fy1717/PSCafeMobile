package com.example.x.ultrapskafe;

public class Masa {

    private String ID ;
    private String MASA_NO ;
    private String MASA_TURU_ID ;
    private String MASA_DURUMU ;



    public Masa(String ID,String MASA_NO,String MASA_TURU_ID,String MASA_DURUMU){

        super();

        this.ID=ID;
        this.MASA_NO=MASA_NO;
        this.MASA_TURU_ID=MASA_TURU_ID;
        this.MASA_DURUMU=MASA_DURUMU;

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

    public String getMASA_TURU_ID(){
        return MASA_TURU_ID;
    }

    public void setMASA_TURU_ID(String MASA_TURU_ID){
        this.MASA_TURU_ID=MASA_TURU_ID;
    }

    public String getMASA_DURUMU() {
        return MASA_DURUMU;
    }

    public void setMASA_DURUMU(String MASA_DURUMU) {
        this.MASA_DURUMU = MASA_DURUMU;
    }
}
