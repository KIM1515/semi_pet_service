/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semi.basket.model;

import com.semi.db.DbUtil;
import com.semi.view.model.ViewDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pjm02
 */
public class BasketDAO {

    public List<ViewDTO> basketSelectAll(int personno) throws SQLException {
        Connection con =null;
        PreparedStatement ps =null;
        ResultSet rs =null;
        
        List<ViewDTO> list= new ArrayList<>();
        
        try{
            con=DbUtil.getConnection();
            
            String sql="select b.basketno, m.pdname, b.basketqty, m.price ,m.pdno" +
                " from basket b join market m" +
                " on b.pdno=m.pdno" +
                " where personno= ?" + 
                " order by basketno";
            ps=con.prepareStatement(sql);
            
            ps.setInt(1, personno);
            
            rs=ps.executeQuery();
            while(rs.next()){
                int basketno=rs.getInt(1);
                String pdName=rs.getString(2);
                int qty=rs.getInt(3);
                int price=rs.getInt(4);
                int pdno=rs.getInt(5);
                
                ViewDTO dto=new ViewDTO(basketno, pdName, qty, price,pdno);
                list.add(dto);
            }
            System.out.println("장바구니 전체 검색 결과 list.size()="+list.size()+", 매개변수 personno="+personno);
            return list;
            
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
    }
    
    public ViewDTO basketSelectChice(int personno, int basketno) throws SQLException {
        Connection con =null;
        PreparedStatement ps =null;
        ResultSet rs =null;
        
        ViewDTO dto=null;
        try{
            con=DbUtil.getConnection();
            
            String sql="select b.basketno, m.pdname, b.basketqty, m.price, m.pdno " +
                " from basket b join market m" +
                " on b.pdno=m.pdno" +
                " where personno= ? and basketno=?";
            ps=con.prepareStatement(sql);
            
            ps.setInt(1, personno);
            ps.setInt(2, basketno);
            
            rs=ps.executeQuery();
            while(rs.next()){
                int basketno2=rs.getInt(1);
                String pdName=rs.getString(2);
                int qty=rs.getInt(3);
                int price=rs.getInt(4);
                int pdno=rs.getInt(5);
                
                dto=new ViewDTO(basketno2,pdName, qty, price, pdno);
            }
            System.out.println("장바구니 선택 구매 결과 dto="+dto+ ", 매개변수 personno="+personno+", basketno="+basketno);
            return dto;
            
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
    }

    public int insertBasketPd(BasketDTO dto) throws SQLException {
        Connection con =null;
        PreparedStatement ps =null;
        
        try{
            con=DbUtil.getConnection();
            
            String sql="insert into basket(basketno, basketqty, pdno, personno)" +
                " values(basket_seq.nextval, ?,?,?)";
            ps=con.prepareStatement(sql);
            
            ps.setInt(1, dto.getBasketqty());
            ps.setInt(2, dto.getPdno());
            ps.setInt(3, dto.getPersonno());
            
            int cnt=ps.executeUpdate();
            
            System.out.println("장바구니 담기 결과 cnt="+cnt+ ", 매개변수 dto="+dto);
            return cnt;
        }finally{
            DbUtil.dbClose(ps, con);
        }
    }
    
    public int deleteSelBasket(int personno, int basketno) throws SQLException {
        Connection con =null;
        PreparedStatement ps =null;
        
        
        try{
            con=DbUtil.getConnection();
            
            String sql="delete from basket" +
                "   where personno= ? and basketno=?";
            ps=con.prepareStatement(sql);
            
            ps.setInt(1, personno);
            ps.setInt(2, basketno);
            
            int cnt=ps.executeUpdate();
            
            System.out.println("장바구니 삭제 결과 cnt="+cnt+", 매개변수 personno="+personno+", basketno="+basketno);
            return cnt;
            
        }finally{
            DbUtil.dbClose(ps, con);
        }
    }

}
