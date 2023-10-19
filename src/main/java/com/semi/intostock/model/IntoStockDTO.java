/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semi.intostock.model;

import java.sql.Timestamp;

/**
 *
 * @author pjm02
 */
public class IntoStockDTO {
    private int intostno;   // NUMBER NOT NULL, /* 번호 */
    private int intostqty;  // NUMBER NOT NULL, /* 수량 */
    private Timestamp intostregdate;    // DATE DEFAULT sysdate, /* 입고일 */
    private int pdno;   // NUMBER /* 상품번호 */
    private String pdname;
    private int price;
    
    private String pdcategory;
    private String catdog;
    private String eatage;
    private String fsize; 
    private double kcal;
    private String predisease;
    private Timestamp pdregdate;
    
    public IntoStockDTO() {
    }

    //관리자
    public IntoStockDTO(int intostno, int pdno, String pdcategory, String pdname, String catdog, int price, String eatage, String fsize, double kcal, String predisease, int intostqty, Timestamp intostregdate, Timestamp pdregdate) {
        this.intostno = intostno;
        this.pdno = pdno;
        this.pdcategory = pdcategory;
        this.pdname = pdname;
        this.catdog = catdog;
        this.price = price;
        this.eatage = eatage;
        this.fsize = fsize;
        this.kcal = kcal;
        this.predisease = predisease;
        this.intostqty = intostqty;
        this.intostregdate = intostregdate;
        this.pdregdate = pdregdate;
    }

    public IntoStockDTO(int pdno, String pdcategory, String pdname, String catdog, int price, String eatage, String fsize, double kcal, String predisease, int intostqty, Timestamp pdregdate) {
        this.pdno = pdno;
        this.pdcategory = pdcategory;
        this.pdname = pdname;
        this.catdog = catdog;
        this.price = price;
        this.eatage = eatage;
        this.fsize = fsize;
        this.kcal = kcal;
        this.predisease = predisease;
        this.intostqty = intostqty;
        this.pdregdate = pdregdate;
    }

    public IntoStockDTO(int intostqty) {
        this.intostqty = intostqty;
    }
    
    public IntoStockDTO(int pdno, String pdname, int intostqty, Timestamp intostregdate) {
        this.pdno = pdno;
        this.pdname = pdname;
        this.intostqty = intostqty;
        this.intostregdate = intostregdate;
    }
    
    public IntoStockDTO(int pdno, int intostqty) {
        this.pdno = pdno;
        this.intostqty = intostqty;
    }
    
    
    public int getIntostno() {
        return intostno;
    }

    public void setIntostno(int intostno) {
        this.intostno = intostno;
    }

    public int getIntostqty() {
        return intostqty;
    }

    public void setIntostqty(int intostqty) {
        this.intostqty = intostqty;
    }

    public Timestamp getIntostregdate() {
        return intostregdate;
    }

    public void setIntostregdate(Timestamp intostregdate) {
        this.intostregdate = intostregdate;
    }

    public int getPdno() {
        return pdno;
    }

    public void setPdno(int pdno) {
        this.pdno = pdno;
    }

    public String getPdname() {
        return pdname;
    }

    public void setPdname(String pdname) {
        this.pdname = pdname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPdcategory() {
        return pdcategory;
    }

    public void setPdcategory(String pdcategory) {
        this.pdcategory = pdcategory;
    }

    public String getCatdog() {
        return catdog;
    }

    public void setCatdog(String catdog) {
        this.catdog = catdog;
    }

    public String getEatage() {
        return eatage;
    }

    public void setEatage(String eatage) {
        this.eatage = eatage;
    }

    public String getFsize() {
        return fsize;
    }

    public void setFsize(String fsize) {
        this.fsize = fsize;
    }

    public double getKcal() {
        return kcal;
    }

    public void setKcal(double kcal) {
        this.kcal = kcal;
    }

    public String getPredisease() {
        return predisease;
    }

    public void setPredisease(String predisease) {
        this.predisease = predisease;
    }

    public Timestamp getPdregdate() {
        return pdregdate;
    }

    public void setPdregdate(Timestamp pdregdate) {
        this.pdregdate = pdregdate;
    }

    @Override
    public String toString() {
        return "IntoStockDTO{" + "intostno=" + intostno + ", intostqty=" + intostqty + ", intostregdate=" + intostregdate + ", pdno=" + pdno + ", pdname=" + pdname + ", price=" + price + ", pdcategory=" + pdcategory + ", catdog=" + catdog + ", eatage=" + eatage + ", fsize=" + fsize + ", kcal=" + kcal + ", predisease=" + predisease + ", pdregdate=" + pdregdate + '}';
    }
    
    
    
    
}
