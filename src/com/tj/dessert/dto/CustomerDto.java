package com.tj.dessert.dto;

import java.sql.Date;

public class CustomerDto {

	private String cId;
	private String cPw;
	private String cName;
	private String cNick;
	private int lNum;
	private String lName;
	private Date cBirth;
	private String cGender;
	private String cPhone1;
	private String cPhone2;
	private String cPhone3;
	
	public CustomerDto() {
	
	}

	public CustomerDto(String cId, String cPw, String cName, String cNick, int lNum, String lName, Date cBirth, String cGender,
			String cPhone1, String cPhone2, String cPhone3) {
		this.cId = cId;
		this.cPw = cPw;
		this.cName = cName;
		this.cNick = cNick;
		this.lNum = lNum;
		this.lName = lName;
		this.cBirth = cBirth;
		this.cGender = cGender;
		this.cPhone1 = cPhone1;
		this.cPhone2 = cPhone2;
		this.cPhone3 = cPhone3;
	}

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public String getcPw() {
		return cPw;
	}

	public void setcPw(String cPw) {
		this.cPw = cPw;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcNick() {
		return cNick;
	}

	public void setcNick(String cNick) {
		this.cNick = cNick;
	}

	public int getlNum() {
		return lNum;
	}

	public void setlNum(int lNum) {
		this.lNum = lNum;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Date getcBirth() {
		return cBirth;
	}

	public void setcBirth(Date cBirth) {
		this.cBirth = cBirth;
	}

	public String getcGender() {
		return cGender;
	}

	public void setcGender(String cGender) {
		this.cGender = cGender;
	}

	public String getcPhone1() {
		return cPhone1;
	}

	public void setcPhone1(String cPhone1) {
		this.cPhone1 = cPhone1;
	}

	public String getcPhone2() {
		return cPhone2;
	}

	public void setcPhone2(String cPhone2) {
		this.cPhone2 = cPhone2;
	}

	public String getcPhone3() {
		return cPhone3;
	}

	public void setcPhone3(String cPhone3) {
		this.cPhone3 = cPhone3;
	}

	@Override
	public String toString() {
		return "CustomerDto [cId=" + cId + ", cPw=" + cPw + ", cName=" + cName + ", cNick=" + cNick + ", lNum=" + lNum
				+ ", lName=" + lName + ", cBirth=" + cBirth + ", cGender=" + cGender + ", cPhone1=" + cPhone1
				+ ", cPhone2=" + cPhone2 + ", cPhone3=" + cPhone3 + "]";
	}

	
}
