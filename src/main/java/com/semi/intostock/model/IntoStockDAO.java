/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semi.intostock.model;

import com.semi.db.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

/**
 *
 * @author pjm02
 */
public class IntoStockDAO {
    
    //관리자
   public List<IntoStockDTO> MarketSelectAll() throws SQLException{
       Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        List<IntoStockDTO> listS=new ArrayList<>();
       try {
           con=DbUtil.getConnection();
           
           String sql="select m.pdno, m.pdcategory, m.pdname, m.catdog, m.price, m.eatage," 
                   +" m.fsize,m.kcal,m.predisease,i.intostqty, m.pdregdate" 
                   +" from market m left join intostock i" 
                   +" on m.pdno=i.pdno " 
                   + " order by m.pdno ";
           
           ps=con.prepareStatement(sql);
           rs=ps.executeQuery();
           while(rs.next()){
               int pdno=rs.getInt(1);
               String pdcategory=rs.getString(2);
               String pdname=rs.getString(3);
               String catdog=rs.getString(4);
               int price=rs.getInt(5);
               String eatage=rs.getString(6);
               String fsize=rs.getString(7);
               double kcal=rs.getDouble(8);
               String predisease=rs.getString(9);
               int intostqty=rs.getInt(10);
               Timestamp pdregdate=rs.getTimestamp(11);
               
               IntoStockDTO dto = new IntoStockDTO(pdno, pdcategory, pdname, catdog, price, eatage, fsize, kcal, predisease, intostqty, pdregdate);
               listS.add(dto);
           }
           System.out.println("마켓상품 전체조회="+listS.size());
           return listS;
       } finally {
           DbUtil.dbClose(rs, ps, con);
       }
   }
   
   //뿌리기용
   public IntoStockDTO selectNo(int pdno) throws SQLException{
       Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        IntoStockDTO dto = new IntoStockDTO();
       try {
           con=DbUtil.getConnection();
           String sql="select m.pdno, m.pdcategory, m.pdname, m.catdog, m.price,m.eatage," 
                   +" m.fsize,m.kcal,m.predisease,i.intostqty,i.intostregdate, m.pdregdate" 
                   +" from market m left join intostock i" 
                   +" on m.pdno=i.pdno  "
                   + " where m.pdno=? ";
           ps=con.prepareStatement(sql);
           ps.setInt(1, pdno);
           
           rs=ps.executeQuery();
           if(rs.next()){
               int pdno1=rs.getInt(1);
               String pdcategory=rs.getString(2);
               String pdname=rs.getString(3);
               String catdog=rs.getString(4);
               int price=rs.getInt(5);
               String eatage=rs.getString(6);
               String fsize=rs.getString(7);
               double kcal=rs.getDouble(8);
               String predisease=rs.getString(9);
               int intostqty=rs.getInt(10);
               Timestamp inregdate=rs.getTimestamp(11);
               Timestamp pdregdate=rs.getTimestamp(12);
               
               dto.setPdno(pdno1);
               dto.setPdcategory(pdcategory);
               dto.setPdname(pdname);
               dto.setCatdog(catdog);
               dto.setPrice(price);
               dto.setEatage(eatage);
               dto.setFsize(fsize);
               dto.setKcal(kcal);
               dto.setPredisease(predisease);
               dto.setIntostqty(intostqty);
               dto.setIntostregdate(inregdate);
               dto.setPdregdate(pdregdate);
           }        
           
           System.out.println("번호로 뿌리기 결과, dto="+dto+", 매개변수 pdno="+pdno);
           return dto;
       } finally {
           DbUtil.dbClose(rs, ps, con);
       }
   }
   
