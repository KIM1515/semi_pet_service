
package com.semi.pet_animaltype_view.model;

import java.sql.Timestamp;

public class Pet_animaltype_ViewDTO {
    private int petno;
    private String petname;
    private String petbirth;
    private String gender;
    private double weight;
    private String neut;
    private String feed;
    private String allergy;
    private Timestamp petregdate;
    private int anino;
    private int personno;
    private String anitype;
    private String anikinds;
    
    public Pet_animaltype_ViewDTO() {
    }

    public Pet_animaltype_ViewDTO(int petno, String petname, String petbirth, String gender, double weight, String neut, String feed, String allergy, Timestamp petregdate, int anino, int personno, String anitype, String anikinds) {
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
        this.anitype = anitype;
        this.anikinds = anikinds;
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
        return "Pet_animaltype_ViewDTO{" + "petno=" + petno + ", petname=" + petname + ", petbirth=" + petbirth + ", gender=" + gender + ", weight=" + weight + ", neut=" + neut + ", feed=" + feed + ", allergy=" + allergy + ", petregdate=" + petregdate + ", anino=" + anino + ", personno=" + personno + ", anitype=" + anitype + ", anikinds=" + anikinds + '}';
    }
    
    
    
}
