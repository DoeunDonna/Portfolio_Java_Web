package com.tj.dessert.dto;

import java.sql.Date;

public class LearnMeBoardDto {

	private int lbNum;
	private String cId;
	private String cNick;
	private String aId;
	private String aName;
	private String lbSubject;
	private String lbContent;
	private String lbFileName01;
	private String lbFileName02;
	private String lbFileName03;
	private Date lbDate;
	private int lbHit;
	private String lbIp;
	
	public LearnMeBoardDto() {
	
	}

	public LearnMeBoardDto(int lbNum, String cId, String cNick, String aId, String aName, String lbSubject, String lbContent, String lbFileName01,
			String lbFileName02, String lbFileName03, Date lbDate, int lbHit, String lbIp) {
		this.lbNum = lbNum;
		this.cId = cId;
		this.cNick = cNick;
		this.aId = aId;
		this.aName = aName;
		this.lbSubject = lbSubject;
		this.lbContent = lbContent;
		this.lbFileName01 = lbFileName01;
		this.lbFileName02 = lbFileName02;
		this.lbFileName03 = lbFileName03;
		this.lbDate = lbDate;
		this.lbHit = lbHit;
		this.lbIp = lbIp;
	}

	public int getLbNum() {
		return lbNum;
	}

	public void setLbNum(int lbNum) {
		this.lbNum = lbNum;
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

	public String getaId() {
		return aId;
	}

	public void setaId(String aId) {
		this.aId = aId;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public String getLbSubject() {
		return lbSubject;
	}

	public void setLbSubject(String lbSubject) {
		this.lbSubject = lbSubject;
	}

	public String getLbContent() {
		return lbContent;
	}

	public void setLbContent(String lbContent) {
		this.lbContent = lbContent;
	}

	public String getLbFileName01() {
		return lbFileName01;
	}

	public void setLbFileName01(String lbFileName01) {
		this.lbFileName01 = lbFileName01;
	}

	public String getLbFileName02() {
		return lbFileName02;
	}

	public void setLbFileName02(String lbFileName02) {
		this.lbFileName02 = lbFileName02;
	}

	public String getLbFileName03() {
		return lbFileName03;
	}

	public void setLbFileName03(String lbFileName03) {
		this.lbFileName03 = lbFileName03;
	}

	public Date getLbDate() {
		return lbDate;
	}

	public void setLbDate(Date lbDate) {
		this.lbDate = lbDate;
	}

	public int getLbHit() {
		return lbHit;
	}

	public void setLbHit(int lbHit) {
		this.lbHit = lbHit;
	}

	public String getLbIp() {
		return lbIp;
	}

	public void setLbIp(String lbIp) {
		this.lbIp = lbIp;
	}

	@Override
	public String toString() {
		return "LearnMeBoardDto [lbNum=" + lbNum + ", cId=" + cId + ", cNick=" + cNick + ", aId=" + aId + ", aName="
				+ aName + ", lbSubject=" + lbSubject + ", lbContent=" + lbContent + ", lbFileName01=" + lbFileName01
				+ ", lbFileName02=" + lbFileName02 + ", lbFileName03=" + lbFileName03 + ", lbDate=" + lbDate
				+ ", lbHit=" + lbHit + ", lbIp=" + lbIp + "]";
	}

	
	
	
}
