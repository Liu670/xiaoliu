package util;

public class PageSupport {
	private int currentPage;// 当前页
	private int totalCount;// 总记录数
	private int pageSize;// 每页条数
	private int totalPageCount;// 总页数

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		if (currentPage > 0) {
			this.currentPage = currentPage;
		}
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		if (totalCount > 0) {
			this.totalCount = totalCount;
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if (pageSize > 0) {
			this.pageSize = pageSize;
		}
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount() {
		if (totalPageCount % pageSize == 0) {
			this.totalPageCount = totalCount / pageSize;
		} else {
			this.totalPageCount = totalCount / pageSize + 1;
		}
	}

}
