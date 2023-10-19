
package com.semi.person.model;


import com.semi.db.DbUtil;
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

public class PersonDAO {
    public static final int LOGIN_OK=1;
    public static final int PWD_DISAGREE=2;
    public static final int USERID_NONE=3;
    
    public static final int USASBLE_NICK=4;
    public static final int UNUSASBLE_NICK=5;
    public static final int USASBLE_ID=6;
    public static final int UNUSASBLE_ID=7;

    public static final int USABLE_NICKNAME = 1;
    public static final int UNUSABLE_NICKNAME = 2;

    public int loginCheck(String id, String pwd) throws SQLException {
        Connection con =null;
        PreparedStatement ps = null;
        ResultSet rs =null;
        
        try{
            con=DbUtil.getConnection();
            
            String sql="select pwd from person where id=?";
            ps=con.prepareStatement(sql);
            
            ps.setString(1, id);
            
            rs=ps.executeQuery();
            
            int result=0;
            if(rs.next()){
                String dbPwd=rs.getString(1);
                
                if(dbPwd.equals(pwd)){
                    result=LOGIN_OK;
                }else {
                    result=PWD_DISAGREE;
                }
            }else {
                result=USERID_NONE;
            }
            
            return result;
            
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
    }
    
    public int insertPerson(PersonDTO dto) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = DbUtil.getConnection();
            
            String sql = "insert into person(personno, name, nickname, id, pwd, hp, email, birth, zipno, detailaddress, regdate, petno)"
                            + "values(member_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getName());
            ps.setString(2, dto.getNickname());
            ps.setString(3, dto.getId());
            ps.setString(4, dto.getPwd());
            ps.setString(5, dto.getHp());
            ps.setString(6, dto.getEmail());
            ps.setString(7, dto.getBirth());
            ps.setInt(8, dto.getZipno());
            ps.setString(9, dto.getDetailaddress());
            ps.setInt(10, dto.getPetno());
            
            int cnt = ps.executeUpdate();
            return cnt;
            
        }finally {
            DbUtil.dbClose(ps, con);
        }
    }

    public PersonDTO memberLoad(String id) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs =null;
        
        PersonDTO dto=new PersonDTO();
        
        try{
            con=DbUtil.getConnection();
            
            String sql="select personno, name, birth, pwd, email, nickname, detailaddress, zipno, hp from person where id=?";
            ps=con.prepareStatement(sql);
            
            ps.setString(1, id);
            
            rs=ps.executeQuery();
            if(rs.next()){
                int personno=rs.getInt(1);
                String name=rs.getString(2);
                String birth=rs.getString(3);
                String pwd=rs.getString(4);
                String email=rs.getString(5);
                String nickname=rs.getString(6);
                String detailress=rs.getString(7);
                int zipno=rs.getInt(8);
                String hp=rs.getString(9);
                
                dto=new PersonDTO(personno, name, birth, id, pwd, email, nickname, detailress, zipno, hp);
            }
            System.out.println("펄슨 정보 불러오기 dto="+dto+", 매개변수 id="+id);
            return dto;
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
    }
    //관리자
    public List<PersonDTO> personSelectAll() throws SQLException {
        Connection con =null;
        PreparedStatement ps =null;
        ResultSet rs =null;
        
        List<PersonDTO> listAll = new ArrayList<>();
        try{
            con=DbUtil.getConnection();
            
            String sql=" select p.personno, p.name, p.birth, p.hp, p.id, p.nickname, t.petname, p.email,"
                    + " p.zipno, p.detailaddress, p.point, p.regdate "
                    + " from person p left join pet t"
                    + " on p.personno=t.personno "
                    + " order by p.personno";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                int personno=rs.getInt(1);
                String name=rs.getString(2);
                String birth=rs.getString(3);
                String hp=rs.getString(4);
                String id=rs.getString(5);
                String nickname=rs.getString(6);
                String petname=rs.getString(7);
                String email=rs.getString(8);
                int zipno=rs.getInt(9);
                String detailaddress=rs.getString(10);
                int point=rs.getInt(11);
                Timestamp regdate=rs.getTimestamp(12);
                
                PersonDTO dto=new PersonDTO(personno, name, birth, hp, id, nickname, petname, email, zipno, detailaddress, point, regdate);
                listAll.add(dto);
            }
            System.out.println("모든 회원 불러오기 결과 list.size:"+listAll.size());
            return listAll;
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
    }

   public List<PersonDTO> personSelectByNo(int personno) throws SQLException {
        Connection con =null;
        PreparedStatement ps =null;
        ResultSet rs =null;

        List<PersonDTO> listNo = new ArrayList<>();

        try{
            con=DbUtil.getConnection();

            String sql=" select p.personno, p.name, p.birth, p.hp, p.id, p.nickname, t.petname, p.email,"
                    + " p.zipno, p.detailaddress, p.point, p.regdate"
                    + " from person p left join pet t"
                    + " on p.personno=t.personno"
                    + " where p.personno like '%' || ? ||'%' ";
            ps=con.prepareStatement(sql);

            ps.setInt(1, personno);

            rs=ps.executeQuery();
            while(rs.next()){
                int personno1=rs.getInt(1);
                String name=rs.getString(2);
                String birth=rs.getString(3);
                String hp=rs.getString(4);
                String id=rs.getString(5);
                String nickname=rs.getString(6);
                String petname=rs.getString(7);
                String email=rs.getString(8);
                int zipno=rs.getInt(9);
                String detailaddress=rs.getString(10);
                int point=rs.getInt(11);
                Timestamp regdate=rs.getTimestamp(12);
                
                PersonDTO dto=new PersonDTO(personno1, name, birth, hp, id, nickname, petname, email, zipno, detailaddress, point, regdate);

                listNo.add(dto);
            }
            System.out.println("번호로 회원 검색 결과 list.size="+listNo.size()+", 매개변수 personno="+personno);
            return listNo;
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
    }

    public List<PersonDTO> personSelectByName(String name) throws SQLException {
        Connection con =null;
        PreparedStatement ps =null;
        ResultSet rs =null;

        List<PersonDTO> list = new ArrayList<>();

        try{
            con=DbUtil.getConnection();

            String sql=" select p.personno, p.name, p.birth, p.hp, p.id, p.nickname, t.petname, p.email,"
                    + " p.zipno, p.detailaddress, p.point, p.regdate"
                    + " from person p left join pet t"
                    + " on p.personno=t.personno"
                    + " where p.name like '%' || ? ||'%' ";
            ps=con.prepareStatement(sql);
            
            ps.setString(1, name);

            rs=ps.executeQuery();
            while(rs.next()){
                int personno=rs.getInt(1);
                String name1=rs.getString(2);
                String birth=rs.getString(3);
                String hp=rs.getString(4);
                String id=rs.getString(5);
                String nickname=rs.getString(6);
                String petname=rs.getString(7);
                String email=rs.getString(8);
                int zipno=rs.getInt(9);
                String detailaddress=rs.getString(10);
                int point=rs.getInt(11);
                Timestamp regdate=rs.getTimestamp(12);
                
                PersonDTO dto=new PersonDTO(personno, name1, birth, hp, id, nickname, petname, email, zipno, detailaddress, point, regdate);
                list.add(dto);
            }
            System.out.println("관리자: 회원 이름 검색 결과 list.size()="+list.size()+", 매개변수 name="+name);
            return list;
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
    }

    public List<PersonDTO> personSelectById(String id) throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        List<PersonDTO> listId=new ArrayList<>();
        
        try {
            con=DbUtil.getConnection();
            
            String sql=" select p.personno, p.name, p.birth, p.hp, p.id, p.nickname, t.petname, p.email,"
                    + " p.zipno, p.detailaddress, p.point, p.regdate"
                    + " from person p left join pet t"
                    + " on p.personno=t.personno"
                    + " where p.id like '%' || ? ||'%' ";
            
            ps=con.prepareStatement(sql);
            ps.setString(1, id);
            
            rs=ps.executeQuery();
            while(rs.next()){
                int personno=rs.getInt("personno");
                String name=rs.getString("name");
                
                String hp=rs.getString("hp");
                String id1=rs.getString("id");
                String nickname=rs.getString("nickname");
                String petname=rs.getString("petname");
                String email=rs.getString("email");
                int zipno=rs.getInt("zipno");
                String detailaddress=rs.getString("detailaddress");
                int point=rs.getInt("point");
                Timestamp regdate=rs.getTimestamp("regdate");
                
                PersonDTO dto=new PersonDTO(personno, name, id1, hp, id, nickname, petname, email, zipno, detailaddress, point, regdate);
                listId.add(dto);
            }
            
            return listId;
        } finally {
            DbUtil.dbClose(rs, ps, con);
        }
     }
    
    public int delPerByNo(int personno) throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        
        try {
            con=DbUtil.getConnection();
            
           String sql="delete from person where personno=? ";
           ps=con.prepareStatement(sql);
           ps.setInt(1, personno);
           
           int cnt=ps.executeUpdate();
           System.out.println("회원 삭제 결과:"+cnt);
           return cnt;
       } finally {
           DbUtil.dbClose(ps, con);
       }
    }

 public int nickChecked(String nickname) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        int result = 0;
        try {
            //1,2
            con = DbUtil.getConnection();
            
            //3
            String sql = "select count(*) from member where userid = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, nickname);
            
            //4
            rs = ps.executeQuery();
            if(rs.next()) {
                int count = rs.getInt(1);
                if(count>0) { 
                    result = UNUSASBLE_ID;
                }else { 
                    result = USASBLE_ID;
                }
            }
            System.out.println("아이디 중복확인 결과 result = " + result + ", 매개변수 userid = " + nickname);
            return result;
        }finally {
            DbUtil.dbClose(rs, ps, con);
        }
    }

    public int idChecked(String userid) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        int result = 0;
        try {
            //1,2
            con = DbUtil.getConnection();
            
            //3
            String sql = "select count(*) from member where userid = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, userid);
            
            //4
            rs = ps.executeQuery();
            if(rs.next()) {
                int count = rs.getInt(1);
                if(count>0) { 
                    result = UNUSASBLE_ID;
                }else { 
                    result = USASBLE_ID;
                }
            }
            System.out.println("아이디 중복확인 결과 result = " + result + ", 매개변수 userid = " + userid);
            return result;
        }finally {
            DbUtil.dbClose(rs, ps, con);
        }
    }

    public PersonDTO selectById(String id) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        PersonDTO dto = new PersonDTO();
        
        try{
            con = DbUtil.getConnection();
            
            String sql = "select * from person where id = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            
            rs = ps.executeQuery();
            if(rs.next()){
                int personno = rs.getInt("personno");
                String name = rs.getString("name");
                String birth = rs.getString("birth");
                String nickname = rs.getString("nickname");
                String pwd = rs.getString("pwd");
                String email = rs.getString("email");
                String detailaddress = rs.getString("detailaddress");
                int point = rs.getInt("point");
                Timestamp regdate = rs.getTimestamp("regdate");
                String zipno = rs.getString("zipno");
                String hp = rs.getString("hp");
                
                dto.setPersonno(personno);
                dto.setName(name);
                dto.setBirth(birth);
                dto.setId(id);
                dto.setPwd(pwd);
                dto.setEmail(email);
                dto.setNickname(nickname);
                dto.setDetailaddress(detailaddress);
                dto.setPoint(point);
                dto.setRegdate(regdate);
                dto.setZipno(Integer.parseInt(zipno));
                dto.setHp(hp);
            }
            
            System.out.println("회원조회 결과: " + dto + ", 매개변수 id : " + id);
            
            return dto;
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
    }

    
    public PersonDTO selectById(String id , String hp) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        PersonDTO dto = new PersonDTO();
        
        try{
            con = DbUtil.getConnection();
            
            String sql = "select * from person where id = ? and hp=? ";
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, hp);
            
            rs = ps.executeQuery();
            if(rs.next()){
                int personno = rs.getInt("personno");
                String name = rs.getString("name");
                String birth = rs.getString("birth");
                String nickname = rs.getString("nickname");
                String pwd = rs.getString("pwd");
                String email = rs.getString("email");
                String detailaddress = rs.getString("detailaddress");
                int point = rs.getInt("point");
                Timestamp regdate = rs.getTimestamp("regdate");
                String zipno = rs.getString("zipno");
                String hp2 = rs.getString("hp");
                
                dto.setPersonno(personno);
                dto.setName(name);
                dto.setBirth(birth);
                dto.setId(id);
                dto.setPwd(pwd);
                dto.setEmail(email);
                dto.setNickname(nickname);
                dto.setDetailaddress(detailaddress);
                dto.setPoint(point);
                dto.setRegdate(regdate);
                dto.setZipno(Integer.parseInt(zipno));
                dto.setHp(hp2);
            }
            
            System.out.println("회원조회 결과: " + dto + ", 매개변수 id : " + id);
            
            return dto;
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
    }

    public String selectByPwd(String id, String hp) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String pwd="";
        try{
            con= DbUtil.getConnection();
            
            String sql="select pwd from person where id=? and hp=?";
            ps=con.prepareStatement(sql);
            
            ps.setString(1, id);
            ps.setString(2, hp);
            
            rs=ps.executeQuery();
            if(rs.next()){
                pwd=rs.getString(1);
            }
            
            System.out.println("비밀번호 찾기 결과 pwd="+pwd+"매개변수 id="+id+", hp="+hp);
            return pwd;
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
    }

    public String selectById2(String name, String hp) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        con=DbUtil.getConnection();
        String id="";
        String sql="select id from person where name=? and hp=?";
        ps=con.prepareStatement(sql);
        
        ps.setString(1, name);
        ps.setString(2, hp);
        
        rs=ps.executeQuery();
        if(rs.next()){
            id=rs.getString(1);
            
        }
        System.out.println("아이디 찾기 결과 id="+id+", 매개변수 name="+name+", hp="+hp);
        return id;
        
    }

    public int checkNickname(String nickname) throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
              
        int result=0;
        try{
            con=DbUtil.getConnection();
            
            String sql="select count(*) from person where nickname=?";            
            ps=con.prepareStatement(sql);
            ps.setString(1, nickname);
            
            rs=ps.executeQuery();
            if(rs.next()){
                int count=rs.getInt(1);
                if(count>0){
                    result=UNUSABLE_NICKNAME;
                }else{
                    result=USABLE_NICKNAME;                    
                }
            }
            System.out.println("아이디 중복확인 결과 result="+result+", 매개변수 Nickname="+nickname);
            
            return result;
            
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }        
    }
    
    public int updatePerson(PersonDTO dto) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = DbUtil.getConnection();
            
            String sql = "update person set pwd = ?, email = ?, hp = ?, birth = ?, nickname = ?, zipno = ?, detailaddress = ? where personno = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, dto.getPwd());
            ps.setString(2, dto.getEmail());
            ps.setString(3, dto.getHp());
            ps.setString(4, dto.getBirth());
            ps.setString(5, dto.getNickname());
            ps.setInt(6, dto.getZipno());
            ps.setString(7, dto.getDetailaddress());
            ps.setInt(8, dto.getPersonno());
            
            int cnt = ps.executeUpdate();
            
            System.out.println("회원 정보 수정 결과, cnt = " + cnt+", 매개변수 dto = " + dto);
            
            return cnt;
            
        }finally{
            DbUtil.dbClose(ps, con);
        }
    }
    

}