   //상품 번호조회
   public List<IntoStockDTO> marketSelectByPdNo(int pdno) throws SQLException{
       Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        List<IntoStockDTO> listNo=new ArrayList<>();
       try {
           con=DbUtil.getConnection();
           
           String sql="select m.pdno, m.pdcategory, m.pdname, m.catdog, m.price,m.eatage," 
                   +" m.fsize,m.kcal,m.predisease,i.intostqty, m.pdregdate" 
                   +" from market m left join intostock i" 
                   +" on m.pdno=i.pdno  "
                   + " where m.pdno=? " ;
                   
           ps=con.prepareStatement(sql);
           ps.setInt(1, pdno);
           
           rs=ps.executeQuery();
           while(rs.next()){
               int pdno1=rs.getInt(1);
               String pdcategory=rs.getString(2);
               String pdname=rs.getString(3);
               String catdog=rs.getString(4);
               int price=rs.getInt(5);
               String eatage=rs.getString(6);
               String fsize=rs.getString(7);
               double kcal=rs.getDouble(8);
               String predisease=rs.getString(9);
               int intostqty=rs.getInt(10);
               Timestamp pdregdate=rs.getTimestamp(12);
               
               IntoStockDTO dto = new IntoStockDTO(pdno1, pdcategory, pdname, catdog, price, eatage, fsize, kcal, predisease, intostqty, pdregdate);
               listNo.add(dto);
           }
           System.out.println("상품번호 검색, listNo의 크기:"+listNo);
           return listNo;
       } finally {
           DbUtil.dbClose(rs, ps, con);
       }
   }
   
   //등록
   public int insertMarket(IntoStockDTO dto) throws SQLException{
       Connection con = null;
       PreparedStatement ps =null;
       
       try {
           con=DbUtil.getConnection();
           
           String sql=" insert into intostock(intostno,intostqty,intostregdate,pdno) "
                   + " values(intostock_seq.nextval,?,sysdate,?)";
           ps=con.prepareStatement(sql);
           ps.setInt(1, dto.getIntostqty());
           ps.setInt(2, dto.getPdno());
           
           int cnt=ps.executeUpdate();
           System.out.println("입고(상품등록) 결과:"+cnt+", 매개변수 dto:"+dto);
           return cnt;
           
       } finally {
           DbUtil.dbClose(ps, con);
       }
       
   }
   
   public int updatePd(IntoStockDTO dto) throws SQLException{
       Connection con =null;
       PreparedStatement ps =null;
       
       try {
           con=DbUtil.getConnection();
           
           String sql="update intostock" 
                   + " set intostqty=?" 
                   + " where pdno=? ";
           ps=con.prepareStatement(sql);
           ps.setInt(1, dto.getIntostqty());
           ps.setInt(2, dto.getPdno());
           int cnt=ps.executeUpdate();
           System.out.println("상품수정 결과:"+cnt+", 매개변수 dto:"+dto);
           return cnt;
       } finally {
           DbUtil.dbClose(ps, con);
       }
   }
   
   //입고관리
   //뿌리기
   public IntoStockDTO selectIntoNo(int pdno) throws SQLException{
       Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        IntoStockDTO dto = new IntoStockDTO();
       try {
           con=DbUtil.getConnection();
           String sql="select i.pdno, m.pdname, i.intostqty, i.intostregdate" 
                   +" from intostock i left join market m  " 
                   +" on i.pdno=m.pdno "
                   + " where i.pdno=?" 
                   + " order by i.pdno ";
           
           ps=con.prepareStatement(sql);
           ps.setInt(1, pdno);
           
           rs=ps.executeQuery();
           if(rs.next()){
               int pdno1=rs.getInt(1);
               String pdname=rs.getString(2);
               int intostqty=rs.getInt(3);
               Timestamp intostregdate=rs.getTimestamp(4);
               
               dto.setPdno(pdno1);
               dto.setPdname(pdname);
               dto.setIntostqty(intostqty);
               dto.setIntostregdate(intostregdate);
           }        
           
           System.out.println("번호로 뿌리기 결과, dto="+dto+", 매개변수 pdno="+pdno);
           return dto;
           
       } finally {
           DbUtil.dbClose(rs, ps, con);
       }
   }
   
