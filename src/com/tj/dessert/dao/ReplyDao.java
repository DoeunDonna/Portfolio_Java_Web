package com.tj.dessert.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.tj.dessert.dto.ReplyDto;

public class ReplyDao {

	public static final int FAIL = 0;
	public static final int SUCCESS = 1;
	
	private DataSource ds;
	
	public ReplyDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/Oracle11g");
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//get Board by LBNUM
	public ArrayList<ReplyDto> rList(int lbNum){
		ArrayList<ReplyDto> rDtos = new ArrayList<ReplyDto>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT R.*, CNICK FROM REPLY R, CUSTOMER C WHERE R.CID=C.CID AND LBNUM = ? ORDER BY RNUM";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lbNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int rNum = rs.getInt("rNum");
				String cId = rs.getString("cId");
				String cNick = rs.getString("cNick");
				String rMemo = rs.getString("rMemo");
				Date rDate = rs.getDate("rDate");
				String rIp = rs.getString("rIp");
				
				rDtos.add(new ReplyDto(rNum, lbNum, cId, cNick, rMemo, rDate, rIp));

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
		return rDtos;
	}
	

	//get totCnt Board
	public int getReplyTotCnt() {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM REPLY";

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
	public int rWrite(int lbNum, String cId, String rMemo, String rIp) {
		
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO REPLY (RNUM, LBNUM, CID, RMEMO, RIP) VALUES (REPLY_SEQ.NEXTVAL, ?, ?, ?, ?)";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lbNum);
			pstmt.setString(2, cId);
			pstmt.setString(3, rMemo);
			pstmt.setString(4, rIp);
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "REPLY 댓글작성 성공" : "REPLY 댓글작성 실패(DAO)");
			
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
	
	//modify Board
		public int rModify(int rNum, String rMemo,String rIp) {
			int result = FAIL;
		
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "UPDATE REPLY SET RMEMO=?, RIP=? WHERE RNUM=?";

			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, rMemo);
				pstmt.setString(2, rIp);
				pstmt.setInt(7, rNum);
				
				result = pstmt.executeUpdate();
				System.out.println(result == SUCCESS ? "Reply 댓글수정 성공" : "Reply 댓글수정 실패");
				
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
	public int rDelete(int rNum) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE REPLY WHERE RNUM=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rNum);
			result = pstmt.executeUpdate();
			System.out.println(result == SUCCESS ? "REPLY 댓글삭제 성공" : "REPLY 댓글삭제 실패(DAO)");
			
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
