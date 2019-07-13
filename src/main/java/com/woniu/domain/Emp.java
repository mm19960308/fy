package com.woniu.domain;

import java.util.Date;

public class Emp {
	private Integer eid;
	private String ename;
	private Date hiredate;
	private Double sal;
	private Integer did;
	@Override
	public String toString() {
		return "Emp [did=" + did + ", eid=" + eid + ", ename=" + ename + ", hiredate=" + hiredate + ", sal=" + sal
				+ "]";
	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	
	
}
