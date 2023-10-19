/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semi.market.model;

import com.semi.db.DbUtil;
import com.semi.view.model.ViewDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author pjm02
 */
public class MarketDAO {
    JLabel lb;
    
    public List<ViewDTO> pdSelectTop20() throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        ViewDTO dto=null;
        List<ViewDTO> list = new ArrayList<>();
        
        try{
            con=DbUtil.getConnection();
            
            String sql="select pdno, pdname, price" +
            " from(" +
            "    select pdno, pdname, price, pdregdate from market" +
            "    order by pdregdate desc" +
            " )a" +
            " where rownum<=20" +
            " order by pdregdate desc";
           ps=con.prepareStatement(sql);
           
           rs=ps.executeQuery();
           while(rs.next()){
               int pdno=rs.getInt(1);
               String pdName=rs.getString(2);
               int price=rs.getInt(3);
               
               dto=new ViewDTO(pdno,pdName, price);
               list.add(dto);
           }
                      System.out.println("최신 상품 TOP 20 결과 dto="+dto+", list의 크기="+list.size());
           return list;
            
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
    }

    public ViewDTO selectByPdNo(int pdno) throws SQLException {
        Connection con=null;
        PreparedStatement ps =null;
        ResultSet rs =null;
        
        ViewDTO dto=new ViewDTO();
        
        try{
            con=DbUtil.getConnection();
            
            String sql="select pdno , pdname, price, fsize, eatage, kcal, predisease, grade from market where pdno=?";
            ps=con.prepareStatement(sql);
            
            ps.setInt(1, pdno);
            
            rs=ps.executeQuery();
            
            if(rs.next()){
                int pdno2=rs.getInt(1);
                String pdName=rs.getString(2);
                int price=rs.getInt(3);
                String fsize=rs.getString(4);
                String eatage=rs.getString(5);
                int kcal=rs.getInt(6);
                String predisease=rs.getString(7);
                int grade=rs.getInt(8);
                
                dto=new ViewDTO(pdno2, pdName, price, fsize, eatage, kcal, predisease, grade);
            }
            System.out.println("선택한 상품 결과 dto="+dto+", 매개변수 pdno="+pdno);
            return dto;
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
    }

    public List<ViewDTO> selectPdName(String pdcategory, String pdName) throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs =null;
        
        List<ViewDTO> list =new ArrayList<>();
        try{
            con=DbUtil.getConnection();
            
            String sql="select pdno, pdcategory, pdname, catdog, price, grade from market where pdcategory=? and pdname like '%'|| ? ||'%'";
            ps=con.prepareStatement(sql);
            
            ps.setString(1, pdcategory);
            ps.setString(2, pdName);
            
            rs=ps.executeQuery();
            while(rs.next()){
                int pdno=rs.getInt(1);
                String pdCategory=rs.getString(2);
                String pName=rs.getString(3);
                String catdog=rs.getString(4);
                int price=rs.getInt(5);
                int grade=rs.getInt(6);
                
                ViewDTO dto =new ViewDTO(pName, pdno, price, pdCategory, catdog, grade);
                list.add(dto);
            }
            System.out.println("카테고리, 상품명으로 검색결과 list.size()="+list.size()+"매개변수 pdCategory="+pdcategory+", pdname="+pdName);
            return list;
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
        
        
    }

    public List<ViewDTO> selectPrice(int minPrice, int maxPrice) throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs =null;
        
        List<ViewDTO> list=new ArrayList<>();
        
        try{
            con=DbUtil.getConnection();
            
            String sql="select pdno, pdcategory, pdname, catdog, price,grade from market where price between ? and ?";
            ps=con.prepareStatement(sql);
            
            ps.setInt(1,minPrice);
            ps.setInt(2,maxPrice);
            
            rs=ps.executeQuery();
            while(rs.next()){
                int pdno=rs.getInt(1);
                String pdCategory=rs.getString(2);
                String pdName=rs.getString(3);
                String catDog=rs.getString(4);
                int price=rs.getInt(5);
                int grade=rs.getInt(6);
                
                ViewDTO dto =new ViewDTO(pdName, pdno, price, pdCategory, catDog, grade);
                
                list.add(dto);
            }
            System.out.println("가격으로 상품검색 결과 list.size()="+list.size()+"매개변수 minPrice="+minPrice+", maxPrice="+maxPrice);
            return list;
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
    }

 //관리자 - 등록
    public int insertPd(MarketDTO dto) throws SQLException{
        Connection con =null;
        PreparedStatement ps =null;
        
        try{
        con=DbUtil.getConnection();
           
           String sql=" insert into market(pdno,pdcategory,pdname,catdog,price,fsize,eatage,kcal,predisease,pdregdate,grade) "
                   + "  values(?,?,?,?,?,?,?,?,?,sysdate,0)";
           ps=con.prepareStatement(sql);
           ps.setInt(1, dto.getPdno());
           ps.setString(2, dto.getPdcategory());
           ps.setString(3, dto.getPdname());
           ps.setString(4, dto.getCatdog());
           ps.setInt(5, dto.getPrice());
           ps.setString(6, dto.getFsize());
           ps.setString(7, dto.getEatage());
           ps.setDouble(8, dto.getKcal());
           ps.setString(9, dto.getPredisease());
           
           int cnt=ps.executeUpdate();
           System.out.println("관리자 pd등록:"+cnt);
           
           return cnt;
    }finally{
            DbUtil.dbClose(ps, con);
        }
    }
    
       //pdno 받아오기
    public MarketDTO getPdno(String pdname) throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        MarketDTO dto = null;
        try {
            con=DbUtil.getConnection();
            String sql=" select pdno from market where pdname=?" 
                    + " order by pdregdate";
            ps=con.prepareStatement(sql);
            ps.setString(1, pdname);
            
            rs=ps.executeQuery();
            if(rs.next()){
                int pdno=rs.getInt(1);
                dto=new MarketDTO(pdno);
            }
            return dto;
        } finally {
            DbUtil.dbClose(rs, ps, con);
        }
        
    }
    
