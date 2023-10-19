/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semi.person.model;

import java.sql.Timestamp;

/**
 *
 * @author pjm02
 */
public class PersonDTO {
    private int personno;
    private String name;
    private String birth;
    private String id;
    private String pwd;
    private String email;
    private String nickname;
    private String detailaddress;
    private int point;
    private Timestamp regdate;
    private int zipno;
    private int petno;
    private String hp;
    private String petname;

    public PersonDTO() {
    }

    public PersonDTO(int personno, String name, String birth, String id, String pwd, String email, String nickname, String detailaddress, int point, Timestamp regdate, int zipno, String hp) {
        this.personno = personno;
        this.name = name;
        this.birth = birth;
        this.id = id;
        this.pwd = pwd;
        this.email = email;
        this.nickname = nickname;
        this.detailaddress = detailaddress;
        this.point = point;
        this.regdate = regdate;
        this.zipno = zipno;
        this.hp = hp;
    }

    public PersonDTO(int personno, String name, String birth, String id, String pwd, String email, String nickname, String detailaddress, int zipno, String hp) {
        this.personno = personno;
        this.name = name;
        this.birth = birth;
        this.id = id;
        this.pwd = pwd;
        this.email = email;
        this.nickname = nickname;
        this.detailaddress = detailaddress;
        this.zipno = zipno;
        this.hp = hp;
    }

    PersonDTO(int personno, String name, String hp, String id, String nickname, String petname, String email, int zipno, String detailaddress, int point, Timestamp regdate) {
        this.personno=personno;
        this.name = name;
        this.hp = hp;
        this.id = id;
        this.nickname = nickname;
        this.petname=petname;
        this.email = email;
        this.zipno = zipno;
        this.detailaddress = detailaddress;
        this.point = point;
        this.regdate = regdate;
    }
    
    public PersonDTO(int personno, String name, String birth, String id,  String email, String nickname, String detailaddress, int point, Timestamp regdate, int zipno, String hp, String petname) {
        this.personno = personno;
        this.name = name;
        this.birth = birth;
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.detailaddress = detailaddress;
        this.point = point;
        this.regdate = regdate;
        this.zipno = zipno;
        this.hp = hp;
        this.petname = petname;
    }
    public PersonDTO(int personno, String name, String birth, String id, String pwd, String email, String nickname, String detailaddress, int point, Timestamp regdate, int zipno, int petno) {
        this.personno = personno;
        this.name = name;
        this.birth = birth;
        this.id = id;
        this.pwd = pwd;
        this.email = email;
        this.nickname = nickname;
        this.detailaddress = detailaddress;
        this.point = point;
        this.regdate = regdate;
        this.zipno = zipno;
        this.petno = petno;
    }

    PersonDTO(int personno, String name, String birth, String hp, String id, String nickname, String petname, String email, int zipno, String detailaddress, int point, Timestamp regdate) {
        this.personno=personno;
        this.name = name;
        this.birth = birth;
        this.hp = hp;
        this.id = id;
        this.nickname = nickname;
        this.petname=petname;
        this.email = email;
        this.zipno = zipno;
        this.detailaddress = detailaddress;
        this.point = point;
        this.regdate = regdate;
    }

    public PersonDTO(int personno, String name, String birth, String id, String pwd, String email, String nickname, String detailaddress, int point, Timestamp regdate, int zipno) {
        this.personno = personno;
        this.name = name;
        this.birth = birth;
        this.id = id;
        this.pwd = pwd;
        this.email = email;
        this.nickname = nickname;
        this.detailaddress = detailaddress;
        this.point = point;
        this.regdate = regdate;
        this.zipno = zipno;
    }

    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }


    public int getPersonno() {
        return personno;
    }

    public void setPersonno(int personno) {
        this.personno = personno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDetailaddress() {
        return detailaddress;
    }

    public void setDetailaddress(String detailaddress) {
        this.detailaddress = detailaddress;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Timestamp getRegdate() {
        return regdate;
    }

    public void setRegdate(Timestamp regdate) {
        this.regdate = regdate;
    }

    public int getZipno() {
        return zipno;
    }

    public void setZipno(int zipno) {
        this.zipno = zipno;
    }

    public int getPetno() {
        return petno;
    }

    public void setPetno(int petno) {
        this.petno = petno;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public void setZipcode(String zipcode) {
    }

    public void setUserid(String userid) {
    }

    public void setDetailAddress(String detailAddress) {
    }

    @Override
    public String toString() {
        return "PersonDTO{" + "personno=" + personno + ", name=" + name + ", birth=" + birth + ", id=" + id + ", pwd=" + pwd + ", email=" + email + ", nickname=" + nickname + ", detailaddress=" + detailaddress + ", point=" + point + ", regdate=" + regdate + ", zipno=" + zipno + ", petno=" + petno + ", hp=" + hp + ", petname=" + petname + '}';
    }
    

}
