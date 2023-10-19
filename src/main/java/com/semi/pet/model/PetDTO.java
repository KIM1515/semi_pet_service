/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semi.pet.model;

import java.sql.Timestamp;

/**
 *
 * @author pjm02
 */
public class PetDTO {
    private int petno;  //NUMBER NOT NULL, /* 반려동물번호 */
    private String petname; // VARCHAR2(20) NOT NULL, /* 반려동물이름 */
    private String petbirth;    // DATE, /* 반려동물생년월일 */
    private String gender;  // CHAR(6) NOT NULL, /* 성별 */
    private double weight;  // NUMBER, /* 몸무게 */
    private String neut;    // CHAR(1), /* 중성화여부 */
    private String feed;    // VARCHAR2(200), /* 먹는 사료 */
    private String allergy; // VARCHAR2(200), /* 알러지 */
    private Timestamp petregdate;   // DATE DEFAULT sysdate, /* 등록일자 */
    private int anino;  // NUMBER NOT NULL /* 번호(묘/견종) */
    private int personno;   

    public PetDTO(){
    }
    
    public PetDTO(int petno, String petname, String petbirth, String gender, double weight, String neut, String feed, String allergy, Timestamp petregdate, int anino, int personno) {
        this.petno = petno;
        this.petname = petname;
        this.petbirth = petbirth;
        this.gender = gender;
        this.weight = weight;
        this.neut = neut;
        this.feed = feed;
        this.allergy = allergy;
        this.petregdate = petregdate;
        this.anino = anino;
        this.personno = personno;
    }

    public int getPetno() {
        return petno;
    }

    public void setPetno(int petno) {
        this.petno = petno;
    }

    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }

    public String getPetbirth() {
        return petbirth;
    }

    public void setPetbirth(String petbirth) {
        this.petbirth = petbirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getNeut() {
        return neut;
    }

    public void setNeut(String neut) {
        this.neut = neut;
    }

    public String getFeed() {
        return feed;
    }

    public void setFeed(String feed) {
        this.feed = feed;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public Timestamp getPetregdate() {
        return petregdate;
    }

    public void setPetregdate(Timestamp petregdate) {
        this.petregdate = petregdate;
    }

    public int getAnino() {
        return anino;
    }

    public void setAnino(int anino) {
        this.anino = anino;
    }

    public int getPersonno() {
        return personno;
    }

    public void setPersonno(int personno) {
        this.personno = personno;
    }

    @Override
    public String toString() {
        return "PetDTO{" + "petno=" + petno + ", petname=" + petname + ", petbirth=" + petbirth + ", gender=" + gender + ", weight=" + weight + ", neut=" + neut + ", feed=" + feed  + ", allergy=" + allergy + ", petregdate=" + petregdate + ", anino=" + anino + ", personno=" + personno + '}';
    }

    
}
