package com.semi.pet.model;

import com.semi.db.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


public class PetDAO {
    public List<PetDTO> selectByPersonNo(int personno) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        
        List<PetDTO> list = new ArrayList<>();
        try{
            con = DbUtil.getConnection();
            
            String sql = "select * from pet where personno = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, personno);
            
            rs = ps.executeQuery();
            while(rs.next()){
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
                
                PetDTO dto = new PetDTO(petno, petname, petbirth, gender, weight, neut, feed, allergy, petregdate, anino, personno);
                
                list.add(dto);
            }
            
            System.out.println("펫 선택조회 결과 list.size : " + list.size() + ", 매개변수 personno : " + personno);
            
            return list;
            
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
    }

    public int insertPet(PetDTO dto) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = DbUtil.getConnection();
            
            String sql = "insert into pet(petname, petbirth, gender, weight, neut, feed, allergy, anino, personno)"
                    + " values (?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getPetname());
            ps.setString(2, dto.getPetbirth());
            ps.setString(3, dto.getGender());
            ps.setDouble(4, dto.getWeight());
            ps.setString(5, dto.getNeut());
            ps.setString(6, dto.getFeed());
            ps.setString(7, dto.getAllergy());
            ps.setInt(8, dto.getAnino());
            ps.setInt(9, dto.getPersonno());
            
            int cnt = ps.executeUpdate();
            
            System.out.println("펫 등록 결과, cnt = "+cnt+", 매개변수 dto = "+dto);
            
            return cnt;
            
        }finally{
            DbUtil.dbClose(ps, con);
        }
    }
    
    public int updatePet(PetDTO dto) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = DbUtil.getConnection();
            
            String sql = "update pet set petname = ?, petbirth = ?, gender = ?, weight = ?, neut = ?, feed = ?, allergy = ?"
                    + " where petno = ?";
            
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getPetname());
            ps.setString(2, dto.getPetbirth());
            ps.setString(3, dto.getGender());
            ps.setDouble(4, dto.getWeight());
            ps.setString(5, dto.getNeut());
            ps.setString(6, dto.getFeed());
            ps.setString(7, dto.getAllergy());
            ps.setInt(8, dto.getPetno());
            
            int cnt = ps.executeUpdate();
            
            System.out.println("펫 정보 수정 결과, cnt = " + cnt+", 매개변수 dto = " + dto);
            
            return cnt;
        }finally{
            DbUtil.dbClose(ps, con);
        }
    }
    
    public int deletePet(int petno) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = DbUtil.getConnection();
            
            String sql = "delete from pet where petno = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, petno);
            
            int cnt = ps.executeUpdate();
            
            System.out.println("펫 삭제 결과, cnt = " + cnt+", 매개변수 petno = " + petno);
            
            return cnt;
        }finally{
            DbUtil.dbClose(ps, con);
        }
    }
    
    public List<String> aniselect(String anitype) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs =null;
        
        List<String> list = new ArrayList<>();
        
        try{
            con = DbUtil.getConnection();
            
            String sql = "select anikinds from animaltype where anitype = ?";
            ps = con.prepareStatement(sql);
            
            ps.setString(1, anitype);
            
            rs=ps.executeQuery();
            while(rs.next()){
                String anikinds = rs.getString("anikinds");
                
                list.add(anikinds);
            }
            return list;
        }finally {
            DbUtil.dbClose(rs, ps, con);
        }
    }

    public PetDTO selectByPetno(int petno) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        PetDTO dto = new PetDTO();
        try{
            con = DbUtil.getConnection();
            
            String sql = "select * from pet where petno = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, petno);
            
            rs = ps.executeQuery();
            if(rs.next()) {
                String petname = rs.getString("petname");
                String petbirth = rs.getString("petbirth");
                String gender = rs.getString("gender");
                double weight = Double.parseDouble(rs.getString("weight"));
                String neut = rs.getString("neut");
                String feed = rs.getString("feed");
                String allergy = rs.getString("allergy");
                Timestamp petregdate = rs.getTimestamp("petregdate");
                int anino = rs.getInt("anino");
                int personno = rs.getInt("personno");
                
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
                
            }
            
            System.out.println("애완동물 조회 결과: " + dto + ", 매개변수 petno : " + petno);
            
            return dto;
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
    }
}
