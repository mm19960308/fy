package com.woniu.domain;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable {

	private Integer p;
	private Integer rowCount;
	private Integer maxPage;
	private Integer prev;
	private Integer next;
	private Integer startLine;
	private Integer size;
	private Integer startPage;
	private Integer endPage;
	private List<T> list;
	public Integer getP() {
		return p;
	}
	public void setP(Integer p) {
		this.p = p;
	}
	public Integer getRowCount() {
		return rowCount;
	}
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}
	public Integer getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(Integer maxPage) {
		this.maxPage = maxPage;
	}
	public Integer getPrev() {
		return prev;
	}
	public void setPrev(Integer prev) {
		this.prev = prev;
	}
	public Integer getNext() {
		return next;
	}
	public void setNext(Integer next) {
		this.next = next;
	}
	public Integer getStartLine() {
		return startLine;
	}
	public void setStartLine(Integer startLine) {
		this.startLine = startLine;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getStartPage() {
		return startPage;
	}
	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}
	public Integer getEndPage() {
		return endPage;
	}
	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Page [endPage=" + endPage + ", list=" + list + ", maxPage=" + maxPage + ", next=" + next + ", p=" + p
				+ ", prev=" + prev + ", rowCount=" + rowCount + ", size=" + size + ", startLine=" + startLine
				+ ", startPage=" + startPage + "]";
	}
	public Page(Integer pg, Integer rc, Integer sz) {
		p = pg;
		rowCount = rc;
		size = sz;
		maxPage=(int) Math.ceil(rowCount * 1.0 / size );
		if(p>maxPage) p = maxPage;
		if(p<1) p = 1;
		
		prev = p - 1;
		next = p + 1;
		
		startLine = (p - 1) * size;
		
		if(maxPage < 10) {
			startPage = 1;
			endPage = maxPage;
		} else {
			startPage = p - 5;
			endPage = p + 4;
			
			if(startPage < 1) {
				startPage = 1;
				endPage = 10;
			}
			if(endPage > maxPage) {
				startPage = maxPage - 9;
				endPage = maxPage;
			}
		}
		
	}
	
	public Page() {
		super();
	} 
	
	
	
	
}
