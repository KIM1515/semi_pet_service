/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package com.semi.board.model;

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
 * @author yes03
 */
public class BoardDAO {
    //육아톡톡 전체조회
    public List<BoardDTO> selPrentingAll() throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<BoardDTO>list=new ArrayList<>();
        
        try{
            con=DbUtil.getConnection();
            String sql="select b.bno, b.btitle, p.nickname, b.bregdate, "
                    + " b.bviewcnt, b.bgood "
                    + " from person p right join board b "
                    + " on p.personno= b.personno "
                    + " where b.bcategory1='육아톡톡'"
                    + " order by b.bregdate desc";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                int bno=rs.getInt("bno");
                String btitle=rs.getString("btitle");
                String nickname=rs.getString("nickname");
                Timestamp bregdate=rs.getTimestamp("bregdate");
                int bviewcnt=rs.getInt("bviewcnt");
                int bgood=rs.getInt("bgood");
                BoardDTO dto=new BoardDTO(bno, btitle, nickname, bregdate, bviewcnt, bgood);
                list.add(dto);
            }
            System.out.println("육아톡톡 조회결과, list의 크기="+list.size());
            return list;
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
    }
    
    //수다방 전체조회
    public List<BoardDTO> selFreeBoardAll() throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<BoardDTO>list=new ArrayList<>();
        
        try{
            con=DbUtil.getConnection();
            String sql="select b.bno, b.btitle, p.nickname, b.bregdate, "
                    + " b.bviewcnt, b.bgood "
                    + " from person p right join board b "
                    + " on p.personno= b.personno "
                    + " where b.bcategory1='수다방'"
                    + " order by b.bregdate desc";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                int bno=rs.getInt("bno");
                String btitle=rs.getString("btitle");
                String nickname=rs.getString("nickname");
                Timestamp bregdate=rs.getTimestamp("bregdate");
                int bviewcnt=rs.getInt("bviewcnt");
                int bgood=rs.getInt("bgood");
                BoardDTO dto=new BoardDTO(bno, btitle, nickname, bregdate, bviewcnt, bgood);
                list.add(dto);
            }
            System.out.println("수다방 조회결과, list의 크기="+list.size());
            return list;
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
    }
    //글읽기
    public BoardDTO readBoard(int bno) throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        BoardDTO dto=new BoardDTO();
        
        try{
            con=DbUtil.getConnection();
            String sql="select b.bcategory1, b.bcategory2, b.bcategory3, b.btitle, "
                    + " b.bbody, p.nickname, b.bregdate, b.bviewcnt, b.bgood "
                    + " from person p right join board b "
                    + " on p.personno= b.personno "
                    + " where b.bno= ? ";
            ps=con.prepareStatement(sql);
            ps.setInt(1, bno);
            
            rs=ps.executeQuery();
            if(rs.next()){
                String bcategory1=rs.getString("bcategory1");
                String bcategory2=rs.getString("bcategory2");
                String bcategory3=rs.getString("bcategory3");
                String btitle=rs.getString("btitle");
                String nickname=rs.getString("nickname");
                Timestamp bregdate=rs.getTimestamp("bregdate");
                int bviewcnt=rs.getInt("bviewcnt");
                int bgood=rs.getInt("bgood");
                String bbody=rs.getString("bbody");
                
                dto=new BoardDTO(bcategory1, bcategory2, bcategory3, btitle,
                        nickname, bregdate, bviewcnt, bgood, bbody);
            }
            System.out.println("글읽기 결과, dto="+dto+", 매개변수 bno="+bno);
            return dto;
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
    }
    //메인 최신글 20건 조회
    public List<ViewDTO> bdSelectTop20() throws SQLException {
        Connection con =null;
        PreparedStatement ps =null;
        ResultSet rs =null;
        
        List<ViewDTO> list =new ArrayList<>();
        
        try{
            con=DbUtil.getConnection();
            
            String sql="select bno, bcategory1, bcategory3, btitle, a.nickname, bregdate, bviewcnt" +
                    " from(" +
                    "    select bno, bcategory1, bcategory3, btitle," +
                    "    (select nickname from person p where p.personno=b.personno) nickname ,bregdate, bviewcnt" +
                    "    from board b order by bregdate desc" +
                    " )a" +
                    " where rownum<=20" +
                    " order by bregdate desc";
            ps=con.prepareStatement(sql);
            
            rs=ps.executeQuery();
            while(rs.next()){
                int bno=rs.getInt(1);
                String bcategory1=rs.getString(2);
                String bcategory3=rs.getString(3);
                String btitle=rs.getString(4);
                String id=rs.getString(5);
                Timestamp bregdate=rs.getTimestamp(6);
                int bviewcnt=rs.getInt(7);
                
                ViewDTO dto = new ViewDTO(bno,bcategory1, bcategory3, btitle, id, bregdate, bviewcnt);
                
                list.add(dto);
            }
            return list;
            
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
    }
    //제목으로 검색
    public List<BoardDTO> selectTitle(String search) throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<BoardDTO> list=new ArrayList<>();
        try{
            con=DbUtil.getConnection();
            String sql="select b.bno, b.bcategory1, b.btitle, b.bbody, p.nickname, b.bregdate"
                    +" from board b left join person p"
                    +" on b.personno = p.personno"
                    +" where b.btitle like '%'|| ? ||'%'"
                    + " order by b.bno desc";
            ps=con.prepareStatement(sql);
            ps.setString(1, search);
            rs=ps.executeQuery();
            while(rs.next()){
                int bno=rs.getInt("bno");
                String bcategory1=rs.getString("bcategory1");
                String btitle=rs.getString("btitle");
                String bbody=rs.getString("bbody");
                String nickname=rs.getString("nickname");
                Timestamp bregdate=rs.getTimestamp("bregdate");
                
                BoardDTO dto=new BoardDTO(bno, bcategory1, btitle, bbody, nickname, bregdate);
                list.add(dto);
            }
            System.out.println("제목으로 검색결과, list의 크기="+list.size()+", 매개변수 search="+search);
            return list;
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
    }
    
    //작성자로 검색
    public List<BoardDTO> selectNickname(String search) throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<BoardDTO> list=new ArrayList<>();
        try{
            con=DbUtil.getConnection();
            String sql="select b.bno, b.bcategory1, b.btitle, b.bbody, p.nickname, b.bregdate"
                    +" from board b left join person p"
                    +" on b.personno = p.personno"
                    +" where p.nickname like '%'|| ? ||'%'"
                    +" order by b.bno desc";
            ps=con.prepareStatement(sql);
            ps.setString(1, search);
            rs=ps.executeQuery();
            while(rs.next()){
                int bno=rs.getInt("bno");
                String bcategory1=rs.getString("bcategory1");
                String btitle=rs.getString("btitle");
                String bbody=rs.getString("bbody");
                String nickname=rs.getString("nickname");
                Timestamp bregdate=rs.getTimestamp("bregdate");
                
                BoardDTO dto=new BoardDTO(bno, bcategory1, btitle, bbody, nickname, bregdate);
                list.add(dto);
            }
            System.out.println("작성자 닉네임으로 검색결과, list의 크기="+list.size()+", 매개변수 search="+search);
            return list;
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
    }
    
    //내용으로 검색
    public List<BoardDTO> selectBody(String search) throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<BoardDTO> list=new ArrayList<>();
        try{
            con=DbUtil.getConnection();
            String sql="select b.bno, b.bcategory1, b.btitle, b.bbody, p.nickname, b.bregdate"
                    +" from board b left join person p"
                    +" on b.personno = p.personno"
                    +" where b.bbody like '%'|| ? ||'%'"
                    +" order by b.bno desc";
            ps=con.prepareStatement(sql);
            ps.setString(1, search);
            rs=ps.executeQuery();
            while(rs.next()){
                int bno=rs.getInt("bno");
                String bcategory1=rs.getString("bcategory1");
                String btitle=rs.getString("btitle");
                String bbody=rs.getString("bbody");
                String nickname=rs.getString("nickname");
                Timestamp bregdate=rs.getTimestamp("bregdate");
                
                BoardDTO dto=new BoardDTO(bno, bcategory1, btitle, bbody, nickname, bregdate);
                list.add(dto);
            }
            System.out.println("내용으로 검색결과, list의 크기="+list.size()+", 매개변수 search="+search);
            return list;
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
    }
    //강아지글 검색
    public List<BoardDTO> selectDog() throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<BoardDTO> list=new ArrayList<>();
        try{
            con=DbUtil.getConnection();
            String sql="select b.bno, b.bcategory1, b.btitle, b.bbody, p.nickname, b.bregdate"
                    +" from board b left join person p"
                    +" on b.personno = p.personno"
                    +" where b.bcategory3='강아지'"
                    +" order by b.bno desc";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                int bno=rs.getInt("bno");
                String bcategory1=rs.getString("bcategory1");
                String btitle=rs.getString("btitle");
                String bbody=rs.getString("bbody");
                String nickname=rs.getString("nickname");
                Timestamp bregdate=rs.getTimestamp("bregdate");
                
                BoardDTO dto=new BoardDTO(bno, bcategory1, btitle, bbody, nickname, bregdate);
                list.add(dto);
            }
            System.out.println("강아지관련 전체 검색결과, list의 크기="+list.size());
            return list;
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
    }
    //고양이글 검색
    public List<BoardDTO> selectCat() throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<BoardDTO> list=new ArrayList<>();
        try{
            con=DbUtil.getConnection();
            String sql="select b.bno, b.bcategory1, b.btitle, b.bbody, p.nickname, b.bregdate"
                    +" from board b left join person p"
                    +" on b.personno = p.personno"
                    +" where b.bcategory3='고양이'"
                    +" order by b.bno desc";
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                int bno=rs.getInt("bno");
                String bcategory1=rs.getString("bcategory1");
                String btitle=rs.getString("btitle");
                String bbody=rs.getString("bbody");
                String nickname=rs.getString("nickname");
                Timestamp bregdate=rs.getTimestamp("bregdate");
                
                BoardDTO dto=new BoardDTO(bno, bcategory1, btitle, bbody, nickname, bregdate);
                list.add(dto);
            }
            System.out.println("고양이관련 전체 검색결과, list의 크기="+list.size());
            return list;
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
    }
    //게시글 쓰기
    public int insertBoard(BoardDTO dto) throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        int cnt=0;
     
        try{
            con=DbUtil.getConnection();
            String sql="insert into board(bno, bcategory1, bcategory2, bcategory3, btitle, bbody, personno)"
                    + " values(board_seq.nextval, ?, ?, ?, ?, ?, ?)";
           
            ps=con.prepareStatement(sql);
            ps.setString(1, dto.getBcategory1());
            ps.setString(2, dto.getBcategory2());
            ps.setString(3, dto.getBcategory3());
            ps.setString(4, dto.getBtitle());
            ps.setString(5, dto.getBbody());
            ps.setInt(6, dto.getPersonno());
            
            cnt=ps.executeUpdate();
            System.out.println("게시글 등록결과, cnt="+cnt+", 매개변수 dto="+dto);
            return cnt;
        }finally{
            DbUtil.dbClose(ps, con);
        }
    }
    //게시글 삭제
    public int deleteBoard(int bno) throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        int cnt=0;
        
        try {
            con=DbUtil.getConnection();
            String sql="delete from board where bno= ?";
            ps=con.prepareStatement(sql);
            ps.setInt(1, bno);
            
            cnt=ps.executeUpdate();
            System.out.println("게시글 삭제결과, cnt="+cnt+", 매개변수 bno="+bno);
            return cnt;
        }finally {
            DbUtil.dbClose(ps, con);
        }
    }
    //게시글 수정
    public int UpdateBoard(BoardDTO dto) throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        int cnt=0;
        
        try{
            con=DbUtil.getConnection();
            String sql="update board"
                       +" set bcategory1= ?, bcategory2= ?, bcategory3= ?, btitle= ?, bbody= ?"
                       +" where bno= ?";
            ps=con.prepareStatement(sql);
            ps.setString(1, dto.getBcategory1());
            ps.setString(2, dto.getBcategory2());
            ps.setString(3, dto.getBcategory3());
            ps.setString(4, dto.getBtitle());
            ps.setString(5, dto.getBbody());
            ps.setInt(6, BoardService.getBno());
            cnt=ps.executeUpdate();
            System.out.println("게시글 수정 결과, cnt="+cnt+", 매개변수 dto="+dto);
            return cnt;
        }finally{
            DbUtil.dbClose(ps, con);
        }
    }
    //육아톡톡 하위 종류글 검색
    public List<BoardDTO> SelPrentingType() throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<BoardDTO> list=new ArrayList<>();
        try{
            con=DbUtil.getConnection();
            String sql="select b.bno, b.bcategory2, b.btitle, b.bbody, p.nickname, b.bregdate"
                       +" from board b left join person p"
                       +" on b.personno = p.personno"
                       +" where b.bcategory2= ?"
                       +" order by b.bno desc";
            ps=con.prepareStatement(sql);
            ps.setString(1, BoardService.getBcategory2());
            rs=ps.executeQuery();
            while(rs.next()){
                int bno=rs.getInt("bno");
                String bcategory2=rs.getString("bcategory2");
                String btitle=rs.getString("btitle");
                String bbody=rs.getString("bbody");
                String nickname=rs.getString("nickname");
                Timestamp bregdate=rs.getTimestamp("bregdate");
                
                BoardDTO dto=new BoardDTO(bno, bcategory2, btitle, bbody, nickname, bregdate);
                list.add(dto);
            }
            System.out.println("육아톡톡 하위 종류 검색결과, list의 크기="+list.size());
            return list;
        }finally{
            DbUtil.dbClose(rs, ps, con);
        }
    }
    //게시글 좋아요 
    public int UpdateBGood(BoardDTO dto) throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        int cnt=0;
        
        try{
            con=DbUtil.getConnection();
            String sql="update board"
                       +" set bgood= bgood+1"
                       +" where bno= ?";
            ps=con.prepareStatement(sql);
            ps.setInt(1, BoardService.getBno());
            cnt=ps.executeUpdate();
            System.out.println("게시글 좋아요 결과, cnt="+cnt+", 매개변수 dto="+dto);
            return cnt;
        }finally{
            DbUtil.dbClose(ps, con);
        }
    }
  
    public int UpdateVCnt(BoardDTO dto) throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        int cnt=0;
        
        try{
            con=DbUtil.getConnection();
            String sql="update board"
                       +" set bviewcnt= bviewcnt+1"
                       +" where bno= ?";
            ps=con.prepareStatement(sql);
            ps.setInt(1, BoardService.getBno());
            cnt=ps.executeUpdate();
            System.out.println("게시글 조회수 증가결과, cnt="+cnt+", 매개변수 dto="+dto);
            return cnt;
        }finally{
            DbUtil.dbClose(ps, con);
        }
    }
    
    //관리자
    //게시판 전체 조회
    public List<BoardDTO> boardSelectAll() throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        List<BoardDTO> listAll=new ArrayList<>();
        try {
            con=DbUtil.getConnection();
            
            String sql="select b.bno, b.bcategory1, b.btitle, p.nickname, b.bregdate, "
                    + " b.bviewcnt, b.bgood "
                    + " from person p right join board b "
                    + " on p.personno= b.personno "
                    + " order by b.bno";
            ps=con.prepareStatement(sql);
            
            rs=ps.executeQuery();
            while(rs.next()){
                int bno=rs.getInt("bno");
                String bcategory=rs.getString("bcategory1");
                String btitle=rs.getString("btitle");
                String nickname=rs.getString("nickname");
                 Timestamp bregdate=rs.getTimestamp("bregdate");
                int bviewcnt=rs.getInt("bviewcnt");
                int bgood=rs.getInt("bgood");
                BoardDTO dto=new BoardDTO(bno, bcategory, btitle, nickname, bregdate, bviewcnt, bgood);
                listAll.add(dto);
            }
            System.out.println("게시판 전체조회, listAll의 크기="+listAll.size());
            return listAll;
        } finally {
            DbUtil.dbClose(rs, ps, con);
        }
    }
    
    //번호조회
     public List<BoardDTO> boardSelectByNo(int bno) throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        List<BoardDTO> listNo=new ArrayList<>();
        try {
            con=DbUtil.getConnection();
            
            String sql="select b.bno, b.bcategory1, b.btitle, p.nickname, b.bregdate, "
                    + " b.bviewcnt, b.bgood "
                    + " from board b join person p " 
                    + " on b.personno=p.personno " 
                    + " where b.bno like '%'||?||'%' ";
            ps=con.prepareStatement(sql);
            ps.setInt(1, bno);
            
            rs=ps.executeQuery();
            while(rs.next()){
                int bno1=rs.getInt("bno");
                String bcategory=rs.getString("bcategory1");
                String btitle=rs.getString("btitle");
                String nickname=rs.getString("nickname");
                 Timestamp bregdate=rs.getTimestamp("bregdate");
                int bviewcnt=rs.getInt("bviewcnt");
                int bgood=rs.getInt("bgood");
                
                 BoardDTO dto=new BoardDTO(bno1, bcategory, btitle, nickname, bregdate, bviewcnt, bgood);
                listNo.add(dto);
            }
            System.out.println("게시판번호 검색, listNo의 크기:"+listNo.size());
            return listNo;
        } finally {
            DbUtil.dbClose(rs, ps, con);
        }
     }
     
     public List<BoardDTO> boardSelectByTitle(String btitle) throws SQLException{
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        
        List<BoardDTO> listTile=new ArrayList<>();
        
        try {
            con=DbUtil.getConnection();
            
            String sql="select b.bno, b.bcategory1, b.btitle, p.nickname, b.bregdate, "
                    + " b.bviewcnt, b.bgood "
                    + " from board b join person p " 
                    + " on b.personno=p.personno " 
                    + " where b.btitle like '%'||?||'%' ";
            ps=con.prepareStatement(sql);
            ps.setString(1, btitle);
            
            rs=ps.executeQuery();
            while(rs.next()){
                int bno=rs.getInt("bno");
                String bcategory=rs.getString("bcategory1");
                String btitle1=rs.getString("btitle");
                String nickname=rs.getString("nickname");
                 Timestamp bregdate=rs.getTimestamp("bregdate");
                int bviewcnt=rs.getInt("bviewcnt");
                int bgood=rs.getInt("bgood");
                
                 BoardDTO dto=new BoardDTO(bno, bcategory, btitle1, nickname, bregdate, bviewcnt, bgood);
                listTile.add(dto);
            }
            return listTile;
        } finally {
            DbUtil.dbClose(rs, ps, con);
        }
     }
     
     public List<BoardDTO> boardSelectByNick(String nickname) throws SQLException{
         Connection con=null;
         PreparedStatement ps=null;
         ResultSet rs=null;
         
         List<BoardDTO> listNick=new ArrayList<>();
         
         try {
             con=DbUtil.getConnection();
             String sql="select b.bno, b.bcategory1, b.btitle, p.nickname, b.bregdate, "
                    + " b.bviewcnt, b.bgood "
                    + " from board b join person p " 
                    + " on b.personno=p.personno " 
                    + " where p.nickname like '%'||?||'%'";
             ps=con.prepareStatement(sql);
             ps.setString(1, nickname);
             
             
             rs=ps.executeQuery();
             while(rs.next()){
                 int bno=rs.getInt("bno");
                 String bcategory=rs.getString("bcategory1");
                String btitle=rs.getString("btitle");
                String nickname1=rs.getString("nickname");
                 Timestamp bregdate=rs.getTimestamp("bregdate");
                int bviewcnt=rs.getInt("bviewcnt");
                int bgood=rs.getInt("bgood");
                
                 BoardDTO dto=new BoardDTO(bno, bcategory, btitle, nickname1, bregdate, bviewcnt, bgood);
                listNick.add(dto);
             }
             return listNick;
         } finally {
             DbUtil.dbClose(rs, ps, con);
         }
     }
     
     public int delBoradByNo(int boardNo) throws SQLException{
         Connection con=null;
         PreparedStatement ps=null;
         
        try {
            con=DbUtil.getConnection();
            
            String sql="delete from board where bno=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1, boardNo);
            
            int cnt=ps.executeUpdate();
            System.out.println("상품 삭제결과, cnt="+cnt+", 매개변수 no="+boardNo);
            return cnt;
            
        } finally {
            DbUtil.dbClose(ps, con);
        }
     }

}
