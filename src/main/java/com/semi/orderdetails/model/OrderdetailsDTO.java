/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semi.orderdetails.model;

/**
 *
 * @author pjm02
 */
public class OrderdetailsDTO {
    private int pdno;   // NUMBER NOT NULL, /* 상품번호 */
    private int orderno;    //NUMBER NOT NULL, /* 주문번호 */
    private int orderdtqty; // NUMBER NOT NULL /* 수량 */

    public OrderdetailsDTO() {
    }

    public OrderdetailsDTO(int pdno, int orderno, int orderdtqty) {
        this.pdno = pdno;
        this.orderno = orderno;
        this.orderdtqty = orderdtqty;
    }

    public int getPdno() {
        return pdno;
    }

    public void setPdno(int pdno) {
        this.pdno = pdno;
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

    @Override
    public String toString() {
        return "OrderdetailsDTO{" + "pdno=" + pdno + ", orderno=" + orderno + ", orderdtqty=" + orderdtqty + '}';
    }
    
}
