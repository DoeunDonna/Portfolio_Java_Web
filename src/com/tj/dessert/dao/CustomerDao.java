package com.tj.dessert.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.tj.dessert.dto.CustomerDto;

public class CustomerDao {

	public static final int EXISTENT = 0;
	public static final int NONEXISTENT = 1;
	public static final int FAIL = 0;
	public static final int SUCCESS = 1;
	public static final int LOGIN_FAIL_PW = 0;
	public static final int LOGIN_FAIL_ID = -1;
	public static final int LOGIN_SUCCESS = 1;
	
	private DataSource ds;
	
	public CustomerDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:/comp/env/jdbc/Oracle11g");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
// ID confirm (중복아이디 확인)
	public int cIdConfirm(String cId) {
		int result = EXISTENT;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM CUSTOMER WHERE CID= ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = EXISTENT;
			}else {
				result = NONEXISTENT;
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
	
//	Nick confirm (중복별명 확인)
	public int cNickConfirm(String cNick) {
		int result = EXISTENT;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM CUSTOMER WHERE CNICK= ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cNick);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = EXISTENT;
			}else {
				result = NONEXISTENT;
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
	
	
// join customer (회원가입)
	public int joinCustomer(CustomerDto cDto) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql="INSERT INTO CUSTOMER(CID, CPW, CNAME, CNICK, LNUM, CBIRTH, CGENDER, CPHONE1, CPHONE2, CPHONE3) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cDto.getcId());
			pstmt.setString(2, cDto.getcPw());
			pstmt.setString(3, cDto.getcName());
			pstmt.setString(4, cDto.getcNick());
			pstmt.setInt(5, cDto.getlNum());
			pstmt.setDate(6, cDto.getcBirth());
			pstmt.setString(7, cDto.getcGender());
			pstmt.setString(8, cDto.getcPhone1());
			pstmt.setString(9, cDto.getcPhone2());
			pstmt.setString(10, cDto.getcPhone3());
			result = pstmt.executeUpdate();
			
			System.out.println(result == SUCCESS ? "회원가입성공" : "회원가입실패");
			
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
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}

// login customer (로그인)
	public int cusLoginCheck(String cId, String cPw) {
		int result = LOGIN_FAIL_ID;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM CUSTOMER WHERE CID= ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String dbCpw = rs.getString("cPW");
				
				if(dbCpw.equals(cPw)) {
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
	
// modify inform (회원정보 수정)
	public int modifyCustomer(CustomerDto cDto) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET CPW=?, CNAME=?, CNICK=?, LNUM=?, CBIRTH=?, CGENDER=?, CPHONE1=?, CPHONE2=?, CPHONE3=? WHERE CID= ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cDto.getcPw());
			pstmt.setString(2, cDto.getcName());
			pstmt.setString(3, cDto.getcNick());
			pstmt.setInt(4, cDto.getlNum());
			pstmt.setDate(5, cDto.getcBirth());
			pstmt.setString(6, cDto.getcGender());
			pstmt.setString(7, cDto.getcPhone1());
			pstmt.setString(8, cDto.getcPhone2());
			pstmt.setString(9, cDto.getcPhone3());
			pstmt.setString(10, cDto.getcId());
			result = pstmt.executeUpdate();
			
			System.out.println(result == SUCCESS ? "회원정보수정 성공" : "회원정보수정 실패");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
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
		
		return result;
	}
	
// get customerDto by cId (아이디로 회원정보 가져오기)
	public CustomerDto getCustomer(String cId) {
		
		CustomerDto customer = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT C.*, LNAME FROM CUSTOMER C, CUSTOMER_LEVEL L WHERE C.LNUM=L.LNUM AND CID=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				customer = new CustomerDto();
				customer.setcId(rs.getString("cId"));
				customer.setcPw(rs.getString("cPw"));
				customer.setcName(rs.getString("cName"));
				customer.setcNick(rs.getString("cNick"));
				customer.setlNum(rs.getInt("lNum"));
				customer.setlName(rs.getString("lName"));
				customer.setcBirth(rs.getDate("cBirth"));
				customer.setcGender(rs.getString("cGender"));
				customer.setcPhone1(rs.getString("cPhone1"));
				customer.setcPhone2(rs.getString("cPhone2"));
				customer.setcPhone3(rs.getString("cPhone3"));
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
		
		return customer;
	}
	
// total count of customer (전체회원수 출력)
	public int getCustomerTotCnt() {
		int cnt = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT COUNT(*) FROM CUSTOMER";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cnt = rs.getInt(1);
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
		
		return cnt;
	}
	
// from startRow to endRow by cId and cBirth (회원전체리스트 출력, 페이징)
	public ArrayList<CustomerDto> cusList(int startRow, int endRow){
		ArrayList<CustomerDto> cDtos = new ArrayList<CustomerDto>();
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM (SELECT ROWNUM RN, C.* FROM (SELECT C.*, LNAME FROM CUSTOMER C, CUSTOMER_LEVEL L WHERE C.LNUM=L.LNUM ORDER BY CID, CBIRTH) C) WHERE RN BETWEEN ? AND ?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String cId = rs.getString("cId");
				String cPw = rs.getString("cPw");
				String cName = rs.getString("cName");
				String cNick = rs.getString("cNick");
				int lNum = rs.getInt("lNum");
				String lName = rs.getString("lName");
				Date cBirth = rs.getDate("cBirth");
				String cGender = rs.getString("cGender");
				String cPhone1 = rs.getString("cPhone1");
				String cPhone2 = rs.getString("cPhone2");
				String cPhone3 = rs.getString("cPhone3");
				cDtos.add(new CustomerDto(cId, cPw, cName, cNick, lNum, lName, cBirth, cGender, cPhone1, cPhone2, cPhone3));
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
		
		return cDtos;
	}
	
//search cNick (닉네임으로 회원 검색하기)
public CustomerDto searchCnick(String cNick) {
		
		CustomerDto customer = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM CUSTOMER WHERE CNICK= ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cNick);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				customer = new CustomerDto();
				customer.setcId(rs.getString("cId"));
				customer.setcPw(rs.getString("cPw"));
				customer.setcName(rs.getString("cName"));
				customer.setcNick(rs.getString("cNick"));
				customer.setlNum(rs.getInt("lNum"));
				customer.setlName(rs.getString("lName"));
				customer.setcBirth(rs.getDate("cBirth"));
				customer.setcGender(rs.getString("cGender"));
				customer.setcPhone1(rs.getString("cPhone1"));
				customer.setcPhone2(rs.getString("cPhone2"));
				customer.setcPhone3(rs.getString("cPhone3"));
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
		
