package com.semi.animaltype.model;

import com.semi.db.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class AnimalTypeDAO {
    
    public AnimalTypeDTO selectByAniKinds(String aniKinds) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        AnimalTypeDTO dto = new AnimalTypeDTO();
        try{
            con = DbUtil.getConnection();
            
            String sql = "select * from animaltype where anikinds = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, aniKinds);
            
            rs = ps.executeQuery();
            if(rs.next()) {
                int anino = rs.getInt("anino");
                String anitype = rs.getString("anitype");
                
                dto.setAnino(anino);
                dto.setAnitype(anitype);
                dto.setAnikinds(aniKinds);
            }
            
            System.out.println("animaltype 조회 결과: " + dto + ", 매개변수 anikind : " + aniKinds);
            
            return dto;
            
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
    }
    
    public String[] getAnimalTypeList(String anitype) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<String> list = new ArrayList<>();
        try{
            con = DbUtil.getConnection();
            
            String sql = "select * from animaltype where anitype = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, anitype);
            
            rs = ps.executeQuery();
            while(rs.next()) {
                int anino = rs.getInt("anino");
                String anikinds = rs.getString("anikinds");
                
                AnimalTypeDTO dto = new AnimalTypeDTO(anino, anitype, anikinds);
                list.add(dto.getAnikinds());
            }
            String[] arr = list.toArray(new String[list.size()]);
           
            
            System.out.println("AnimalType 선택조회 결과 list.size : " + list.size() + ", 매개변수 type : " + anitype);
            
            return arr;
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
    }
}
