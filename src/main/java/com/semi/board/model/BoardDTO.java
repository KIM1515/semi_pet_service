/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semi.board.model;

import java.sql.Timestamp;

/**
 *
 * @author yes03
 */
public class BoardDTO {
    private int bno; 
    private String bcategory1;  
    private String bcategory2;  
    private String bcategory3; 
    private String btitle;  
    private String bbody;   
    private int bviewcnt;  
    private int bgood; 
    private Timestamp bregdate;    
    private int personno;
    private String nickname;

    public BoardDTO() {
    }
    
     //관리자
    public BoardDTO(int bno, String bcategory1, String btitle, String nickname, Timestamp bregdate, int bviewcnt, int bgood) {
        this.bno = bno;
        this.bcategory1 = bcategory1;
        this.btitle = btitle;
        this.nickname = nickname;
        this.bregdate = bregdate;
        this.bviewcnt = bviewcnt;
        this.bgood = bgood;
    }
    
    //게시판 테이블
    public BoardDTO(int bno, String btitle, String nickname, Timestamp bregdate, int bviewcnt, int bgood) {
        this.bno = bno;
        this.btitle = btitle;
        this.nickname = nickname;
        this.bregdate = bregdate;
        this.bviewcnt = bviewcnt;
        this.bgood = bgood;
    }
    //게시판 글읽기
    public BoardDTO(String bcategory1, String bcategory2, String bcategory3, String btitle, String nickname, Timestamp bregdate, int bviewcnt, int bgood, String bbody) {
        this.bcategory1 = bcategory1;
        this.bcategory2 = bcategory2;
        this.bcategory3 = bcategory3;
        this.btitle = btitle;
        this.nickname = nickname;
        this.bregdate = bregdate;
        this.bviewcnt = bviewcnt;
        this.bgood = bgood;
        this.bbody = bbody;
        //this.bimage = bimage;  
    }
    //텍스트필드로 검색
    public BoardDTO(int bno, String bcategory1, String btitle, String bbody, String nickname, Timestamp bregdate) {
        this.bno = bno;
        this.bcategory1 = bcategory1;
        this.btitle = btitle;
        this.bbody = bbody;
        this.nickname = nickname;
        this.bregdate = bregdate;
    }
    
    //멤버변수 전체 
    public BoardDTO(int bno, String bcategory1, String bcategory2, String bcategory3, String btitle, String bbody, int bviewcnt, int bgood, Timestamp bregdate, int personno, String nickname) {
        this.bno = bno;
        this.bcategory1 = bcategory1;
        this.bcategory2 = bcategory2;
        this.bcategory3 = bcategory3;
        this.btitle = btitle;
        this.bbody = bbody;
        this.bviewcnt = bviewcnt;
        this.bgood = bgood;
        this.bregdate = bregdate;
        this.personno = personno;
        this.nickname = nickname;
    }
   
    
    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getBcategory1() {
        return bcategory1;
    }

    public void setBcategory1(String bcategory1) {
        this.bcategory1 = bcategory1;
    }

    public String getBcategory2() {
        return bcategory2;
    }

    public void setBcategory2(String bcategory2) {
        this.bcategory2 = bcategory2;
    }

    public String getBcategory3() {
        return bcategory3;
    }

    public void setBcategory3(String bcategory3) {
        this.bcategory3 = bcategory3;
    }

    public String getBtitle() {
        return btitle;
    }

    public void setBtitle(String btitle) {
        this.btitle = btitle;
    }

    public String getBbody() {
        return bbody;
    }

    public void setBbody(String bbody) {
        this.bbody = bbody;
    }

    public int getBviewcnt() {
        return bviewcnt;
    }

    public void setBviewcnt(int bviewcnt) {
        this.bviewcnt = bviewcnt;
    }

    public int getBgood() {
        return bgood;
    }

    public void setBgood(int bgood) {
        this.bgood = bgood;
    }

    public Timestamp getBregdate() {
        return bregdate;
    }

    public void setBregdate(Timestamp bregdate) {
        this.bregdate = bregdate;
    }

    public int getPersonno() {
        return personno;
    }

    public void setPersonno(int personno) {
        this.personno = personno;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "BoardDTO{" + "bno=" + bno + ", bcategory1=" + bcategory1 + ", bcategory2=" + bcategory2 + ", bcategory3=" + bcategory3 + ", btitle=" + btitle + ", bbody=" + bbody + ", bviewcnt=" + bviewcnt + ", bgood=" + bgood + ", bregdate=" + bregdate + ", personno=" + personno + ", nickname=" + nickname + '}';
    }

}
