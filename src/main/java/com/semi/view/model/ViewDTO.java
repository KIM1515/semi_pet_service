/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semi.view.model;

import java.sql.Timestamp;

/**
 *
 * @author ezen
 */
public class ViewDTO {
    private int basketno;
    private String pdName;
    private int basketqty;

    private int orderno;
    private int orderdtqty;
    private int bno;
    private String bcategory1;
    private String bcategory3;
    private String btitle;
    private String id;
    private Timestamp bregdate;
    private int bviewcnt;
    
    private int pdno;
    private int price;
    
    private String predisease;
    private String fsize;
    private String eatage;
    private int kcal;
    private int grade;
    
    private String pdcategory;
    private String catdog;
    
    private String nickName;
    private String reviewbody;
    private Timestamp regdate;
    

    public ViewDTO() {
    }

    public ViewDTO(int orderno, int pdno, String pdName, int orderdtqty, String pdcategory, Timestamp regdate) {
        this.pdName = pdName;
        this.orderno = orderno;
        this.orderdtqty = orderdtqty;
        this.regdate = regdate;
        this.pdno = pdno;
        this.pdcategory = pdcategory;
    }

    public ViewDTO(int basketno,String pdName, int basketqty, int price, int pdno) {
        this.basketno=basketno;
        this.pdName = pdName;
        this.basketqty = basketqty;
        this.price = price;
        this.pdno=pdno;
    }

    public ViewDTO(int bno,String bcategory1, String bcategory3, String btitle, String id, Timestamp bregdate, int bviewcnt) {
        this.bno=bno;
        this.bcategory1 = bcategory1;
        this.bcategory3 = bcategory3;
        this.btitle = btitle;
        this.id = id;
        this.bregdate = bregdate;
        this.bviewcnt = bviewcnt;
    }

    public ViewDTO(int pdno, String pdName, int price) {
        this.pdno=pdno;
        this.pdName = pdName;
        this.price = price;
    }

    public ViewDTO(int pdno, String pdName, int price , String fsize, String eatage, int kcal, String predisease, int grade) {
        this.pdno=pdno;
        this.pdName = pdName;
        this.price = price;
        this.fsize = fsize;
        this.eatage = eatage;
        this.kcal = kcal;
        this.predisease=predisease;
        this.grade=grade;
    }

    public ViewDTO(int grade, String nickName, String reviewbody, Timestamp regdate) {
        this.grade = grade;
        this.nickName = nickName;
        this.reviewbody = reviewbody;
        this.regdate = regdate;
    }

    public ViewDTO(String pdName, int pdno, int price, String pdcategory, String catdog , int grade) {
        this.pdName = pdName;
        this.pdno = pdno;
        this.price = price;
        this.pdcategory = pdcategory;
        this.catdog = catdog;
        this.grade=grade;
    }

    public int getOrderno() {
        return orderno;
    }

    public void setOrderno(int orderno) {
        this.orderno = orderno;
    }

    public int getOrderdtqty() {
        return orderdtqty;
    }

    public void setOrderdtqty(int orderdtqty) {
        this.orderdtqty = orderdtqty;
    }

    
    public int getBasketno() {
        return basketno;
    }

    public void setBasketno(int basketno) {
        this.basketno = basketno;
    }
    
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getReviewbody() {
        return reviewbody;
    }

    public void setReviewbody(String reviewbody) {
        this.reviewbody = reviewbody;
    }

    public Timestamp getRegdate() {
        return regdate;
    }

    public void setRegdate(Timestamp regdate) {
        this.regdate = regdate;
    }
    
    
    
    public ViewDTO(String pdName, byte[] buf, int price) {
        this.pdName = pdName;
        this.price = price;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
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

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public String getPredisease() {
        return predisease;
    }

    public void setPredisease(String predisease) {
        this.predisease = predisease;
    }
    
    
    public int getPdno() {
        return pdno;
    }

    public void setPdno(int pdno) {
        this.pdno = pdno;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public String getPdName() {
        return pdName;
    }

    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    public int getBasketqty() {
        return basketqty;
    }

    public void setBasketqty(int basketqty) {
        this.basketqty = basketqty;
    }

    public String getBcategory1() {
        return bcategory1;
    }

    public void setBcategory1(String bcategory1) {
        this.bcategory1 = bcategory1;
    }

    public String getBcategory3() {
        return bcategory3;
    }

    public void setBcategory3(String bcategory3) {
        this.bcategory3 = bcategory3;
    }

    public String getBtitle() {
        return btitle;
    }

    public void setBtitle(String btitle) {
        this.btitle = btitle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getBregdate() {
        return bregdate;
    }

    public void setBregdate(Timestamp bregdate) {
        this.bregdate = bregdate;
    }

    public int getBviewcnt() {
        return bviewcnt;
    }

    public void setBviewcnt(int bviewcnt) {
        this.bviewcnt = bviewcnt;
    }

    @Override
    public String toString() {
        return "ViewDTO{" + "basketno=" + basketno + ", pdName=" + pdName + ", basketqty=" + basketqty + ", orderno=" + orderno + ", orderdtqty=" + orderdtqty + ", bno=" + bno + ", bcategory1=" + bcategory1 + ", bcategory3=" + bcategory3 + ", btitle=" + btitle + ", id=" + id + ", bregdate=" + bregdate + ", bviewcnt=" + bviewcnt + ", pdno=" + pdno + ", price=" + price + ", predisease=" + predisease + ", fsize=" + fsize + ", eatage=" + eatage + ", kcal=" + kcal + ", grade=" + grade + ", pdcategory=" + pdcategory + ", catdog=" + catdog + ", nickName=" + nickName + ", reviewbody=" + reviewbody + ", regdate=" + regdate + '}';
    }

    
}