    //pdno 받아오기2
    public MarketDTO getPdnoName(int pdno) throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        MarketDTO dto = null;
        MarketDTO dto2 = null;
        try {
            con=DbUtil.getConnection();
            String sql=" select pdno,pdname from market where pdno=?" 
                    + " order by pdregdate";
            ps=con.prepareStatement(sql);
            ps.setInt(1, pdno);
            
            rs=ps.executeQuery();
            if(rs.next()){
                int pdno1=rs.getInt(1);
                String pdname=rs.getString(2);
                dto=new MarketDTO(pdno);
                dto2=new MarketDTO(pdname);
            }
            return dto;
        } finally {
            DbUtil.dbClose(rs, ps, con);
        }
        
    } 
    
    //관리자 수정
    public int updatePd(MarketDTO dto) throws SQLException{
        Connection con =null;
        PreparedStatement ps =null;
        
        try {
            con=DbUtil.getConnection();
            
            String sql="update market"
                    + " set pdcategory=? , pdname=? ,catdog=? ,fsize=?,eatage=?,"
                    + " kcal=?, prediseas=?, pdregdate=?"
                    + " where pdno=? ";
            ps=con.prepareStatement(sql);
            ps.setString(1, dto.getPdcategory());
            ps.setString(2, dto.getPdname());
            ps.setString(3, dto.getCatdog());
            ps.setString(4, dto.getFsize());
            ps.setString(5, dto.getEatage());
            ps.setDouble(6, dto.getKcal());
            ps.setString(7, dto.getPredisease());
            ps.setTimestamp(8, dto.getPdregdate());
            ps.setInt(9, dto.getPdno());
            int cnt=ps.executeUpdate();
            System.out.println("상품 수정 결과:"+cnt);
            return cnt;
        } finally {
            DbUtil.dbClose(ps, con);
        }
        
    }

    public int deleteMarketByNo(int pdno) throws SQLException {
       Connection con=null;
       PreparedStatement ps=null;
       
       try {
           con=DbUtil.getConnection();
           
           String sql=" delete from market where pdno=? ";
           ps=con.prepareStatement(sql);
           ps.setInt(1, pdno);
           
           int cnt=ps.executeUpdate();
           System.out.println("상품 삭제 결과:"+cnt);
           return cnt;
       } finally {
           DbUtil.dbClose(ps, con);
       }
    }
    
    //입고테이블 pdname등록
    public int insertPdName(MarketDTO dto) throws SQLException{
        Connection con =null;
        PreparedStatement ps =null;
        
        try {
            con=DbUtil.getConnection();
            String sql=" insert into market(pdno,pdname)"
                    + " values (market_seq.nextval,?) ";
            ps=con.prepareStatement(sql);
            ps.setString(1, dto.getPdname());
            
            int cnt=ps.executeUpdate();
           System.out.println("입고등록 결과:"+cnt+", 매개변수 dto:"+dto);
           return cnt;
           
        } finally {
            DbUtil.dbClose(ps, con);
        }
    }
    
    public int updateSt(MarketDTO dto) throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        
        try {
            con=DbUtil.getConnection();
            
            String sql=" update market"
                    + " set pdname=? "
                    + " where pdno=? ";
            ps=con.prepareStatement(sql);
            ps.setString(1, dto.getPdname());
            ps.setInt(2, dto.getPdno());
            
            int cnt=ps.executeUpdate();
            System.out.println("입고 상품명 수정:"+cnt+", 매개변수 dto:"+dto);
            return cnt;
            
        } finally {
            DbUtil.dbClose(ps, con);
        }
    }
    
}
