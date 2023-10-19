/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semi.market.model;

import static com.semi.market.model.MarketService.pdno;
import java.sql.Timestamp;

/**
 *
 * @author pjm02
 */
public class MarketDTO {
    private int pdno;   // NUMBER NOT NULL, /* 상품번호 */
    private String pdcategory;  // VARCHAR2(10) NOT NULL, /* 카테고리(사료,영양제,간식) */
    private String pdname;  // VARCHAR2(100) NOT NULL, /* 상품명 */
    private String catdog;  // CHAR(3) NOT NULL, /* 묘/견 */
    private int price;  // NUMBER NOT NULL, /* 가격 */
    private String fsize;   // VARCHAR2(30), /* 알갱이 */
    private String eatage;  // VARCHAR2(20), /* 급여연령 */
    private double kcal; // NUMBER NOT NULL, /* 칼로리 */
    private String predisease;  // VARCHAR2(100), /* 질병예방 */
    private Timestamp pdregdate;    // DATE DEFAULT sysdate, /* 상품등록일 */
    private int grade;  // NUMBER, /* 평점 */
    private int personno;   // NUMBER /* 회원번호 */

    public MarketDTO() {
    }
    public MarketDTO(int pdno) {
        this.pdno=pdno;
    }
    public MarketDTO(String pdname) {
        this.pdname=pdname;
    }

    public MarketDTO(int pdno, String pdcategory, String pdname, String catdog, int price, String fsize, String eatage, double kcal, String predisease, Timestamp pdregdate, int grade, int personno) {
        this.pdno = pdno;
        this.pdcategory = pdcategory;
        this.pdname = pdname;
        this.catdog = catdog;
        this.price = price;
        this.fsize = fsize;
        this.eatage = eatage;
        this.kcal = kcal;
        this.predisease = predisease;
        this.pdregdate = pdregdate;
        this.grade = grade;
        this.personno = personno;
    }
    
     public MarketDTO(int pdno, String pdcategory, String pdname, String catdog, int price, String fsize, String eatage, double kcal, String predisease, Timestamp pdregdate) {
         this.pdno = pdno;
        this.pdcategory = pdcategory;
        this.pdname = pdname;
        this.catdog = catdog;
        this.price = price;
        this.fsize = fsize;
        this.eatage = eatage;
        this.kcal = kcal;
        this.predisease = predisease;
        this.pdregdate = pdregdate;
     }

     public MarketDTO(int pdno, String pdcategory, String pdname, String catdog, int price, String fsize, String eatage, double kcal, String predisease) {
         this.pdno = pdno;
        this.pdcategory = pdcategory;
        this.pdname = pdname;
        this.catdog = catdog;
        this.price = price;
        this.fsize = fsize;
        this.eatage = eatage;
        this.kcal = kcal;
        this.predisease = predisease;
     }

     public int getPdno() {
        return pdno;
    }

    public void setPdno(int pdno) {
        this.pdno = pdno;
    }

    public String getPdcategory() {
        return pdcategory;
    }

    public void setPdcategory(String pdcategory) {
        this.pdcategory = pdcategory;
    }

    public String getPdname() {
        return pdname;
    }

    public void setPdname(String pdname) {
        this.pdname = pdname;
    }

    public String getCatdog() {
        return catdog;
    }

    public void setCatdog(String catdog) {
        this.catdog = catdog;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public String getFsize() {
        return fsize;
    }

    public void setFsize(String fsize) {
        this.fsize = fsize;
    }

    public String getEatage() {
        return eatage;
    }

    public void setEatage(String eatage) {
        this.eatage = eatage;
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


    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }


    public int getPersonno() {
        return personno;
    }

    public void setPersonno(int personno) {
        this.personno = personno;
    }

    @Override
    public String toString() {
        return "MarketDTO{" + "pdno=" + pdno + ", pdcategory=" + pdcategory + ", pdname=" + pdname + ", catdog=" + catdog + ", price=" + price + ", fsize=" + fsize + ", eatage=" + eatage + ", kcal=" + kcal + ", predisease=" + predisease + ", pdregdate=" + pdregdate + ", grade=" + grade + '}';
    }

    
}
