package com.tj.dessert.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.tj.dessert.dto.TalkMeBoardDto;

public class TalkMeBoardDao {

	public static final int FAIL = 0;
	public static final int SUCCESS = 1;
	
	private DataSource ds;
	
	public TalkMeBoardDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//get Board by startRow and endRow
	public ArrayList<TalkMeBoardDto> tbList(int startRow, int endRow){
		ArrayList<TalkMeBoardDto> tbDtos = new ArrayList<TalkMeBoardDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql =  "SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT TB.*, CNICK FROM TALKME_BOARD TB, CUSTOMER C WHERE TB.CID=C.CID ORDER BY TBGROUP DESC, TBSTEP) A) WHERE RN BETWEEN ? AND ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int tbNum = rs.getInt("tbNum");
				String cId = rs.getString("cId");
				String cNick = rs.getString("cNick");
				String tbSubject = rs.getString("tbSubject");
				String tbContent = rs.getString("tbContent");
				String tbFileName01 = rs.getString("tbFileName01");
				String tbFileName02 = rs.getString("tbFileName02");
				String tbFileName03 = rs.getString("tbFileName03");
				String tbFileName04 = rs.getString("tbFileName04");
				String tbFileName05 = rs.getString("tbFileName05");
				Date tbDate = rs.getDate("tbDate");
				int tbHit = rs.getInt("tbHit");
				int tbGroup = rs.getInt("tbGroup");
				int tbStep = rs.getInt("tbStep");
				int tbIndent = rs.getInt("tbIndent");
				String tbIp = rs.getString("tbIp");
				
				tbDtos.add(new TalkMeBoardDto(tbNum, cId, cNick, tbSubject, tbContent, tbFileName01, tbFileName02, tbFileName03, tbFileName04, tbFileName05, tbDate, tbHit, tbGroup, tbStep, tbIndent, tbIp));

			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return tbDtos;
	}
	

