/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semi.basket.model;

/**
 *
 * @author pjm02
 */
public class BasketDTO {
    private int basketno;   // NUMBER NOT NULL, /* 번호 */
    private int basketqty;  // NUMBER NOT NULL, /* 수량 */
    private int pdno;   // NUMBER NOT NULL, /* 상품번호 */
    private int personno;   // NUMBER /* 회원번호 */

    public BasketDTO() {
    }

    public BasketDTO(int basketno, int basketqty, int pdno, int personno) {
        this.basketno = basketno;
        this.basketqty = basketqty;
        this.pdno = pdno;
        this.personno = personno;
    }

    public BasketDTO(int basketqty, int pdno, int personno) {
        this.basketqty = basketqty;
        this.pdno = pdno;
        this.personno = personno;
    }
    
    public int getBasketno() {
        return basketno;
    }

    public void setBasketno(int basketno) {
        this.basketno = basketno;
    }

    public int getBasketqty() {
        return basketqty;
    }

    public void setBasketqty(int basketqty) {
        this.basketqty = basketqty;
    }

    public int getPdno() {
        return pdno;
    }

    public void setPdno(int pdno) {
        this.pdno = pdno;
    }

    public int getPersonno() {
        return personno;
    }

    public void setPersonno(int personno) {
        this.personno = personno;
    }

    @Override
    public String toString() {
        return "BasketDTO{" + "basketno=" + basketno + ", basketqty=" + basketqty + ", pdno=" + pdno + ", personno=" + personno + '}';
    }
    
}
