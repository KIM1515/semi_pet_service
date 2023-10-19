/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semi.orders.model;

import com.semi.db.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pjm02
 */
public class OrdersDAO {

    public int pdOrder(OrdersDTO dto) throws SQLException {
        Connection con =null;
        PreparedStatement ps =null;
        
        try{
            con=DbUtil.getConnection();
            
            String sql ="insert into orders(orderno, ordername, orderaddress, personno, zipno, orderhp)" +
                " values(orders_seq.nextval,?,?,?,?,?)";
            ps=con.prepareStatement(sql);
            
            ps.setString(1, dto.getOrderName());
            ps.setString(2, dto.getOrderaddress());
            ps.setInt(3, dto.getPersonno());
            ps.setInt(4, dto.getZipno());          
            ps.setString(5, dto.getOrderHp());
            
            int cnt=ps.executeUpdate();
            
            System.out.println("주문 결과 cnt="+cnt+ "매개변수 dto="+dto);
            return cnt;
            
        }finally{
            DbUtil.dbClose(ps, con);
        }
        
    }

    public int findOrderNo(OrdersDTO dto) throws SQLException {
        Connection con =null;
        PreparedStatement ps =null;
        ResultSet rs =null;
        
        int orderno=0;
        
        try{
            con=DbUtil.getConnection();
            
            String sql="select orderno, orderregdate from orders where ordername=? and"
                    + " orderaddress=? and zipno=? and personno=? and orderhp=?"
                    + " order by orderregdate desc";
            ps=con.prepareStatement(sql);
            
            ps.setString(1, dto.getOrderName());
            ps.setString(2, dto.getOrderaddress());
            ps.setInt(3, dto.getZipno());
            ps.setInt(4, dto.getPersonno());
            ps.setString(5, dto.getOrderHp());
            
            rs=ps.executeQuery();
            
            if(rs.next()){
                orderno=rs.getInt(1);
            }
            
            System.out.println("주문번호 orderno="+orderno+"매개변수 dto="+dto);
            return orderno;
        }finally{
            DbUtil.dbClose(ps, con);
        }
    }
    
}
