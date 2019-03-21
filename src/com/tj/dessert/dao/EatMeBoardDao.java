package com.tj.dessert.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.tj.dessert.dto.EatMeBoardDto;

public class EatMeBoardDao {

	public static final int FAIL = 0;
	public static final int SUCCESS = 1;
	
	private DataSource ds;
	
	public EatMeBoardDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//get Board by startRow and endRow
	public ArrayList<EatMeBoardDto> ebList(int startRow, int endRow){
		ArrayList<EatMeBoardDto> ebDtos = new ArrayList<EatMeBoardDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT EB.*, CNICK FROM EATME_BOARD EB, CUSTOMER C WHERE EB.CID=C.CID ORDER BY EBNUM DESC) A) WHERE RN BETWEEN ? AND ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int ebNum = rs.getInt("ebNum");
				String cId = rs.getString("cId");
				String cNick = rs.getString("cNick");
				String ebSubject = rs.getString("ebSubject");
				String ebContent = rs.getString("ebContent");
				String ebFileName01 = rs.getString("ebFileName01");
				String ebFileName02 = rs.getString("ebFileName02");
				String ebFileName03 = rs.getString("ebFileName03");
				String ebFileName04 = rs.getString("ebFileName04");
				String ebFileName05 = rs.getString("ebFileName05");
				String ebFileName06 = rs.getString("ebFileName06");
				String ebFileName07 = rs.getString("ebFileName07");
				String ebFileName08 = rs.getString("ebFileName08");
				String ebFileName09 = rs.getString("ebFileName09");
				String ebFileName10 = rs.getString("ebFileName10");
				Date ebDate = rs.getDate("ebDate");
				int ebHit = rs.getInt("ebHit");
				String ebIp = rs.getString("ebIp");
				
				ebDtos.add(new EatMeBoardDto(ebNum, cId, cNick, ebSubject, ebContent, ebFileName01, ebFileName02, ebFileName03, ebFileName04, ebFileName05, ebFileName06, ebFileName07, ebFileName08, ebFileName09, ebFileName10, ebDate, ebHit, ebIp));

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
		return ebDtos;
	}
	

	//get totCnt Board
	public int getEbBoardTotCnt() {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM EATME_BOARD";

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
	public int ebWrite(String cId, String ebSubject, String ebContent, String ebFileName01, String ebFileName02, String ebFileName03,
			String ebFileName04, String ebFileName05, String ebFileName06, String ebFileName07, String ebFileName08, String ebFileName09, String ebFileName10, String ebIp) {
		
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO EATME_BOARD(EBNUM, CID, EBSUBJECT, EBCONTENT, EBFILENAME01, EBFILENAME02, EBFILENAME03, EBFILENAME04, EBFILENAME05, EBFILENAME06, EBFILENAME07, EBFILENAME08, EBFILENAME09, EBFILENAME10, EBIP) VALUES " + 
				"(EATME_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cId);
			pstmt.setString(2, ebSubject);
			pstmt.setString(3, ebContent);
			pstmt.setString(4, ebFileName01);
			pstmt.setString(5, ebFileName02);
			pstmt.setString(6, ebFileName03);
			pstmt.setString(7, ebFileName04);
			pstmt.setString(8, ebFileName05);
			pstmt.setString(9, ebFileName06);
			pstmt.setString(10, ebFileName07);
			pstmt.setString(11, ebFileName08);
			pstmt.setString(12, ebFileName09);
			pstmt.setString(13, ebFileName10);
			pstmt.setString(14, ebIp);
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "EATME 글쓰기성공" : "EATME 글쓰기실패(DAO)");
			
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
	public void ebHitUp(int ebNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE EATME_BOARD SET EBHIT = EBHIT + 1 WHERE EBNUM=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ebNum);
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
	public EatMeBoardDto ebContentView(int ebNum) {
		ebHitUp(ebNum);
		EatMeBoardDto ebDto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT EB.*, CNICK FROM EATME_BOARD EB, CUSTOMER C WHERE EB.CID=C.CID AND EBNUM=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ebNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String cId = rs.getString("cId");
				String cNick = rs.getString("cNick");
				String ebSubject = rs.getString("ebSubject");
				String ebContent = rs.getString("ebContent");
				String ebFileName01 = rs.getString("ebFileName01");
				String ebFileName02 = rs.getString("ebFileName02");
				String ebFileName03 = rs.getString("ebFileName03");
				String ebFileName04 = rs.getString("ebFileName04");
				String ebFileName05 = rs.getString("ebFileName05");
				String ebFileName06 = rs.getString("ebFileName06");
				String ebFileName07 = rs.getString("ebFileName07");
				String ebFileName08 = rs.getString("ebFileName08");
				String ebFileName09 = rs.getString("ebFileName09");
				String ebFileName10 = rs.getString("ebFileName10");
				Date ebDate = rs.getDate("ebDate");
				int ebHit = rs.getInt("ebHit");
				String ebIp = rs.getString("ebIp");
				
				ebDto = new EatMeBoardDto(ebNum, cId, cNick, ebSubject, ebContent, ebFileName01, ebFileName02, ebFileName03, ebFileName04, ebFileName05, ebFileName06, ebFileName07, ebFileName08, ebFileName09, ebFileName10, ebDate, ebHit, ebIp);
				
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
		
		return ebDto;
	}
	
	
	//modify veiw Board
		public EatMeBoardDto ebModifyView(int ebNum) {

			EatMeBoardDto ebDto = null;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "SELECT EB.*, CNICK FROM EATME_BOARD EB, CUSTOMER C WHERE EB.CID = C.CID AND EBNUM = ?";

			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, ebNum);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					String cId = rs.getString("cId");
					String cNick = rs.getString("cNick");
					String ebSubject = rs.getString("ebSubject");
					String ebContent = rs.getString("ebContent");
					String ebFileName01 = rs.getString("ebFileName01");
					String ebFileName02 = rs.getString("ebFileName02");
					String ebFileName03 = rs.getString("ebFileName03");
					String ebFileName04 = rs.getString("ebFileName04");
					String ebFileName05 = rs.getString("ebFileName05");
					String ebFileName06 = rs.getString("ebFileName06");
					String ebFileName07 = rs.getString("ebFileName07");
					String ebFileName08 = rs.getString("ebFileName08");
					String ebFileName09 = rs.getString("ebFileName09");
					String ebFileName10 = rs.getString("ebFileName10");
					Date ebDate = rs.getDate("ebDate");
					int ebHit = rs.getInt("ebHit");
					String ebIp = rs.getString("ebIp");
					
					ebDto = new EatMeBoardDto(ebNum, cId, cNick, ebSubject, ebContent, ebFileName01, ebFileName02, ebFileName03, ebFileName04, ebFileName05, ebFileName06, ebFileName07, ebFileName08, ebFileName09, ebFileName10, ebDate, ebHit, ebIp);
					
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
			
			return ebDto;
		}
		
	//modify Board
	public int ebModify(int ebNum, String ebSubject, String ebContent, String ebFileName01, String ebFileName02, String ebFileName03, String ebFileName04,
			 String ebFileName05, String ebFileName06, String ebFileName07, String ebFileName08, String ebFileName09, String ebFileName10,String ebIp) {
		int result = FAIL;
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE EATME_BOARD SET EBSUBJECT=?, EBCONTENT=?, EBFILENAME01=?, EBFILENAME02=?, EBFILENAME03=?, EBFILENAME04=?, EBFILENAME05=?," + 
						"EBFILENAME06=?, EBFILENAME07=?, EBFILENAME08=?, EBFILENAME09=?, EBFILENAME10=?, EBDATE=SYSDATE, EBIP=? WHERE EBNUM=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ebSubject);
			pstmt.setString(2, ebContent);
			pstmt.setString(3, ebFileName01);
			pstmt.setString(4, ebFileName02);
			pstmt.setString(5, ebFileName03);
			pstmt.setString(6, ebFileName04);
			pstmt.setString(7, ebFileName05);
			pstmt.setString(8, ebFileName06);
			pstmt.setString(9, ebFileName07);
			pstmt.setString(10, ebFileName08);
			pstmt.setString(11, ebFileName09);
			pstmt.setString(12, ebFileName10);
			pstmt.setString(13, ebIp);
			pstmt.setInt(14, ebNum);
			
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "EATME 글수정성공" : "EATME 글수정실패(DAO)");
			
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
	public int ebDelete(int ebNum) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE EATME_BOARD WHERE EBNUM=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ebNum);
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "EATME 글삭제성공" : "EATME 글삭제실패(DAO)");
			
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
