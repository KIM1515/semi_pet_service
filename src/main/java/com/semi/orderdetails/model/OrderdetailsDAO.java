/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semi.orderdetails.model;

import com.semi.db.DbUtil;
import com.semi.reviews.model.ReviewsDTO;
import com.semi.view.model.ViewDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pjm02
 */
public class OrderdetailsDAO {
    
    //주문상세내역 입력
    public int insertPdDetail(OrderdetailsDTO dto) throws SQLException {
        Connection con =null;
        PreparedStatement ps =null;
        
        try{
            con=DbUtil.getConnection();
            
            String sql="insert into orderdetails values(?,?,?)";
            ps=con.prepareStatement(sql);
            
            ps.setInt(1, dto.getPdno());
            ps.setInt(2, dto.getOrderno());
            ps.setInt(3, dto.getOrderdtqty());
            
            int cnt=ps.executeUpdate();
            
            System.out.println("주문상세내역 입력결과 cnt="+cnt+"매개변수 dto="+dto);
            return cnt;
        }finally{
            DbUtil.getConnection();
        }
    }
    
    //주문상세내역
    public List<ViewDTO> selectOD() throws SQLException {
        Connection con =null;
        PreparedStatement ps =null;
        ResultSet rs=null;
        
        List<ViewDTO> list= new ArrayList<>();
        try{
            con=DbUtil.getConnection();
            
            String sql="select o.orderno, m.pdno, m.pdname, od.orderdtqty , m.pdcategory, o.orderregdate" +
                    " from orderdetails od join orders o" +
                    " on od.orderno=o.orderno" +
                    " join market m" +
                    " on m.pdno= od.pdno" +
                    " order by orderno desc";
            ps=con.prepareStatement(sql);
            
            rs=ps.executeQuery();
            while(rs.next()){
                int orderno=rs.getInt(1);
                int pdno=rs.getInt(2);
                String pdName=rs.getString(3);
                int qty=rs.getInt(4);
                String pdcategory=rs.getString(5);
                Timestamp regdate=rs.getTimestamp(6);
                
                ViewDTO dto=new ViewDTO(orderno, pdno, pdName, qty, pdcategory, regdate);
                list.add(dto);
            }
            
            System.out.println("주문상세내역 결과 list.size()="+list.size());
            return list;
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
    }

    public int insertReview(ReviewsDTO dto) throws SQLException {
        Connection con =null;
        PreparedStatement ps =null;
        
        try{
            con=DbUtil.getConnection();
            
            String sql="insert into reviews(reviewno,reviewbody,reviewgrade,reviewregdate,pdno,personno)" +
                    " values(reviews_seq.nextval,?,?,sysdate,?,?)";
            ps=con.prepareStatement(sql);
            
            ps.setString(1, dto.getReviewbody());
            ps.setInt(2, dto.getReviewgrade());
            ps.setInt(3, dto.getPdno());
            ps.setInt(4, dto.getPersonno());
            
            int cnt=ps.executeUpdate();
            
            System.out.println("리뷰 등록 결과 cnt="+cnt+", 매개변수 dto="+dto);
            return cnt;
        }finally{
            DbUtil.dbClose(ps, con);
        }
    }
    
}
