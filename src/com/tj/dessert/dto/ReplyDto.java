package com.tj.dessert.dto;

import java.sql.Date;

public class ReplyDto {

	private int rNum;
	private int lbNum;
	private String cId;
	private String cNick;
	private String rMemo;
	private Date rDate;
	private String rIp;
	
	public ReplyDto() {
	
	}

	public ReplyDto(int rNum, int lbNum, String cId, String cNick, String rMemo, Date rDate, String rIp) {
		this.rNum = rNum;
		this.lbNum = lbNum;
		this.cId = cId;
		this.cNick = cNick;
		this.rMemo = rMemo;
		this.rDate = rDate;
		this.rIp = rIp;
	}

	public int getrNum() {
		return rNum;
	}

	public void setrNum(int rNum) {
		this.rNum = rNum;
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

	public String getrMemo() {
		return rMemo;
	}

	public void setrMemo(String rMemo) {
		this.rMemo = rMemo;
	}

	public Date getrDate() {
		return rDate;
	}

	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}

	public String getrIp() {
		return rIp;
	}

	public void setrIp(String rIp) {
		this.rIp = rIp;
	}

	@Override
	public String toString() {
		return "ReplyDto [rNum=" + rNum + ", lbNum=" + lbNum + ", cId=" + cId + ", cNick=" + cNick + ", rMemo=" + rMemo
				+ ", rDate=" + rDate + ", rIp=" + rIp + "]";
	}

}
