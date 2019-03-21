package com.tj.dessert.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.tj.dessert.dto.AdminDessertDto;

public class AdminDessertDao {

	public static final int LOGIN_FAIL_PW = 0;
	public static final int LOGIN_FAIL_ID = -1;
	public static final int LOGIN_SUCCESS = 1;
	
	private DataSource ds;
	
	public AdminDessertDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:/comp/env/jdbc/Oracle11g");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	// login admin (관리자)
		public int adminLoginCheck(String aId, String aPw) {
			int result = LOGIN_FAIL_ID;
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM ADMIN_DESSERT WHERE AID=?";
			
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, aId);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					String dbApw = rs.getString("aPW");
					
					if(dbApw.equals(aPw)) {
						result = LOGIN_SUCCESS;
					}else {
						result = LOGIN_FAIL_PW;
					}
				}else {
					result = LOGIN_FAIL_ID;
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
			
			return result;
		}
		
		public AdminDessertDto getAdmin(String aId) {
			
			AdminDessertDto admin = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM ADMIN_DESSERT WHERE AID=?";
			
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, aId);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					admin = new AdminDessertDto();
					admin.setaId(rs.getString("aId"));
					admin.setaPw(rs.getString("aPw"));
					admin.setaName(rs.getString("aName"));
				}
				
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}finally {
				try {
					if(rs != null) {
						rs.close();
					}
					if(pstmt != null) {
						pstmt.close();
					}
					if(conn != null) {
						conn.close();
					}
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			
			return admin;
		}
}
