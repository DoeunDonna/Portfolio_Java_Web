package com.tj.dessert.dto;

import java.sql.Date;

public class DessertInformDto {

	private int diNum;
	private String aId;
	private String diSubject;
	private String diContent;
	private String diFileName01;
	private String diFileName02;
	private String diFileName03;
	private String diFileName04;
	private String diFileName05;
	private Date diDate;
	private int diHit;
	private String diIp;
	
	public DessertInformDto() {
	
	}

	
	public DessertInformDto(int diNum, String aId, String diSubject, String diContent, String diFileName01,
			String diFileName02, String diFileName03, String diFileName04, String diFileName05, Date diDate, int diHit,
			String diIp) {
		this.diNum = diNum;
		this.aId = aId;
		this.diSubject = diSubject;
		this.diContent = diContent;
		this.diFileName01 = diFileName01;
		this.diFileName02 = diFileName02;
		this.diFileName03 = diFileName03;
		this.diFileName04 = diFileName04;
		this.diFileName05 = diFileName05;
		this.diDate = diDate;
		this.diHit = diHit;
		this.diIp = diIp;
	}


	public int getDiNum() {
		return diNum;
	}

	public void setDiNum(int diNum) {
		this.diNum = diNum;
	}

	public String getaId() {
		return aId;
	}

	public void setaId(String aId) {
		this.aId = aId;
	}

	public String getDiSubject() {
		return diSubject;
	}

	public void setDiSubject(String diSubject) {
		this.diSubject = diSubject;
	}

	public String getDiContent() {
		return diContent;
	}

	public void setDiContent(String diContent) {
		this.diContent = diContent;
	}

	public String getDiFileName01() {
		return diFileName01;
	}

	public void setDiFileName01(String diFileName01) {
		this.diFileName01 = diFileName01;
	}

	public String getDiFileName02() {
		return diFileName02;
	}

	public void setDiFileName02(String diFileName02) {
		this.diFileName02 = diFileName02;
	}

	public String getDiFileName03() {
		return diFileName03;
	}

	public void setDiFileName03(String diFileName03) {
		this.diFileName03 = diFileName03;
	}

	public String getDiFileName04() {
		return diFileName04;
	}

	public void setDiFileName04(String diFileName04) {
		this.diFileName04 = diFileName04;
	}

	public String getDiFileName05() {
		return diFileName05;
	}

	public void setDiFileName05(String diFileName05) {
		this.diFileName05 = diFileName05;
	}

	public Date getDiDate() {
		return diDate;
	}

	public void setDiDate(Date diDate) {
		this.diDate = diDate;
	}

	public int getDiHit() {
		return diHit;
	}

	public void setDiHit(int diHit) {
		this.diHit = diHit;
	}

	public String getDiIp() {
		return diIp;
	}

	public void setDiIp(String diIp) {
		this.diIp = diIp;
	}

	@Override
	public String toString() {
		return "DessertInform [diNum=" + diNum + ", aId=" + aId + ", diSubject=" + diSubject + ", diContent="
				+ diContent + ", diFileName01=" + diFileName01 + ", diFileName02=" + diFileName02 + ", diFileName03="
				+ diFileName03 + ", diFileName04=" + diFileName04 + ", diFileName05=" + diFileName05 + ", diDate="
				+ diDate + ", diHit=" + diHit + ", diIp=" + diIp + "]";
	}
	
	
}
