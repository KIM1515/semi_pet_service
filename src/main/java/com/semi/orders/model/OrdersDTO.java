/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semi.orders.model;

import java.sql.Timestamp;

/**
 *
 * @author pjm02
 */
public class OrdersDTO {
    private int orderno;    // NUMBER NOT NULL, /* 주문번호 */
    private String orderaddress;    // VARCHAR2(100), /* 주소 */
    private Timestamp orderregdate; // DATE DEFAULT sysdate, /* 판매일 */
    private int personno;   // NUMBER, /* 회원번호 */
    private String orderName;
    private String orderHp;
    private int zipno;  // NUMBER /* 번호(우편) */

    public OrdersDTO() {
    }

    public OrdersDTO(int orderno, String orderaddress, Timestamp orderregdate, int personno, String orderName, String orderHp, int zipno) {
        this.orderno = orderno;
        this.orderaddress = orderaddress;
        this.orderregdate = orderregdate;
        this.personno = personno;
        this.orderName = orderName;
        this.orderHp = orderHp;
        this.zipno = zipno;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderHp() {
        return orderHp;
    }

    public void setOrderHp(String orderHp) {
        this.orderHp = orderHp;
    }

    
    
    public int getOrderno() {
        return orderno;
    }

    public void setOrderno(int orderno) {
        this.orderno = orderno;
    }

    public String getOrderaddress() {
        return orderaddress;
    }

    public void setOrderaddress(String orderaddress) {
        this.orderaddress = orderaddress;
    }

    public Timestamp getOrderregdate() {
        return orderregdate;
    }

    public void setOrderregdate(Timestamp orderregdate) {
        this.orderregdate = orderregdate;
    }

    public int getPersonno() {
        return personno;
    }

    public void setPersonno(int personno) {
        this.personno = personno;
    }

    public int getZipno() {
        return zipno;
    }

    public void setZipno(int zipno) {
        this.zipno = zipno;
    }

    @Override
    public String toString() {
        return "OrdersDTO{" + "orderno=" + orderno + ", orderaddress=" + orderaddress + ", orderregdate=" + orderregdate + ", personno=" + personno + ", orderName=" + orderName + ", orderHp=" + orderHp + ", zipno=" + zipno + '}';
    }

}
