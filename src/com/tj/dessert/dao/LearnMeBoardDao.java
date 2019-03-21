package com.tj.dessert.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.tj.dessert.dto.LearnMeBoardDto;

public class LearnMeBoardDao {

	public static final int FAIL = 0;
	public static final int SUCCESS = 1;
	
	private DataSource ds;
	
	public LearnMeBoardDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//get Board by startRow and endRow
	public ArrayList<LearnMeBoardDto> lbList(int startRow, int endRow){
		ArrayList<LearnMeBoardDto> lbDtos = new ArrayList<LearnMeBoardDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM (SELECT ROWNUM RN, LB.* FROM (SELECT LB.*, (SELECT CNICK FROM CUSTOMER C WHERE C.CID=LB.CID) CNICK," + 
				" (SELECT ANAME FROM ADMIN_DESSERT A WHERE A.AID=LB.AID) ANAME FROM LEARNME_BOARD LB ORDER BY LBNUM DESC) LB) WHERE RN BETWEEN ? AND ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int lbNum = rs.getInt("lbNum");
				String cId = rs.getString("cId");
				String cNick = rs.getString("cNick");
				String aId = rs.getString("aId");
				String aName = rs.getString("aName");
				String lbSubject = rs.getString("lbSubject");
				String lbContent = rs.getString("lbContent");
				String lbFileName01 = rs.getString("lbFileName01");
				String lbFileName02 = rs.getString("lbFileName02");
				String lbFileName03 = rs.getString("lbFileName03");
				Date lbDate = rs.getDate("lbDate");
				int lbHit = rs.getInt("lbHit");
				String lbIp = rs.getString("lbIp");
				
				lbDtos.add(new LearnMeBoardDto(lbNum, cId, cNick, aId, aName, lbSubject, lbContent, lbFileName01, lbFileName02, lbFileName03, lbDate, lbHit, lbIp));

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
		return lbDtos;
	}
	

	//get totCnt Board
	public int getLbBoardTotCnt() {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM LEARNME_BOARD";

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
	
	
	//write Board (CUSTOMER)
	public int lbWriteCustomer(String cId, String lbSubject, String lbContent, String lbFileName01, String lbFileName02, String lbFileName03, String lbIp) {
		
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO LEARNME_BOARD(LBNUM, CID, LBSUBJECT, LBCONTENT, LBFILENAME01, LBFILENAME02, LBFILENAME03, LBIP)"+ 
				" VALUES (LEARNME_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cId);
			pstmt.setString(2, lbSubject);
			pstmt.setString(3, lbContent);
			pstmt.setString(4, lbFileName01);
			pstmt.setString(5, lbFileName02);
			pstmt.setString(6, lbFileName03);
			pstmt.setString(7, lbIp);
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "LEARNME 회원 글쓰기 성공" : "LEARNME 회원 글쓰기 실패(DAO)");
			
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

	//write Board (Admin)
	public int lbWriteAdmin(String aId, String lbSubject, String lbContent, String lbFileName01, String lbFileName02, String lbFileName03, String lbIp) {
		
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO LEARNME_BOARD(LBNUM, AID, LBSUBJECT, LBCONTENT, LBFILENAME01, LBFILENAME02, LBFILENAME03, LBIP)" + 
				" VALUES (LEARNME_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, aId);
			pstmt.setString(2, lbSubject);
			pstmt.setString(3, lbContent);
			pstmt.setString(4, lbFileName01);
			pstmt.setString(5, lbFileName02);
			pstmt.setString(6, lbFileName03);
			pstmt.setString(7, lbIp);
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "LEARNME 관리자 글쓰기 성공" : "LEARNME 관리자 글쓰기 실패(DAO)");
			
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
	public void lbHitUp(int lbNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE LEARNME_BOARD SET LBHIT = LBHIT + 1 WHERE LBNUM=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lbNum);
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
	public LearnMeBoardDto lbContentView(int lbNum) {
		lbHitUp(lbNum);
		LearnMeBoardDto lbDto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT LB.*, (SELECT CNICK FROM CUSTOMER C WHERE C.CID=LB.CID) CNICK," + 
				" (SELECT ANAME FROM ADMIN_DESSERT A WHERE A.AID=LB.AID) ANAME FROM LEARNME_BOARD LB WHERE LBNUM = ?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lbNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String cId = rs.getString("cId");
				String cNick = rs.getString("cNick");
				String aId = rs.getString("aId");
				String aName = rs.getString("aName");
				String lbSubject = rs.getString("lbSubject");
				String lbContent = rs.getString("lbContent");
				String lbFileName01 = rs.getString("lbFileName01");
				String lbFileName02 = rs.getString("lbFileName02");
				String lbFileName03 = rs.getString("lbFileName03");
				Date lbDate = rs.getDate("lbDate");
				int lbHit = rs.getInt("lbHit");
				String lbIp = rs.getString("lbIp");
				
				lbDto = new LearnMeBoardDto(lbNum, cId, cNick, aId, aName, lbSubject, lbContent, lbFileName01, lbFileName02, lbFileName03, lbDate, lbHit, lbIp);
				
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
		
		return lbDto;
	}
	
	//modify veiw Board
		public LearnMeBoardDto lbModifyView(int lbNum) {

			LearnMeBoardDto lbDto = null;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "SELECT LB.*, (SELECT CNICK FROM CUSTOMER C WHERE C.CID=LB.CID) CNICK," + 
					" (SELECT ANAME FROM ADMIN_DESSERT A WHERE A.AID=LB.AID) ANAME FROM LEARNME_BOARD LB WHERE LBNUM = ?";

			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, lbNum);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					String cId = rs.getString("cId");
					String cNick = rs.getString("cNick");
					String aId = rs.getString("aId");
					String aName = rs.getString("aName");
					String lbSubject = rs.getString("lbSubject");
					String lbContent = rs.getString("lbContent");
					String lbFileName01 = rs.getString("lbFileName01");
					String lbFileName02 = rs.getString("lbFileName02");
					String lbFileName03 = rs.getString("lbFileName03");
					Date lbDate = rs.getDate("lbDate");
					int lbHit = rs.getInt("lbHit");
					String lbIp = rs.getString("lbIp");
					
					lbDto = new LearnMeBoardDto(lbNum, cId, cNick, aId, aName, lbSubject, lbContent, lbFileName01, lbFileName02, lbFileName03, lbDate, lbHit, lbIp);
					
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
			
			return lbDto;
		}
		
	//modify Board
	public int lbModify(int lbNum, String lbSubject, String lbContent, String lbFileName01, String lbFileName02, String lbFileName03, String lbIp) {
		int result = FAIL;
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE LEARNME_BOARD SET LBSUBJECT=?, LBCONTENT=?, LBFILENAME01=?, LBFILENAME02=?, LBFILENAME03=?, LBDATE=SYSDATE, LBIP=? WHERE LBNUM=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, lbSubject);
			pstmt.setString(2, lbContent);
			pstmt.setString(3, lbFileName01);
			pstmt.setString(4, lbFileName02);
			pstmt.setString(5, lbFileName03);
			pstmt.setString(6, lbIp);
			pstmt.setInt(7, lbNum);
			
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "LEARNME 글수정 성공" : "LEARNME 글수정 실패(DAO)");
			
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
	public int lbDelete(int lbNum) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE LEARNME_BOARD WHERE LBNUM=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lbNum);
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "LEARNME 글삭제 성공" : "LEARNME 글삭제 실패(DAO)");
			
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
