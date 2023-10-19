
package com.semi.pet_animaltype_view.model;

import com.semi.db.DbUtil;
import com.semi.pet.model.PetDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Pet_animaltype_ViewDAO {
    public List<Pet_animaltype_ViewDTO> selectByPersonNo(int personno) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<Pet_animaltype_ViewDTO> list = new ArrayList<>();
        try{
            con = DbUtil.getConnection();
            
            String sql = "select * from pet_animaltype where personno = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, personno);
            
            rs = ps.executeQuery();
            while(rs.next()) {
                int petno = rs.getInt("petno");
                String petname = rs.getString("petname");
                String petbirth = rs.getString("petbirth");
                String gender = rs.getString("gender");
                double weight = rs.getDouble("weight");
                String neut = rs.getString("neut");
                String feed = rs.getString("feed");
                String allergy = rs.getString("allergy");
                Timestamp petregdate = rs.getTimestamp("petregdate");
                int anino = rs.getInt("anino");
                String anitype = rs.getString("anitype");
                String anikinds = rs.getString("anikinds");
                
                Pet_animaltype_ViewDTO dto = new Pet_animaltype_ViewDTO(petno, petname, petbirth, gender, weight, neut, feed, allergy, petregdate, anino, personno, anitype, anikinds);
                
                list.add(dto);
                
            }
            
            System.out.println("view 선택 조회 결과, list.size = " + list.size() + ", 매개변수 personno = " + personno);
            return list;
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
    }
    
    public Pet_animaltype_ViewDTO selectByPetNo(int petno) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Pet_animaltype_ViewDTO dto = new Pet_animaltype_ViewDTO();
        try{
            con = DbUtil.getConnection();
            
            String sql = "select * from pet_animaltype where petno = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, petno);
            
            rs = ps.executeQuery();
            while(rs.next()) {
                String petname = rs.getString("petname");
                String petbirth = rs.getString("petbirth");
                String gender = rs.getString("gender");
                double weight = rs.getDouble("weight");
                String neut = rs.getString("neut");
                String feed = rs.getString("feed");
                String allergy = rs.getString("allergy");
                Timestamp petregdate = rs.getTimestamp("petregdate");
                int anino = rs.getInt("anino");
                int personno = rs.getInt("personno");
                String anitype = rs.getString("anitype");
                String anikinds = rs.getString("anikinds");
                
                dto.setPetno(petno);
                dto.setPetname(petname);
                dto.setPetbirth(petbirth);
                dto.setGender(gender);
                dto.setWeight(weight);
                dto.setNeut(neut);
                dto.setFeed(feed);
                dto.setAllergy(allergy);
                dto.setPetregdate(petregdate);
                dto.setAnino(anino);
                dto.setPersonno(personno);
                dto.setAnitype(anitype);
                dto.setAnikinds(anikinds);
            }
            
            System.out.println("view 선택 조회 결과, dto = " + dto + ", 매개변수 petno = " + petno);
            
            return dto;
            
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
    }
}
