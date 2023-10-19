/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.semi.comments.model;

import com.semi.board.model.BoardService;
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
 * @author yes03
 */
public class CommentsDAO {
    //게시글 읽기 댓글+답글 조회
    public List<CommentsDTO> readComments(int bno) throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<CommentsDTO>list=new ArrayList<>();
        
        try{
            con=DbUtil.getConnection();
            String sql="select ' ',rownum, A.num, A.type, A.nickname, A.cobody, A.coregdate, A.cogood"
                      +" from"
                      +" ("
                      +" select ' ', c.cono, c.cono num,'   ' type, p.nickname, c.cobody, c.coregdate,c.cogood"
                      +" from board b right join comments c"
                      +" on b.bno =c.bno"
                      +" left join recomments r"
                      +" on c.cono=r.cono"
                      +" left join person p"
                      +" on c.personno=p.personno"
                      +" where c.bno= ?"
                      +" union"
                      +" select ' ',r.cono, r.recono,'답글 ▶▶▶', p.nickname,r.recobody,r.recoregdate,r.recogood"
                      +" from board b right join comments c"
                      +" on b.bno =c.bno"
                      +" right join recomments r"
                      +" on c.cono=r.cono"
                      +" left join person p"
                      +" on r.personno=p.personno"
                      +" where b.bno= ?"
                      +" order by cono, coregdate"
                      +" )A"
                      +" order by A.cono, A.coregdate";

            ps=con.prepareStatement(sql);
            ps.setInt(1, bno);
            ps.setInt(2, bno);
            rs=ps.executeQuery();
            while(rs.next()){
                String checkBox=rs.getString(1);
                int rownum=rs.getInt("rownum");
                int cono=rs.getInt(3);
                String type=rs.getString("type");
                String nickname=rs.getString(5);
                String cobody=rs.getString(6);
                Timestamp coregdate=rs.getTimestamp(7);
                int cogood=rs.getInt(8);
                CommentsDTO dto=new CommentsDTO(checkBox, rownum, cono, type, nickname, cobody, coregdate, cogood);
                list.add(dto);
            }
            System.out.println("게시판 내 댓글+답글 조회 결과, list의 크기="+list.size()+", 매개변수 bno="+bno);
            return list;
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
        
    }
    //댓글쓰기
    public int insertComment(CommentsDTO dto) throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        int cnt=0;
     
