package com.tj.dessert.dto;

import java.sql.Date;

public class EatMeBoardDto {

	private int ebNum;
	private String cId;
	private String cNick;
	private String ebSubject;
	private String ebContent;
	private String ebFileName01;
	private String ebFileName02;
	private String ebFileName03;
	private String ebFileName04;
	private String ebFileName05;
	private String ebFileName06;
	private String ebFileName07;
	private String ebFileName08;
	private String ebFileName09;
	private String ebFileName10;
	private Date ebDate;
	private int ebHit;
	private String ebIp;
	
	public EatMeBoardDto() {
	
	}

	public EatMeBoardDto(int ebNum, String cId, String cNick, String ebSubject, String ebContent, String ebFileName01,
			String ebFileName02, String ebFileName03, String ebFileName04, String ebFileName05, String ebFileName06,
			String ebFileName07, String ebFileName08, String ebFileName09, String ebFileName10, Date ebDate, int ebHit,
			String ebIp) {
		this.ebNum = ebNum;
		this.cId = cId;
		this.cNick = cNick;
		this.ebSubject = ebSubject;
		this.ebContent = ebContent;
		this.ebFileName01 = ebFileName01;
		this.ebFileName02 = ebFileName02;
		this.ebFileName03 = ebFileName03;
		this.ebFileName04 = ebFileName04;
		this.ebFileName05 = ebFileName05;
		this.ebFileName06 = ebFileName06;
		this.ebFileName07 = ebFileName07;
		this.ebFileName08 = ebFileName08;
		this.ebFileName09 = ebFileName09;
		this.ebFileName10 = ebFileName10;
		this.ebDate = ebDate;
		this.ebHit = ebHit;
		this.ebIp = ebIp;
	}

	public int getEbNum() {
		return ebNum;
	}

	public void setEbNum(int ebNum) {
		this.ebNum = ebNum;
	}

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public String getcNick() {
		return cNick;
	}

	public void setcNick(String cNick) {
		this.cNick = cNick;
	}

	public String getEbSubject() {
		return ebSubject;
	}

	public void setEbSubject(String ebSubject) {
		this.ebSubject = ebSubject;
	}

	public String getEbContent() {
		return ebContent;
	}

	public void setEbContent(String ebContent) {
		this.ebContent = ebContent;
	}

	public String getEbFileName01() {
		return ebFileName01;
	}

	public void setEbFileName01(String ebFileName01) {
		this.ebFileName01 = ebFileName01;
	}

	public String getEbFileName02() {
		return ebFileName02;
	}

	public void setEbFileName02(String ebFileName02) {
		this.ebFileName02 = ebFileName02;
	}

	public String getEbFileName03() {
		return ebFileName03;
	}

	public void setEbFileName03(String ebFileName03) {
		this.ebFileName03 = ebFileName03;
	}

	public String getEbFileName04() {
		return ebFileName04;
	}

	public void setEbFileName04(String ebFileName04) {
		this.ebFileName04 = ebFileName04;
	}

	public String getEbFileName05() {
		return ebFileName05;
	}

	public void setEbFileName05(String ebFileName05) {
		this.ebFileName05 = ebFileName05;
	}

	public String getEbFileName06() {
		return ebFileName06;
	}

	public void setEbFileName06(String ebFileName06) {
		this.ebFileName06 = ebFileName06;
	}

	public String getEbFileName07() {
		return ebFileName07;
	}

	public void setEbFileName07(String ebFileName07) {
		this.ebFileName07 = ebFileName07;
	}

	public String getEbFileName08() {
		return ebFileName08;
	}

	public void setEbFileName08(String ebFileName08) {
		this.ebFileName08 = ebFileName08;
	}

	public String getEbFileName09() {
		return ebFileName09;
	}

	public void setEbFileName09(String ebFileName09) {
		this.ebFileName09 = ebFileName09;
	}

	public String getEbFileName10() {
		return ebFileName10;
	}

	public void setEbFileName10(String ebFileName10) {
		this.ebFileName10 = ebFileName10;
	}

	public Date getEbDate() {
		return ebDate;
	}

	public void setEbDate(Date ebDate) {
		this.ebDate = ebDate;
	}

	public int getEbHit() {
		return ebHit;
	}

	public void setEbHit(int ebHit) {
		this.ebHit = ebHit;
	}

	public String getEbIp() {
		return ebIp;
	}

	public void setEbIp(String ebIp) {
		this.ebIp = ebIp;
	}

	@Override
	public String toString() {
		return "EatMeBoardDto [ebNum=" + ebNum + ", cId=" + cId + ", cNick=" + cNick + ", ebSubject=" + ebSubject
				+ ", ebContent=" + ebContent + ", ebFileName01=" + ebFileName01 + ", ebFileName02=" + ebFileName02
				+ ", ebFileName03=" + ebFileName03 + ", ebFileName04=" + ebFileName04 + ", ebFileName05=" + ebFileName05
				+ ", ebFileName06=" + ebFileName06 + ", ebFileName07=" + ebFileName07 + ", ebFileName08=" + ebFileName08
				+ ", ebFileName09=" + ebFileName09 + ", ebFileName10=" + ebFileName10 + ", ebDate=" + ebDate
				+ ", ebHit=" + ebHit + ", ebIp=" + ebIp + "]";
	}

	
	
	
}
