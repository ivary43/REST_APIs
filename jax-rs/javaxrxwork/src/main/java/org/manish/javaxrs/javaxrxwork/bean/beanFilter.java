package org.manish.javaxrs.javaxrxwork.bean;

import javax.ws.rs.QueryParam;

public class beanFilter {

	private @QueryParam("year") int year;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	
}