   //삭제
   public int deleteStockByNo(int pdno) throws SQLException {
       Connection con=null;
       PreparedStatement ps=null;
       
       try {
           con=DbUtil.getConnection();
           
           String sql=" delete from intostock where pdno=? ";
           ps=con.prepareStatement(sql);
           ps.setInt(1, pdno);
           
           int cnt=ps.executeUpdate();
           System.out.println("상품 삭제 결과:"+cnt);
           return cnt;
       } finally {
           DbUtil.dbClose(ps, con);
       }
       
   }
   
   //전체조회
   public List<IntoStockDTO> IntoStockSelectAll() throws SQLException{
       Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        List<IntoStockDTO> list=new ArrayList<>();
       try {
           con=DbUtil.getConnection();
           
           String sql="select i.pdno, m.pdname, i.intostqty, i.intostregdate" 
                   +" from intostock i left join market m  " 
                   +" on i.pdno=m.pdno " 
                   + " order by i.pdno ";
           
           ps=con.prepareStatement(sql);
           rs=ps.executeQuery();
           while(rs.next()){
               int pdno=rs.getInt(1);
               String pdname=rs.getString(2);
               int intostqty=rs.getInt(3);
               Timestamp intostregdate=rs.getTimestamp(4);
               
               IntoStockDTO dto = new IntoStockDTO(pdno, pdname, intostqty, intostregdate);
               list.add(dto);
           }
           System.out.println("입고상품 전체조회="+list.size());
           return list;
           
       } finally {
           DbUtil.dbClose(rs, ps, con);
       }
   }
   
   
   public List<IntoStockDTO> IntoSelectByPdNo(int pdno) throws SQLException{
       Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        List<IntoStockDTO> listNo=new ArrayList<>();
       try {
           con=DbUtil.getConnection();
           
           String sql="select i.pdno, m.pdname, i.intostqty, i.intostregdate" 
                   +" from intostock i left join market m  " 
                   +" on i.pdno=m.pdno " 
                   + " where i.pdno=?";
                   
           ps=con.prepareStatement(sql);
           ps.setInt(1, pdno);
           
           rs=ps.executeQuery();
           while(rs.next()){
              int pdno1=rs.getInt(1);
               String pdname=rs.getString(2);
               int intostqty=rs.getInt(3);
               Timestamp intostregdate=rs.getTimestamp(4);
               
               IntoStockDTO dto = new IntoStockDTO(pdno1, pdname, intostqty, intostregdate);
               listNo.add(dto);
           }
           System.out.println("입고 상품번호 검색, listNo의 크기:"+listNo);
           return listNo;
       } finally {
           DbUtil.dbClose(rs, ps, con);
       }
       
   }
   
   
   //등록
   public int insertIntoSt(IntoStockDTO dto) throws SQLException{
       Connection con = null;
       PreparedStatement ps =null;
       
       try {
           con=DbUtil.getConnection();
           
           String sql=" insert into intostock(intostno,intostqty,intostregdate,pdno) "
                + " values(intostock_seq.nextval,?,sysdate,?)";
           ps=con.prepareStatement(sql);
          ps.setInt(1, dto.getIntostqty());
        ps.setInt(2, dto.getPdno());
           
           int cnt=ps.executeUpdate();
           System.out.println("입고 결과:"+cnt+", 매개변수 dto:"+dto);
           return cnt;
           
       } finally {
           DbUtil.dbClose(ps, con);
       }
   }
   
   public int updateIntoSt(IntoStockDTO dto) throws SQLException {
       Connection con =null;
       PreparedStatement ps =null;
       
       try {
           con=DbUtil.getConnection();
           
           String sql=" update intostock" 
                   + " set intostqty=?" 
                   + " where pdno=? ";
           ps=con.prepareStatement(sql);
           ps.setInt(1, dto.getIntostqty());
           ps.setInt(2, dto.getPdno());
           
           int cnt=ps.executeUpdate();
           System.out.println("상품수정 결과:"+cnt+", 매개변수 dto:"+dto);
           return cnt;
       } finally {
           DbUtil.dbClose(ps, con);
       }
   }
   
   
}
