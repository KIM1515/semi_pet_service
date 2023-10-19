/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semi.pay.model;

/**
 *
 * @author pjm02
 */
public class PayService {
    private static String cardNo;
    private static String expiration;
    private static String cvc;
    private static String pwd;
    private static String com;
    private static String payPwd;

    public static String getCardNo() {
        return cardNo;
    }

    public static void setCardNo(String cardNo) {
        PayService.cardNo = cardNo;
    }

    public static String getExpiration() {
        return expiration;
    }

    public static void setExpiration(String expiration) {
        PayService.expiration = expiration;
    }

    public static String getCvc() {
        return cvc;
    }

    public static void setCvc(String cvc) {
        PayService.cvc = cvc;
    }

    public static String getPwd() {
        return pwd;
    }

    public static void setPwd(String pwd) {
        PayService.pwd = pwd;
    }

    public static String getCom() {
        return com;
    }

    public static void setCom(String com) {
        PayService.com = com;
    }

    public static String getPayPwd() {
        return payPwd;
    }

    public static void setPayPwd(String payPwd) {
        PayService.payPwd = payPwd;
    }
    
    
}