		return customer;
	}
	
//level list (레벨별 리스트 뿌리기)
public ArrayList<CustomerDto> cLevelList(String lName){
	ArrayList<CustomerDto> cDtos = new ArrayList<CustomerDto>();
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "SELECT * FROM CUSTOMER C, CUSTOMER_LEVEL L WHERE C.LNUM = L.LNUM AND LNAME = ?";
	
	try {
		conn = ds.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, lName);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String cId = rs.getString("cId");
			String cPw = rs.getString("cPw");
			String cName = rs.getString("cName");
			String cNick = rs.getString("cNick");
			int lNum = rs.getInt("lNum");
			Date cBirth = rs.getDate("cBirth");
			String cGender = rs.getString("cGender");
			String cPhone1 = rs.getString("cPhone1");
			String cPhone2 = rs.getString("cPhone2");
			String cPhone3 = rs.getString("cPhone3");
			cDtos.add(new CustomerDto(cId, cPw, cName, cNick, lNum, lName, cBirth, cGender, cPhone1, cPhone2, cPhone3));
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
	
	return cDtos;
}
	
//modify level (회원 레벨 변경하기)
	public int modifyCusLevel(CustomerDto cDto) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET LNUM = ? WHERE CID=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cDto.getlNum());
			pstmt.setString(2, cDto.getcId());
			result = pstmt.executeUpdate();
			
			System.out.println(result == SUCCESS ? "회원레벨 변경성공":"회원레벨 변경실패");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
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
		
		return result;
	}
	
// 회원탈퇴
	public int DeleteCustomer(CustomerDto cDto) {
		int result = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE CUSTOMER SET LNUM = ? WHERE CID = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cDto.getlNum());
			pstmt.setString(2, cDto.getcId());
			result = pstmt.executeUpdate();
			
			System.out.println(result == SUCCESS ? "회원탈퇴 성공" : "회원탈퇴 실패");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
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
		
		return result;
		
	}
		
	
}
