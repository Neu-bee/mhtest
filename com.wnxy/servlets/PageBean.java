package servlets;

import java.util.List;

public class PageBean<T> {
	
	private  int totalCount;//总行数
	private int pageSize;//每页显示的条目数
	private int currentPage;//当前页码
	private  int pages;//总页数
	private  List<T> data;//每页显示的数据
	private String cuname;
	
	
	
	
	public String getCuname() {
		return cuname;
	}


	public void setCuname(String cuname) {
		this.cuname = cuname;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public int getPages() {
		this.pages=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;		
		return pages;
	}


	@Override
	public String toString() {
		return "PageBean [totalCount=" + totalCount + ", pageSize=" + pageSize + ", currentPage=" + currentPage
				+ ", pages=" + pages + ", data=" + data + ", cuname=" + cuname + "]";
	}
	
}
