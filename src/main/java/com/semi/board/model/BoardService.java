/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semi.board.model;

/**
 *
 * @author yes03
 */
public class BoardService {
    private static int bno;
    private static String bcategory1;
    private static String bcategory2;
    private static String bcategory3=""; 
    
    public static int getBno() {
        return bno;
    }

    public static void setBno(int bno) {
        BoardService.bno = bno;
    }  

    public static String getBcategory1() {
        return bcategory1;
    }

    public static void setBcategory1(String bcategory1) {
        BoardService.bcategory1 = bcategory1;
    }

    public static String getBcategory2() {
        return bcategory2;
    }

    public static void setBcategory2(String bcategory2) {
        BoardService.bcategory2 = bcategory2;
    }

    public static String getBcategory3() {
        return bcategory3;
    }

    public static void setBcategory3(String bcategory3) {
        BoardService.bcategory3 = bcategory3;
    }


}
