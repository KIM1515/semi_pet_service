/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semi.reviews.model;

import com.semi.db.DbUtil;
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
public class ReviewsDAO {

    public List<ViewDTO> selectPdReview() throws SQLException {
        Connection con=null;
        PreparedStatement ps =null;
        ResultSet rs=null;
        
        List<ViewDTO> list =new ArrayList<>();
        
        try{
            con=DbUtil.getConnection();
            
            String sql="select (select nickname from person p where p.personno=r.personno)"
                    + " nickname,r.reviewbody, r.reviewgrade,r.reviewregdate"
                    + " from reviews r order by reviewregdate desc";
            ps=con.prepareStatement(sql);
            
            rs=ps.executeQuery();
            while(rs.next()){
                String nickName=rs.getString(1);
                String reviewbody=rs.getString(2);
                int grade=rs.getInt(3);
                Timestamp regdate=rs.getTimestamp(4);
                
                ViewDTO dto=new ViewDTO(grade, nickName, reviewbody, regdate);
                
                list.add(dto);
            }
            return list;
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
    }
    
}