        try{
            con=DbUtil.getConnection();
            String sql="insert into comments(cono, cobody, bno, personno)"
                    + " values(comments_seq.nextval, ?, ?, ?)";
           
            ps=con.prepareStatement(sql);
            ps.setString(1, dto.getCobody());
            ps.setInt(2, BoardService.getBno());
            ps.setInt(3, dto.getPersonno());
            
            cnt=ps.executeUpdate();
            System.out.println("댓글 등록결과, cnt="+cnt+", 매개변수 dto="+dto);
            return cnt;
        }finally{
            DbUtil.dbClose(ps, con);
        }
    }
    
    //답글쓰기
    public int insertReComment(CommentsDTO dto) throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        int cnt=0;
     
        try{
            con=DbUtil.getConnection();
            String sql="insert into recomments(recono, recobody, cono, personno)"
                    + " values(recomments_seq.nextval, ?, ?, ?)";
           
            ps=con.prepareStatement(sql);
            ps.setString(1, dto.getCobody());
            ps.setInt(2, CommentsService.getCono());
            ps.setInt(3, dto.getPersonno());
            
            cnt=ps.executeUpdate();
            System.out.println("답글 등록결과, cnt="+cnt+", 매개변수 dto="+dto);
            return cnt;
        }finally{
            DbUtil.dbClose(ps, con);
        }
    }
    
    //댓글 자세히 읽기(댓+답 수정/삭제/좋아요를 위한 징검다리)
    public CommentsDTO detailReadCM(int no) throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        CommentsDTO dto=new CommentsDTO();
        
        try{
            con=DbUtil.getConnection();
            String sql="select c.cobody, p.nickname, c.cogood, c.coregdate"
                    + " from person p right join comments c"
                    + " on p.personno= c.personno "
                    + " where c.cono= ?";
            ps=con.prepareStatement(sql);
            ps.setInt(1, CommentsService.getCono());
            
            rs=ps.executeQuery();
            if(rs.next()){
                String cobody=rs.getString("cobody");
                String nickname=rs.getString("nickname");
                int cogood=rs.getInt("cogood");
                Timestamp coregdate =rs.getTimestamp("coregdate");

                dto=new CommentsDTO(cobody, nickname, cogood, coregdate);
            }
            System.out.println("댓글읽기 결과, dto="+dto+", 매개변수no="+no);
            return dto;
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
    }
    
     //답글 자세히 읽기(댓+답 수정/삭제/좋아요를 위한 징검다리)
    public CommentsDTO detailReadRCM(int no) throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        CommentsDTO dto=new CommentsDTO();
        
        try{
            con=DbUtil.getConnection();
            String sql="select r.recobody, p.nickname, r.recogood, r.recoregdate"
                    + " from person p right join recomments r"
                    + " on p.personno= r.personno "
                    + " where r.recono= ?";
            ps=con.prepareStatement(sql);
            ps.setInt(1, CommentsService.getCono());
            
            rs=ps.executeQuery();
            if(rs.next()){
                String recobody=rs.getString("recobody");
                String nickname=rs.getString("nickname");
                int recogood=rs.getInt("recogood");
                Timestamp recoregdate =rs.getTimestamp("recoregdate");

                dto=new CommentsDTO(recobody, nickname, recogood, recoregdate);
            }
            System.out.println("답글읽기 결과, dto="+dto+", 매개변수no="+no);
            return dto;
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
    }
    
    //댓글 삭제
    public int deleteCM(int no) throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        int cnt=0;
        
        try {
            con=DbUtil.getConnection();
            String sql="delete from comments where cono= ?";
            ps=con.prepareStatement(sql);
            ps.setInt(1, CommentsService.getCono());
            
            cnt=ps.executeUpdate();
            System.out.println("댓글 삭제결과, cnt="+cnt+", 매개변수 no="+no);
            return cnt;
        }finally {
            DbUtil.dbClose(ps, con);
        }
    }
    //댓글 수정
    public int UpdateCM(CommentsDTO dto) throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        int cnt=0;
        
        try{
            con=DbUtil.getConnection();
            String sql="update comments set cobody= ? where cono= ?";
            ps=con.prepareStatement(sql);
          
            ps.setString(1, dto.getCobody());
            ps.setInt(2, CommentsService.getCono());
            cnt=ps.executeUpdate();
            System.out.println("댓글 수정 결과, cnt="+cnt+", 매개변수 dto="+dto);
            return cnt;
        }finally{
            DbUtil.dbClose(ps, con);
        }
    }
    
    //답글 삭제
    public int deleteRCM(int no) throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        int cnt=0;
        
        try {
            con=DbUtil.getConnection();
            String sql="delete from recomments where recono= ?";
            ps=con.prepareStatement(sql);
            ps.setInt(1, CommentsService.getCono());
            
            cnt=ps.executeUpdate();
            System.out.println("답글 삭제결과, cnt="+cnt+", 매개변수 no="+no);
            return cnt;
        }finally {
            DbUtil.dbClose(ps, con);
        }
    }
    //댓글 수정
    public int UpdateRCM(CommentsDTO dto) throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        int cnt=0;
        
        try{
            con=DbUtil.getConnection();
            String sql="update recomments set recobody= ? where recono= ?";
            ps=con.prepareStatement(sql);
          
            ps.setString(1, dto.getCobody());
            ps.setInt(2, CommentsService.getCono());
            cnt=ps.executeUpdate();
            System.out.println("답글 수정 결과, cnt="+cnt+", 매개변수 dto="+dto);
            return cnt;
        }finally{
            DbUtil.dbClose(ps, con);
        }
    }
    
    //댓글 좋아요 
    public int UpdateCMGood(CommentsDTO dto) throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        int cnt=0;
        
        try{
            con=DbUtil.getConnection();
            String sql="update comments"
                       +" set cogood= cogood+1"
                       +" where cono= ?";
            ps=con.prepareStatement(sql);
            ps.setInt(1, CommentsService.getCono());
            cnt=ps.executeUpdate();
            System.out.println("댓글 좋아요 결과, cnt="+cnt+", 매개변수 dto="+dto);
            return cnt;
        }finally{
            DbUtil.dbClose(ps, con);
        }
    }
    
    //답글 좋아요 
    public int UpdateRCMGood(CommentsDTO dto) throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        int cnt=0;
        
        try{
            con=DbUtil.getConnection();
            String sql="update recomments"
                       +" set recogood= recogood+1"
                       +" where recono= ?";
            ps=con.prepareStatement(sql);
            ps.setInt(1, CommentsService.getCono());
            cnt=ps.executeUpdate();
            System.out.println("답글 좋아요 결과, cnt="+cnt+", 매개변수 dto="+dto);
            return cnt;
        }finally{
            DbUtil.dbClose(ps, con);
        }
    }
}
