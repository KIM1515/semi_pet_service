/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semi.stock.model;

/**
 *
 * @author pjm02
 */
public class StockDTO {
    private int stno;   // NUMBER NOT NULL, /* 번호 */
    private int stqty;  // NUMBER NOT NULL, /* 수량 */
    private int pdno;   // NUMBER /* 상품번호 */

    public StockDTO() {
    }

    public StockDTO(int stno, int stqty, int pdno) {
        this.stno = stno;
        this.stqty = stqty;
        this.pdno = pdno;
    }

    public int getStno() {
        return stno;
    }

    public void setStno(int stno) {
        this.stno = stno;
    }

    public int getStqty() {
        return stqty;
    }

    public void setStqty(int stqty) {
        this.stqty = stqty;
    }

    public int getPdno() {
        return pdno;
    }

    public void setPdno(int pdno) {
        this.pdno = pdno;
    }

    @Override
    public String toString() {
        return "StockDTO{" + "stno=" + stno + ", stqty=" + stqty + ", pdno=" + pdno + '}';
    }
    
}
