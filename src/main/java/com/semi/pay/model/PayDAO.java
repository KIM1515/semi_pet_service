/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semi.pay.model;

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
public class PayDAO {

    public PayDTO payLoad(String id) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        PayDTO dto=null;
        try{
            con=DbUtil.getConnection();
            
            String sql="select a.cardno, a.cardcom, a.cvc, a.paypassword, a.expiration" +
                " from pay a join person b" +
                " on a.personno=b.personno" +
                " where b.id= ?" +
                " order by a.payno desc";
            ps=con.prepareStatement(sql);
            
            ps.setString(1, id);
            
            rs=ps.executeQuery();
            if(rs.next()){
                String cardNo=rs.getString(1);
                String cardCom=rs.getString(2);
                String cvc=rs.getString(3);
                String payPwd=rs.getString(4);
                String expiration=rs.getString(5);
                
                dto=new PayDTO(cardCom, cardNo, cvc, payPwd, expiration);
            }
            System.out.println("카드정보 결과 dto="+dto+"매개변수 id="+id);
            return dto;
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
    }

    public int insertCard(PayDTO dto) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con=DbUtil.getConnection();
            
            String sql="insert into pay(payno,cardcom,cardno,cvc,personno,cardpassword,expiration,paypassword)" +
                " values(pay_seq.nextval,?,?,?,?,?,?,?)";
            ps=con.prepareStatement(sql);
            
            ps.setString(1, dto.getCardcom());
            ps.setString(2, dto.getCardno());
            ps.setString(3, dto.getCvc());
            ps.setInt(4, dto.getPersonno());
            ps.setString(5, dto.getCardpassword());
            ps.setString(6, dto.getExpiration());
            ps.setString(7, dto.getPaypassword());
            
            int cnt=ps.executeUpdate();
            
            System.out.println("카드등록 결과 cnt="+cnt+", 매개변수 dto="+dto);
            return cnt;
            
        }finally{
            DbUtil.dbClose(ps, con);
        }
        
    }

    public String findPwd(String cardNo) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String payPwd="";
        try{
            con=DbUtil.getConnection();
            
            String sql="select paypassword" +
                " from pay where cardno= ?";
            ps=con.prepareStatement(sql);
            
            ps.setString(1, cardNo);
            
            rs=ps.executeQuery();
            if(rs.next()){
                payPwd=rs.getString(1);
                
            }
            System.out.println("카드 결제 비밀번호 결과 payPwd="+payPwd+"매개변수 cardNo="+cardNo);
            return payPwd;
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
    }

    public List<PayDTO> selectByPersonno(int personno) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        List<PayDTO> list = new ArrayList<>();
        try{
            con = DbUtil.getConnection();
            
            String sql = "select rownum, payno, cardcom, cardno, paypassword, expiration from pay where personno = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, personno);
            
            rs = ps.executeQuery();
            while(rs.next()){
                int rownum = rs.getInt("rownum");
                int payno = rs.getInt("payno");
                String cardcom = rs.getString("cardcom");
                String cardno = rs.getString("cardno");
                String paypassword = rs.getString("paypassword");
                String expiration = rs.getString("expiration");
                
                PayDTO dto = new PayDTO(rownum, payno, cardcom, cardno, paypassword, expiration);
                
                list.add(dto);
            }
            
            System.out.println("카드 선택조회 결과 list.size : " + list.size() + ", 매개변수 personno : " + personno);
            
            return list;
            
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
        
    }
   
    public int updatePay(String paypassword, int personno) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = DbUtil.getConnection();
            
            String sql = "update pay set paypassword = ? where personno = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, paypassword);
            ps.setInt(2, personno);
            
            int cnt = ps.executeUpdate();
            
            System.out.println("결제번호 수정 결과, cnt = " + cnt+", 매개변수 personno = " + personno);
            
            return cnt;
            
        }finally{
            DbUtil.dbClose(ps, con);
        }
    }
    
    public int deletePay(String cardno) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = DbUtil.getConnection();
            
            String sql = "delete from pay where cardno = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, cardno);
            
            int cnt = ps.executeUpdate();
            
            System.out.println("카드 삭제 결과, cnt = " + cnt+", 매개변수 cardno = " + cardno);
            
            return cnt;
            
        }finally{
            DbUtil.dbClose(ps, con);
        }
    }
    
    public int insertPay(PayDTO dto) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            con = DbUtil.getConnection();
            
            String sql = "insert into pay(cardcom, cardno, cvc, personno, cardpassword, paypassword, expiration) "
                    + "values(?,?,?,?,?,?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1, dto.getCardcom());
            ps.setString(2, dto.getCardno());
            ps.setString(3, dto.getCvc());
            ps.setInt(4, dto.getPersonno());
            ps.setString(5, dto.getCardpassword());
            ps.setString(6, dto.getPaypassword());
            ps.setString(7, dto.getExpiration());
            
            int cnt = ps.executeUpdate();
            
             System.out.println("카드 등록 결과, cnt = "+cnt+", 매개변수 dto = "+dto);
             
             return cnt;
            
        }finally{
            DbUtil.dbClose(ps, con);
        }
    }
    
}
