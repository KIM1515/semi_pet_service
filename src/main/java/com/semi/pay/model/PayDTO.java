/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semi.pay.model;

/**
 *
 * @author pjm02
 */
public class PayDTO {
    private int rownum;
    private int payno;  
    private String cardcom;  
    private String cardno;  
    private String cvc;    
    private String expiration;
    private int personno;  
    private String cardpassword;
    private String paypassword;

    public PayDTO() {
    }

    public PayDTO(int payno, String cardcom, String cardno, String cvc, String cardpassword, String paypassword, String expiration, int personno) {
        this.payno = payno;
        this.cardcom = cardcom;
        this.cardno = cardno;
        this.cvc = cvc;
        this.cardpassword = cardpassword;
        this.paypassword = paypassword;
        this.expiration = expiration;
        this.personno = personno;
    }

    public PayDTO(String cardcom, String cardno, String cvc, String paypassword, String expiration) {
        this.cardcom = cardcom;
        this.cardno = cardno;
        this.cvc = cvc;
        this.paypassword = paypassword;
        this.expiration = expiration;
    }

    public PayDTO(int rownum, int payno, String cardcom, String cardno, String cvc, int personno, String cardpassword, String paypassword, String expiration) {
        this.payno = payno;
        this.cardcom = cardcom;
        this.cardno = cardno;
        this.cvc = cvc;
        this.personno = personno;
        this.cardpassword = cardpassword;
        this.paypassword = paypassword;
        this.expiration = expiration;
    }

    public PayDTO(int rownum, int payno, String cardcom, String cardno, String paypassword, String expiration) {
        this.rownum = rownum;
        this.payno = payno;
        this.cardcom = cardcom;
        this.cardno = cardno;
        this.paypassword = paypassword;
        this.expiration = expiration;
    }

    public int getRownum() {
        return rownum;
    }
    
    public void setRownum(int rownum) {
        this.rownum = rownum;
    }


    public String getCardpassword() {
        return cardpassword;
    }

    public void setCardpassword(String cardpassword) {
        this.cardpassword = cardpassword;
    }

    public String getPaypassword() {
        return paypassword;
    }

    public void setPaypassword(String paypassword) {
        this.paypassword = paypassword;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public int getPayno() {
        return payno;
    }

    public void setPayno(int payno) {
        this.payno = payno;
    }

    public String getCardcom() {
        return cardcom;
    }

    public void setCardcom(String cardcom) {
        this.cardcom = cardcom;
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public int getPersonno() {
        return personno;
    }

    public void setPersonno(int personno) {
        this.personno = personno;
    }

    @Override
    public String toString() {
        return "PayDTO{" + "payno=" + payno + ", cardcom=" + cardcom + ", cardno=" + cardno + ", cvc=" + cvc + ", cardpassword=" + cardpassword + ", paypassword=" + paypassword + ", expiration=" + expiration + ", personno=" + personno + '}';
    }

}
