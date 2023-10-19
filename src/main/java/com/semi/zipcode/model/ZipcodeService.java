
package com.semi.zipcode.model;

public class ZipcodeService {
    private static ZipcodeDTO dto;
    private static ZipcodeDAO dao;
    private static String bunji;
    
    public static void setBunji(String bunji){
        ZipcodeService.bunji = bunji;
    }
    
    public static String getbunji(){
        return bunji;
    }
    
}
