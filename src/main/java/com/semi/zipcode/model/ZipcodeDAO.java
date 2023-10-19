/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semi.zipcode.model;

import com.semi.db.DbUtil;
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
public class ZipcodeDAO {
    public List<ZipcodeDTO> selectZipcode(String dong) throws SQLException{
        Connection con =null;
        PreparedStatement ps =null;
        ResultSet rs=null;
        
        List<ZipcodeDTO> list = new ArrayList<>();
        
        try {
            con=DbUtil.getConnection();
            
            String sql="select * from zipcode where dong like '%' || ? || '%'";
            ps=con.prepareStatement(sql);
            ps.setString(1, dong);
            
            rs=ps.executeQuery();
            while(rs.next()){
                int zipno=rs.getInt("zipno");
                String zipcodeno=rs.getString("zipcodeno");
                String sido=rs.getString("sido");
                String gugun=rs.getString("gugun");
                String dong2=rs.getString("dong");
                String startbunji=rs.getString("startbunji");
                String endbunji=rs.getString("endbunji");
                
                ZipcodeDTO dto=new ZipcodeDTO(zipno, zipcodeno, sido, gugun,
                        dong2, startbunji, endbunji);
                list.add(dto);
            }
            System.out.println("우편번호 찾기결과:"+list.size()+"매개변수 dong:"+dong);
            return list;
        } finally {
            DbUtil.dbClose(rs, ps, con);
        }
        
    }

    public ZipcodeDTO selectByZipno(int zipno) throws SQLException {
        Connection con =null;
        PreparedStatement ps =null;
        ResultSet rs=null;
        
        ZipcodeDTO dto=null;
        try{
            con=DbUtil.getConnection();
            
            String sql="select zipcodeno, sido, gugun, dong, startbunji, endbunji from zipcode where zipno=?";
            ps=con.prepareStatement(sql);
            
            ps.setInt(1, zipno);
            
            rs=ps.executeQuery();
            if(rs.next()){
                String zipcodeno=rs.getString(1);
                String sido=rs.getString(2);
                String gugun=rs.getString(3);
                String dong=rs.getString(4);
                String startBunji=rs.getString(5);
                String endBunji=rs.getString(6);
                
                dto=new ZipcodeDTO(zipno, zipcodeno, sido, gugun, dong, startBunji, endBunji);
            }
            System.out.println("우편번호 찾기 결과 dto="+dto+"매개변수 zipno="+zipno);
            return dto;
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
    }

        public ZipcodeDTO findZipno(String gugun, String dong, String startbunji) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        ZipcodeDTO dto = new ZipcodeDTO();
        
        try{
            con = DbUtil.getConnection();
            
            String sql = "select * from zipcode where gugun = ? and dong = ? and startbunji = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, gugun);
            ps.setString(2, dong);
            ps.setString(3, startbunji);
            
            rs = ps.executeQuery();
            
            if(rs.next()) {
                int zipno = rs.getInt("zipno");
                String zipcodeno = rs.getString("zipcodeno");
                String sido = rs.getString("sido");
                String endhunji = rs.getString("endbunji");
                
                dto.setZipno(zipno);
                dto.setZipcodeno(zipcodeno);
                dto.setSido(sido);
                dto.setGugun(gugun);
                dto.setDong(dong);
                dto.setStartbunji(startbunji);
                dto.setEndbunji(endhunji);
                
            }
            
            System.out.println("zipcode 조회 결과: " + dto + ", 매개변수 : " + gugun + " " + dong + " " + startbunji);
            
            return dto;
            
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
    }
}
