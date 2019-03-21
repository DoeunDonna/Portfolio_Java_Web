package com.tj.dessert.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.tj.dessert.dto.CookMeBoardDto;

public class CookMeBoardDao {

	public static final int FAIL = 0;
	public static final int SUCCESS = 1;
	
	private DataSource ds;
	
	public CookMeBoardDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//get Board by startRow and endRow
	public ArrayList<CookMeBoardDto> cbList(int startRow, int endRow){
		ArrayList<CookMeBoardDto> cbDtos = new ArrayList<CookMeBoardDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT CB.*, CNICK FROM COOKME_BOARD CB, CUSTOMER C WHERE CB.CID=C.CID ORDER BY CBNUM DESC) A) WHERE RN BETWEEN ? AND ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int cbNum = rs.getInt("cbNum");
				String cId = rs.getString("cId");
				String cNick = rs.getString("cNick");
				String cbSubject = rs.getString("cbSubject");
				String cbContent01 = rs.getString("cbContent01");
				String cbContent02 = rs.getString("cbContent02");
				String cbContent03 = rs.getString("cbContent03");
				String cbContent04 = rs.getString("cbContent04");
				String cbContent05 = rs.getString("cbContent05");
				String cbContent06 = rs.getString("cbContent06");
				String cbContent07 = rs.getString("cbContent07");
				String cbContent08 = rs.getString("cbContent08");
				String cbContent09 = rs.getString("cbContent09");
				String cbContent10 = rs.getString("cbContent10");
				String cbFileName01 = rs.getString("cbFileName01");
				String cbFileName02 = rs.getString("cbFileName02");
				String cbFileName03 = rs.getString("cbFileName03");
				String cbFileName04 = rs.getString("cbFileName04");
				String cbFileName05 = rs.getString("cbFileName05");
				String cbFileName06 = rs.getString("cbFileName06");
				String cbFileName07 = rs.getString("cbFileName07");
				String cbFileName08 = rs.getString("cbFileName08");
				String cbFileName09 = rs.getString("cbFileName09");
				String cbFileName10 = rs.getString("cbFileName10");
				Date cbDate = rs.getDate("cbDate");
				int cbHit = rs.getInt("cbHit");
				String cbIp = rs.getString("cbIp");
				
				cbDtos.add(new CookMeBoardDto(cbNum, cId, cNick, cbSubject, cbContent01, cbContent02, cbContent03, cbContent04, cbContent05, cbContent06, cbContent07, cbContent08, cbContent09, cbContent10, cbFileName01, cbFileName02, cbFileName03, cbFileName04, cbFileName05, cbFileName06, cbFileName07, cbFileName08, cbFileName09, cbFileName10, cbDate, cbHit, cbIp));
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
		return cbDtos;
	}
	

	//get totCnt Board
	public int getCbBoardTotCnt() {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM COOKME_BOARD";

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
	public int cbWrite(String cId, String cbSubject, String cbContent01, String cbContent02, String cbContent03, String cbContent04,
			String cbContent05, String cbContent06, String cbContent07, String cbContent08, String cbContent09, String cbContent10, String cbFileName01, String cbFileName02, String cbFileName03,
			String cbFileName04, String cbFileName05, String cbFileName06, String cbFileName07, String cbFileName08, String cbFileName09, String cbFileName10, String cbIp) {
		
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO COOKME_BOARD(CBNUM, CID, CBSUBJECT, CBCONTENT01, CBCONTENT02, CBCONTENT03, CBCONTENT04, CBCONTENT05, CBCONTENT06, CBCONTENT07, CBCONTENT08, CBCONTENT09, CBCONTENT10," + 
				" CBFILENAME01, CBFILENAME02, CBFILENAME03, CBFILENAME04, CBFILENAME05, CBFILENAME06, CBFILENAME07, CBFILENAME08, CBFILENAME09, CBFILENAME10, CBIP) VALUES" + 
				" (COOKME_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cId);
			pstmt.setString(2, cbSubject);
			pstmt.setString(3, cbContent01);
			pstmt.setString(4, cbContent02);
			pstmt.setString(5, cbContent03);
			pstmt.setString(6, cbContent04);
			pstmt.setString(7, cbContent05);
			pstmt.setString(8, cbContent06);
			pstmt.setString(9, cbContent07);
			pstmt.setString(10, cbContent08);
			pstmt.setString(11, cbContent09);
			pstmt.setString(12, cbContent10);
			pstmt.setString(13, cbFileName01);
			pstmt.setString(14, cbFileName02);
			pstmt.setString(15, cbFileName03);
			pstmt.setString(16, cbFileName04);
			pstmt.setString(17, cbFileName05);
			pstmt.setString(18, cbFileName06);
			pstmt.setString(19, cbFileName07);
			pstmt.setString(20, cbFileName08);
			pstmt.setString(21, cbFileName09);
			pstmt.setString(22, cbFileName10);
			pstmt.setString(23, cbIp);
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "COOKME 글쓰기 성공" : "COOKME 글쓰기 실패(DAO)");
			
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
	public void cbHitUp(int cbNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE COOKME_BOARD SET CBHIT = CBHIT + 1 WHERE CBNUM=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cbNum);
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
	public CookMeBoardDto cbContentView(int cbNum) {
		cbHitUp(cbNum);
		CookMeBoardDto cbDto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT CB.*, CNICK FROM COOKME_BOARD CB, CUSTOMER C WHERE CB.CID=C.CID AND CBNUM=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cbNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String cId = rs.getString("cId");
				String cNick = rs.getString("cNick");
				String cbSubject = rs.getString("cbSubject");
				String cbContent01 = rs.getString("cbContent01");
				String cbContent02 = rs.getString("cbContent02");
				String cbContent03 = rs.getString("cbContent03");
				String cbContent04 = rs.getString("cbContent04");
				String cbContent05 = rs.getString("cbContent05");
				String cbContent06 = rs.getString("cbContent06");
				String cbContent07 = rs.getString("cbContent07");
				String cbContent08 = rs.getString("cbContent08");
				String cbContent09 = rs.getString("cbContent09");
				String cbContent10 = rs.getString("cbContent10");
				String cbFileName01 = rs.getString("cbFileName01");
				String cbFileName02 = rs.getString("cbFileName02");
				String cbFileName03 = rs.getString("cbFileName03");
				String cbFileName04 = rs.getString("cbFileName04");
				String cbFileName05 = rs.getString("cbFileName05");
				String cbFileName06 = rs.getString("cbFileName06");
				String cbFileName07 = rs.getString("cbFileName07");
				String cbFileName08 = rs.getString("cbFileName08");
				String cbFileName09 = rs.getString("cbFileName09");
				String cbFileName10 = rs.getString("cbFileName10");
				Date cbDate = rs.getDate("cbDate");
				int cbHit = rs.getInt("cbHit");
				String cbIp = rs.getString("cbIp");
				
				cbDto = new CookMeBoardDto(cbNum, cId, cNick, cbSubject, cbContent01, cbContent02, cbContent03, cbContent04, cbContent05, cbContent06, cbContent07, cbContent08, cbContent09, cbContent10, cbFileName01, cbFileName02, cbFileName03, cbFileName04, cbFileName05, cbFileName06, cbFileName07, cbFileName08, cbFileName09, cbFileName10, cbDate, cbHit, cbIp);

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
		
		return cbDto;
	}
	
	
	//modify veiw Board
		public CookMeBoardDto cbModifyView(int cbNum) {

			CookMeBoardDto cbDto = null;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "SELECT CB.*, CNICK FROM COOKME_BOARD CB, CUSTOMER C WHERE CB.CID = C.CID AND CBNUM = ?";

			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, cbNum);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					String cId = rs.getString("cId");
					String cNick = rs.getString("cNick");
					String cbSubject = rs.getString("cbSubject");
					String cbContent01 = rs.getString("cbContent01");
					String cbContent02 = rs.getString("cbContent02");
					String cbContent03 = rs.getString("cbContent03");
					String cbContent04 = rs.getString("cbContent04");
					String cbContent05 = rs.getString("cbContent05");
					String cbContent06 = rs.getString("cbContent06");
					String cbContent07 = rs.getString("cbContent07");
					String cbContent08 = rs.getString("cbContent08");
					String cbContent09 = rs.getString("cbContent09");
					String cbContent10 = rs.getString("cbContent10");
					String cbFileName01 = rs.getString("cbFileName01");
					String cbFileName02 = rs.getString("cbFileName02");
					String cbFileName03 = rs.getString("cbFileName03");
					String cbFileName04 = rs.getString("cbFileName04");
					String cbFileName05 = rs.getString("cbFileName05");
					String cbFileName06 = rs.getString("cbFileName06");
					String cbFileName07 = rs.getString("cbFileName07");
					String cbFileName08 = rs.getString("cbFileName08");
					String cbFileName09 = rs.getString("cbFileName09");
					String cbFileName10 = rs.getString("cbFileName10");
					Date cbDate = rs.getDate("cbDate");
					int cbHit = rs.getInt("cbHit");
					String cbIp = rs.getString("cbIp");
					
					cbDto = new CookMeBoardDto(cbNum, cId, cNick, cbSubject, cbContent01, cbContent02, cbContent03, cbContent04, cbContent05, cbContent06, cbContent07, cbContent08, cbContent09, cbContent10, cbFileName01, cbFileName02, cbFileName03, cbFileName04, cbFileName05, cbFileName06, cbFileName07, cbFileName08, cbFileName09, cbFileName10, cbDate, cbHit, cbIp);
					System.out.println(cbDto);
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
			
			return cbDto;
		}
		
	//modify Board
	public int cbModify(int cbNum, String cbSubject, String cbContent01, String cbContent02, String cbContent03, String cbContent04, String cbContent05, String cbContent06, String cbContent07, String cbContent08, String cbContent09, String cbContent10, String cbFileName01, String cbFileName02, String cbFileName03, String cbFileName04,
			 String cbFileName05, String cbFileName06, String cbFileName07, String cbFileName08, String cbFileName09, String cbFileName10,String cbIp) {
		int result = FAIL;
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE COOKME_BOARD SET CBSUBJECT=?, CBCONTENT01=?, CBCONTENT02=?, CBCONTENT03=?, CBCONTENT04=?, CBCONTENT05=?, CBCONTENT06=?, CBCONTENT07=?, CBCONTENT08=?, CBCONTENT09=?, CBCONTENT10=?," + 
				" CBFILENAME01=?, CBFILENAME02=?, CBFILENAME03=?, CBFILENAME04=?, CBFILENAME05=?," + 
				" CBFILENAME06=?, CBFILENAME07=?, CBFILENAME08=?, CBFILENAME09=?, CBFILENAME10=?, CBDATE=SYSDATE, CBIP=? WHERE CBNUM=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cbSubject);
			pstmt.setString(2, cbContent01);
			pstmt.setString(3, cbContent02);
			pstmt.setString(4, cbContent03);
			pstmt.setString(5, cbContent04);
			pstmt.setString(6, cbContent05);
			pstmt.setString(7, cbContent06);
			pstmt.setString(8, cbContent07);
			pstmt.setString(9, cbContent08);
			pstmt.setString(10, cbContent09);
			pstmt.setString(11, cbContent10);
			pstmt.setString(12, cbFileName01);
			pstmt.setString(13, cbFileName02);
			pstmt.setString(14, cbFileName03);
			pstmt.setString(15, cbFileName04);
			pstmt.setString(16, cbFileName05);
			pstmt.setString(17, cbFileName06);
			pstmt.setString(18, cbFileName07);
			pstmt.setString(19,cbFileName08);
			pstmt.setString(20,cbFileName09);
			pstmt.setString(21,cbFileName10);
			pstmt.setString(22, cbIp);
			pstmt.setInt(23, cbNum);
			
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "COOKME 글수정 성공" : "COOKME 글수정 실패(DAO)");
			
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
	public int cbDelete(int cbNum) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE COOKME_BOARD WHERE CBNUM=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cbNum);
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "COOKME 글삭제 성공" : "COOKME 글삭제 실패(DAO)");
			
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
