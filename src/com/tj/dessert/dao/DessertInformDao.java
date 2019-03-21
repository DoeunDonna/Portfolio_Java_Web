package com.tj.dessert.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.tj.dessert.dto.DessertInformDto;

public class DessertInformDao {

	public static final int FAIL = 0;
	public static final int SUCCESS = 1;
	
	private DataSource ds;
	
	public DessertInformDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//get Board by startRow and endRow
	public ArrayList<DessertInformDto> diList(int startRow, int endRow){
		ArrayList<DessertInformDto> diDtos = new ArrayList<DessertInformDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM DESSERT_INFORM ORDER BY DINUM DESC) A) WHERE RN BETWEEN ? AND ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int diNum = rs.getInt("diNum");
				String aId = rs.getString("aId");
				String diSubject = rs.getString("diSubject");
				String diContent = rs.getString("diContent");
				String diFileName01 = rs.getString("diFileName01");
				String diFileName02 = rs.getString("diFileName02");
				String diFileName03 = rs.getString("diFileName03");
				String diFileName04 = rs.getString("diFileName04");
				String diFileName05 = rs.getString("diFileName05");
				Date diDate = rs.getDate("diDate");
				int diHit = rs.getInt("diHit");
				String diIp = rs.getString("diIp");
				
				diDtos.add(new DessertInformDto(diNum, aId, diSubject, diContent, diFileName01, diFileName02, diFileName03, diFileName04, diFileName05, diDate, diHit, diIp));

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
		return diDtos;
	}
	

	//get totCnt Board
	public int getdiBoardTotCnt() {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM DESSERT_INFORM";

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
	public int diWrite(String aId, String diSubject, String diContent, String diFileName01, String diFileName02, String diFileName03,
			String diFileName04, String diFileName05, String diIp) {
		
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO DESSERT_INFORM(DINUM, AID, DISUBJECT, DICONTENT, DIFILENAME01, DIFILENAME02, DIFILENAME03, DIFILENAME04, DIFILENAME05, DIIP) \r\n" + 
				"    VALUES (DESSERT_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, aId);
			pstmt.setString(2, diSubject);
			pstmt.setString(3, diContent);
			pstmt.setString(4, diFileName01);
			pstmt.setString(5, diFileName02);
			pstmt.setString(6, diFileName03);
			pstmt.setString(7, diFileName04);
			pstmt.setString(8, diFileName05);
			pstmt.setString(9, diIp);
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "DESSERT INFORM 글쓰기 성공" : "DESSERT INFORM 글쓰기 실패(DAO)");
			
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
	public void diHitUp(int diNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE DESSERT_INFORM SET DIHIT = DIHIT + 1 WHERE DINUM=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, diNum);
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
	public DessertInformDto diContentView(int diNum) {
		diHitUp(diNum);
		DessertInformDto diDto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM DESSERT_INFORM WHERE DINUM=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, diNum);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String aId = rs.getString("aId");
				String diSubject = rs.getString("diSubject");
				String diContent = rs.getString("diContent");
				String diFileName01 = rs.getString("diFileName01");
				String diFileName02 = rs.getString("diFileName02");
				String diFileName03 = rs.getString("diFileName03");
				String diFileName04 = rs.getString("diFileName04");
				String diFileName05 = rs.getString("diFileName05");
				Date diDate = rs.getDate("diDate");
				int diHit = rs.getInt("diHit");
				String diIp = rs.getString("diIp");
				
				diDto = new DessertInformDto(diNum, aId, diSubject, diContent, diFileName01, diFileName02, diFileName03, diFileName04, diFileName05, diDate, diHit, diIp);
				
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
		
		return diDto;
	}
	
	
	//modify veiw Board
		public DessertInformDto diModifyView(int diNum) {

			DessertInformDto diDto = null;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM DESSERT_INFORM WHERE DINUM=?";

			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, diNum);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					String aId = rs.getString("aId");
					String diSubject = rs.getString("diSubject");
					String diContent = rs.getString("diContent");
					String diFileName01 = rs.getString("diFileName01");
					String diFileName02 = rs.getString("diFileName02");
					String diFileName03 = rs.getString("diFileName03");
					String diFileName04 = rs.getString("diFileName04");
					String diFileName05 = rs.getString("diFileName05");
					Date diDate = rs.getDate("diDate");
					int diHit = rs.getInt("diHit");
					String diIp = rs.getString("diIp");
					
					diDto = new DessertInformDto(diNum, aId, diSubject, diContent, diFileName01, diFileName02, diFileName03, diFileName04, diFileName05, diDate, diHit, diIp);
					
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
			
			return diDto;
		}
		
	//modify Board
	public int diModify(int diNum, String diSubject, String diContent, String diFileName01, String diFileName02, String diFileName03, String diFileName04,
			 String diFileName05, String diIp) {
		int result = FAIL;
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE DESSERT_INFORM SET DISUBJECT=?, DICONTENT=?, DIFILENAME01=?, DIFILENAME02=?, DIFILENAME03=?, DIFILENAME04=?, DIFILENAME05=?, DIIP=? WHERE DINUM=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, diSubject);
			pstmt.setString(2, diContent);
			pstmt.setString(3, diFileName01);
			pstmt.setString(4, diFileName02);
			pstmt.setString(5, diFileName03);
			pstmt.setString(6, diFileName04);
			pstmt.setString(7, diFileName05);
			pstmt.setString(8, diIp);
			pstmt.setInt(9, diNum);
			
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "DESSERT INFORM 수정성공" : "DESSERT INFORM 수정실패(DAO)");
			
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
	public int diDelete(int diNum) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE DESSERT_INFORM WHERE DINUM=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, diNum);
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "DESSERT INFORM 삭제성공" : "DESSERT INFORM 삭제실패(DAO)");
			
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
