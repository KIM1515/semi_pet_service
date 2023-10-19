/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semi.market.model;

/**
 *
 * @author ezen
 */
public class MarketService {
    public static int pdno;
    public static String pdName;
    public static int qty;
    public static int price;

    public MarketService() {
    }

    public MarketService(int pdno) {
        this.pdno=pdno;
    }
    
    public MarketService(String pdName,int price,int qty) {
        this.pdName=pdName;
        this.price=price;
        this.qty=qty;
    }

    public static String getPdName() {
        return pdName;
    }

    public static void setPdName(String pdName) {
        MarketService.pdName = pdName;
    }

    public static int getQty() {
        return qty;
    }

    public static void setQty(int qty) {
        MarketService.qty = qty;
    }

    public static int getPdno() {
        return pdno;
    }

    public static void setPdno(int pdno) {
        MarketService.pdno = pdno;
    }

    public static int getPrice() {
        return price;
    }

    public static void setPrice(int price) {
        MarketService.price = price;
    }
    
    
}
