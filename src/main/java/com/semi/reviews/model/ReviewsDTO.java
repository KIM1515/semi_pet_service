/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semi.reviews.model;

import java.sql.Timestamp;

/**
 *
 * @author pjm02
 */
public class ReviewsDTO {
    private int reviewno;   // NUMBER NOT NULL, /* 리뷰번호 */
    private String reviewbody;  // VARCHAR2(1000) NOT NULL, /* 후기 */
    private int reviewgrade;    // NUMBER NOT NULL, /* 별점 */
    private Timestamp reviewregdate;    // DATE DEFAULT sysdate, /* 등록일 */
    private int pdno;   // NUMBER NOT NULL, /* 상품번호 */
    private int personno;   // NUMBER NOT NULL /* 회원번호 */

    public ReviewsDTO() {
    }

    public ReviewsDTO(int reviewno, String reviewbody, int reviewgrade, Timestamp reviewregdate, int pdno, int personno) {
        this.reviewno = reviewno;
        this.reviewbody = reviewbody;
        this.reviewgrade = reviewgrade;
        this.reviewregdate = reviewregdate;
        this.pdno = pdno;
        this.personno = personno;
    }

    public ReviewsDTO(String reviewbody, int reviewgrade, int pdno, int personno) {
        this.reviewbody = reviewbody;
        this.reviewgrade = reviewgrade;
        this.pdno = pdno;
        this.personno = personno;
    }
    
    

    public int getReviewno() {
        return reviewno;
    }

    public void setReviewno(int reviewno) {
        this.reviewno = reviewno;
    }

    public String getReviewbody() {
        return reviewbody;
    }

    public void setReviewbody(String reviewbody) {
        this.reviewbody = reviewbody;
    }

    public int getReviewgrade() {
        return reviewgrade;
    }

    public void setReviewgrade(int reviewgrade) {
        this.reviewgrade = reviewgrade;
    }

    public Timestamp getReviewregdate() {
        return reviewregdate;
    }

    public void setReviewregdate(Timestamp reviewregdate) {
        this.reviewregdate = reviewregdate;
    }

    public int getPdno() {
        return pdno;
    }

    public void setPdno(int pdno) {
        this.pdno = pdno;
    }

    public int getPersonno() {
        return personno;
    }

    public void setPersonno(int personno) {
        this.personno = personno;
    }

    @Override
    public String toString() {
        return "ReviewsDTO{" + "reviewno=" + reviewno + ", reviewbody=" + reviewbody + ", reviewgrade=" + reviewgrade + ", reviewregdate=" + reviewregdate + ", pdno=" + pdno + ", personno=" + personno + '}';
    }
    
}
