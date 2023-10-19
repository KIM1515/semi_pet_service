/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semi.zipcode.model;

/**
 *
 * @author pjm02
 */
public class ZipcodeDTO {
    private int zipno;  // NUMBER NOT NULL, /* 번호(우편) */
    private String zipcodeno;  // NUMBER NOT NULL, /* 우편번호 */
    private String sido;    // VARCHAR2(30) NOT NULL, /* 시도 */
    private String gugun;   // VARCHAR2(15) NOT NULL, /* 구군 */
    private String dong;    // VARCHAR2(20) NOT NULL, /* 동 */
    private String startbunji;  
    private String endbunji;

    public ZipcodeDTO() {
    }

    public ZipcodeDTO(int zipno, String zipcodeno, String sido, String gugun, String dong, String startbunji, String endbunji) {
        this.zipno = zipno;
        this.zipcodeno = zipcodeno;
        this.sido = sido;
        this.gugun = gugun;
        this.dong = dong;
        this.startbunji = startbunji;
        this.endbunji = endbunji;
    }

    public int getZipno() {
        return zipno;
    }

    public void setZipno(int zipno) {
        this.zipno = zipno;
    }

    public String getZipcodeno() {
        return zipcodeno;
    }

    public void setZipcodeno(String zipcodeno) {
        this.zipcodeno = zipcodeno;
    }

    public String getSido() {
        return sido;
    }

    public void setSido(String sido) {
        this.sido = sido;
    }

    public String getGugun() {
        return gugun;
    }

    public void setGugun(String gugun) {
        this.gugun = gugun;
    }

    public String getDong() {
        return dong;
    }

    public void setDong(String dong) {
        this.dong = dong;
    }

    public String getStartbunji() {
        return startbunji;
    }

    public void setStartbunji(String startbunji) {
        this.startbunji = startbunji;
    }

    public String getEndbunji() {
        return endbunji;
    }

    public void setEndbunji(String endbunji) {
        this.endbunji = endbunji;
    }

    @Override
    public String toString() {
        return "ZipcodeDTO{" + "zipno=" + zipno + ", zipcodeno=" + zipcodeno + ", sido=" + sido + ", gugun=" + gugun + ", dong=" + dong + ", startbunji=" + startbunji + ", endbunji=" + endbunji + '}';
    }
    
    
}
