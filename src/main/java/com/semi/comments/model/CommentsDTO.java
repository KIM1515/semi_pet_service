/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semi.comments.model;

import java.sql.Timestamp;

/**
 *
 * @author yes03
 */
public class CommentsDTO {
    private String checkBox; //체크박스
    private int rownum;
    private String type; //댓글/ 답글의 구분
    private int cono;
    private String nickname;
    private String cobody; 
    private Timestamp coregdate;   
    private int cogood;
    private int personno;
    private int bno;
            
    public CommentsDTO() {

    }
    //댓글+답글 자세히보기
    public CommentsDTO(String cobody, String nickname, int cogood, Timestamp coregdate){
        this.cobody = cobody;
        this.nickname = nickname;
        this.cogood = cogood;
        this.coregdate = coregdate;
    }
            
    //게시판 내 댓글+답글 조회
    public CommentsDTO(String checkbox, int rownum, int cono, String type, String nickname, String cobody, Timestamp coregdate, int cogood) {
        this.checkBox = checkbox;
        this.rownum = rownum;
        this.cono = cono; 
        this.type = type; //댓글/답글의 구분
        this.nickname = nickname;
        this.cobody = cobody;
        this.coregdate = coregdate;
        this.cogood = cogood;
    }

    public String getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(String checkBox) {
        this.checkBox = checkBox;
    }

    public int getRownum() {
        return rownum;
    }

    public void setRownum(int rownum) {
        this.rownum = rownum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCono() {
        return cono;
    }

    public void setCono(int cono) {
        this.cono = cono;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCobody() {
        return cobody;
    }

    public void setCobody(String cobody) {
        this.cobody = cobody;
    }

    public Timestamp getCoregdate() {
        return coregdate;
    }

    public void setCoregdate(Timestamp coregdate) {
        this.coregdate = coregdate;
    }

    public int getCogood() {
        return cogood;
    }

    public void setCogood(int cogood) {
        this.cogood = cogood;
    }

    public int getPersonno() {
        return personno;
    }

    public void setPersonno(int personno) {
        this.personno = personno;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    @Override
    public String toString() {
        return "CommentsDTO{" + "checkBox=" + checkBox + ", rownum=" + rownum + ", type=" + type + ", cono=" + cono + ", nickname=" + nickname + ", cobody=" + cobody + ", coregdate=" + coregdate + ", cogood=" + cogood + ", personno=" + personno + ", bno=" + bno + '}';
    }
}