	//get totCnt Board
	public int getTbBoardTotCnt() {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM TALKME_BOARD";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt(1);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(rs!=null) {
					rs.close();
				}
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		return cnt;
	}
	
	
	//write Board
	public int tbWrite(String cId, String tbSubject, String tbContent, String tbFileName01, String tbFileName02, String tbFileName03,
			String tbFileName04, String tbFileName05, String tbIp) {
		
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO TALKME_BOARD(TBNUM, CID, TBSUBJECT, TBCONTENT, TBFILENAME01, TBFILENAME02, TBFILENAME03, TBFILENAME04, TBFILENAME05, TBGROUP, TBSTEP, TBINDENT, TBIP) " + 
				"VALUES (TALKME_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, TALKME_SEQ.CURRVAL, 0, 0, ?)";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cId);
			pstmt.setString(2, tbSubject);
			pstmt.setString(3, tbContent);
			pstmt.setString(4, tbFileName01);
			pstmt.setString(5, tbFileName02);
			pstmt.setString(6, tbFileName03);
			pstmt.setString(7, tbFileName04);
			pstmt.setString(8, tbFileName05);
			pstmt.setString(9, tbIp);
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "TALKME 글쓰기 성공" : "TALKME 글쓰기 실패(DAO)");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		
		return result;
	}
	

	//Board hit up
	public void tbHitUp(int tbNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE TALKME_BOARD SET TBHIT = TBHIT + 1 WHERE TBNUM=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tbNum);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
	
	//content view Board
	public TalkMeBoardDto tbContentView(int tbNum) {
		tbHitUp(tbNum);
		TalkMeBoardDto tbDto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT TB.*, CNICK FROM TALKME_BOARD TB, CUSTOMER C WHERE TB.CID=C.CID AND TBNUM=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tbNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String cId = rs.getString("cId");
				String cNick = rs.getString("cNick");
				String tbSubject = rs.getString("tbSubject");
				String tbContent = rs.getString("tbContent");
				String tbFileName01 = rs.getString("tbFileName01");
				String tbFileName02 = rs.getString("tbFileName02");
				String tbFileName03 = rs.getString("tbFileName03");
				String tbFileName04 = rs.getString("tbFileName04");
				String tbFileName05 = rs.getString("tbFileName05");
				Date tbDate = rs.getDate("tbDate");
				int tbHit = rs.getInt("tbHit");
				int tbGroup = rs.getInt("tbGroup");
				int tbStep = rs.getInt("tbStep");
				int tbIndent = rs.getInt("tbIndent");
				String tbIp = rs.getString("tbIp");
				
				tbDto = new TalkMeBoardDto(tbNum, cId, cNick, tbSubject, tbContent, tbFileName01, tbFileName02, tbFileName03, tbFileName04, tbFileName05, tbDate, tbHit, tbGroup, tbStep, tbIndent, tbIp);
				
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		
		return tbDto;
	}
	
	
	//modify veiw Board
		public TalkMeBoardDto tbModifyView_tbReplyView(int tbNum) {

			TalkMeBoardDto tbDto = null;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "SELECT TB.*, CNICK FROM TALKME_BOARD TB, CUSTOMER C WHERE TB.CID = C.CID AND TBNUM = ?";

			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, tbNum);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					String cId = rs.getString("cId");
					String cNick = rs.getString("cNick");
					String tbSubject = rs.getString("tbSubject");
					String tbContent = rs.getString("tbContent");
					String tbFileName01 = rs.getString("tbFileName01");
					String tbFileName02 = rs.getString("tbFileName02");
					String tbFileName03 = rs.getString("tbFileName03");
					String tbFileName04 = rs.getString("tbFileName04");
					String tbFileName05 = rs.getString("tbFileName05");
					Date tbDate = rs.getDate("tbDate");
					int tbHit = rs.getInt("tbHit");
					int tbGroup = rs.getInt("tbGroup");
					int tbStep = rs.getInt("tbStep");
					int tbIndent = rs.getInt("tbIndent");
					String tbIp = rs.getString("tbIp");
					
					tbDto = new TalkMeBoardDto(tbNum, cId, cNick, tbSubject, tbContent, tbFileName01, tbFileName02, tbFileName03, tbFileName04, tbFileName05, tbDate, tbHit, tbGroup, tbStep, tbIndent, tbIp);
					
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}finally {
				try {
					if(pstmt!=null) {
						pstmt.close();
					}
					if(conn!=null) {
						conn.close();
					}
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			
			return tbDto;
		}
		
	//modify Board
	public int tbModify(int tbNum, String tbSubject, String tbContent, String tbFileName01, String tbFileName02, String tbFileName03, String tbFileName04,
			 String tbFileName05, String tbIp) {
		int result = FAIL;
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE TALKME_BOARD SET TBSUBJECT=?, TBCONTENT=?, TBFILENAME01=?, TBFILENAME02=?, TBFILENAME03=?, TBFILENAME04=?, TBFILENAME05=?, TBDATE=SYSDATE, TBIP=? WHERE TBNUM=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tbSubject);
			pstmt.setString(2, tbContent);
			pstmt.setString(3, tbFileName01);
			pstmt.setString(4, tbFileName02);
			pstmt.setString(5, tbFileName03);
			pstmt.setString(6, tbFileName04);
			pstmt.setString(7, tbFileName05);
			pstmt.setString(8, tbIp);
			pstmt.setInt(9, tbNum);
			
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "TALKME 글수정 성공	" : "TALKME 글수정 실패(DAO)");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		
		return result;
	}
	
	//delete Board
	public int tbDelete(int tbNum) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE TALKME_BOARD WHERE TBNUM=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tbNum);
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "TALKME 글삭제 성공" : "TALKME 글삭제 실패(DAO)");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		
		return result;
	}
	
	//STEP A
	private void tbPreReplyStepA(int tbGroup, int tbStep) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE TALKME_BOARD SET TBSTEP = TBSTEP + 1 WHERE TBGROUP = ? AND TBSTEP>?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tbGroup);
			pstmt.setInt(2, tbStep);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
	
	//답글쓰기
	public int tbReply(String cId, String tbSubject, String tbContent,  String tbFileName01, String tbFileName02, String tbFileName03, String tbFileName04, String tbFileName05,
			String tbIp, int tbGroup, int tbStep, int tbIndent) {
		
		tbPreReplyStepA(tbGroup, tbStep);
		
		int result = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql ="INSERT INTO TALKME_BOARD(TBNUM, CID, TBSUBJECT, TBCONTENT, TBFILENAME01, TBFILENAME02, TBFILENAME03, TBFILENAME04, TBFILENAME05, TBGROUP, TBSTEP, TBINDENT, TBIP)\r\n" + 
				"    VALUES (TALKME_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";   

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cId);
			pstmt.setString(2, tbSubject);
			pstmt.setString(3, tbContent);
			pstmt.setString(4, tbFileName01);
			pstmt.setString(5, tbFileName02);
			pstmt.setString(6, tbFileName03);
			pstmt.setString(7, tbFileName04);
			pstmt.setString(8, tbFileName05);
			pstmt.setInt(9, tbGroup);
			pstmt.setInt(10, tbStep+1);
			pstmt.setInt(11, tbIndent+1);
			pstmt.setString(12, tbIp);
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "TALKME 답글 성공" : "TALKME 답글 실패(DAO)");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		
		return result;
	}
	
}
