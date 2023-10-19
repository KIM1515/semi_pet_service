/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semi.animaltype.model;

/**
 *
 * @author pjm02
 */
public class AnimalTypeDTO {
    private int anino;  // NUMBER NOT NULL, /* 번호(묘/견종) */
    private String anitype; // CHAR(1) NOT NULL, /* 구분값(묘/견) */
    private String anikinds;    // VARCHAR2(100) NOT NULL /* 묘/견종 */

    public AnimalTypeDTO() {
    }

    public AnimalTypeDTO(int anino, String anitype, String anikinds) {
        this.anino = anino;
        this.anitype = anitype;
        this.anikinds = anikinds;
    }

    public int getAnino() {
        return anino;
    }

    public void setAnino(int anino) {
        this.anino = anino;
    }

    public String getAnitype() {
        return anitype;
    }

    public void setAnitype(String anitype) {
        this.anitype = anitype;
    }

    public String getAnikinds() {
        return anikinds;
    }

    public void setAnikinds(String anikinds) {
        this.anikinds = anikinds;
    }

    @Override
    public String toString() {
        return "AnimalTypeDTO{" + "anino=" + anino + ", anitype=" + anitype + ", anikinds=" + anikinds + '}';
    }
    
}
