package com.example.bean;

import java.io.Serializable;

public class XmlBean implements Serializable {
	private static final long serialVersionUID = 8362128795381429935L;
	private Integer p1;
	private String p2;
	
	public XmlBean (Integer p1,String p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	public Integer getP1() {
		return p1;
	}

	public void setP1(Integer p1) {
		this.p1 = p1;
	}

	public String getP2() {
		return p2;
	}

	public void setP2(String p2) {
		this.p2 = p2;
	}



	@Override
	public String toString() {
		return "XmlBean [p1=" + p1 + ", p2=" + p2 
				+ "]";
	}


}
