package com.tj.dessert.dto;

import java.sql.Date;

public class TalkMeBoardDto {

	private int tbNum;
	private String cId;
	private String cNick;
	private String tbSubject;
	private String tbContent;
	private String tbFileName01;
	private String tbFileName02;
	private String tbFileName03;
	private String tbFileName04;
	private String tbFileName05;
	private Date tbDate;
	private int tbHit;
	private int tbGroup;
	private int tbStep;
	private int tbIndent;
	private String tbIp;
	
	public TalkMeBoardDto() {
	
	}

	public TalkMeBoardDto(int tbNum, String cId, String cNick, String tbSubject, String tbContent, String tbFileName01,
			String tbFileName02, String tbFileName03, String tbFileName04, String tbFileName05, Date tbDate, int tbHit,
			int tbGroup, int tbStep, int tbIndent, String tbIp) {
		this.tbNum = tbNum;
		this.cId = cId;
		this.cNick = cNick;
		this.tbSubject = tbSubject;
		this.tbContent = tbContent;
		this.tbFileName01 = tbFileName01;
		this.tbFileName02 = tbFileName02;
		this.tbFileName03 = tbFileName03;
		this.tbFileName04 = tbFileName04;
		this.tbFileName05 = tbFileName05;
		this.tbDate = tbDate;
		this.tbHit = tbHit;
		this.tbGroup = tbGroup;
		this.tbStep = tbStep;
		this.tbIndent = tbIndent;
		this.tbIp = tbIp;
	}

	public int getTbNum() {
		return tbNum;
	}

	public void setTbNum(int tbNum) {
		this.tbNum = tbNum;
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

	public String getTbSubject() {
		return tbSubject;
	}

	public void setTbSubject(String tbSubject) {
		this.tbSubject = tbSubject;
	}

	public String getTbContent() {
		return tbContent;
	}

	public void setTbContent(String tbContent) {
		this.tbContent = tbContent;
	}

	public String getTbFileName01() {
		return tbFileName01;
	}

	public void setTbFileName01(String tbFileName01) {
		this.tbFileName01 = tbFileName01;
	}

	public String getTbFileName02() {
		return tbFileName02;
	}

	public void setTbFileName02(String tbFileName02) {
		this.tbFileName02 = tbFileName02;
	}

	public String getTbFileName03() {
		return tbFileName03;
	}

	public void setTbFileName03(String tbFileName03) {
		this.tbFileName03 = tbFileName03;
	}

	public String getTbFileName04() {
		return tbFileName04;
	}

	public void setTbFileName04(String tbFileName04) {
		this.tbFileName04 = tbFileName04;
	}

	public String getTbFileName05() {
		return tbFileName05;
	}

	public void setTbFileName05(String tbFileName05) {
		this.tbFileName05 = tbFileName05;
	}

	public Date getTbDate() {
		return tbDate;
	}

	public void setTbDate(Date tbDate) {
		this.tbDate = tbDate;
	}

	public int getTbHit() {
		return tbHit;
	}

	public void setTbHit(int tbHit) {
		this.tbHit = tbHit;
	}

	public int getTbGroup() {
		return tbGroup;
	}

	public void setTbGroup(int tbGroup) {
		this.tbGroup = tbGroup;
	}

	public int getTbStep() {
		return tbStep;
	}

	public void setTbStep(int tbStep) {
		this.tbStep = tbStep;
	}

	public int getTbIndent() {
		return tbIndent;
	}

	public void setTbIndent(int tbIndent) {
		this.tbIndent = tbIndent;
	}

	public String getTbIp() {
		return tbIp;
	}

	public void setTbIp(String tbIp) {
		this.tbIp = tbIp;
	}

	@Override
	public String toString() {
		return "TalkMeBoardDto [tbNum=" + tbNum + ", cId=" + cId + ", cNick=" + cNick + ", tbSubject=" + tbSubject
				+ ", tbContent=" + tbContent + ", tbFileName01=" + tbFileName01 + ", tbFileName02=" + tbFileName02
				+ ", tbFileName03=" + tbFileName03 + ", tbFileName04=" + tbFileName04 + ", tbFileName05=" + tbFileName05
				+ ", tbDate=" + tbDate + ", tbHit=" + tbHit + ", tbGroup=" + tbGroup + ", tbStep=" + tbStep
				+ ", tbIndent=" + tbIndent + ", tbIp=" + tbIp + "]";
	}

}
