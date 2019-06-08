package com.bdqn.bean;

public class PageBean {
	private int pagesize;		//当前页内数据最大容量
	private int count;			//数据总数
	private int pages;			//总页数
	private int pageon;			//当前页
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getPageon() {
		return pageon;
	}
	public void setPageon(int pageon) {
		this.pageon = pageon;
	}
	
}
