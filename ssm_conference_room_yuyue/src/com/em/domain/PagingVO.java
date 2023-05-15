// 
// 
// 

package com.em.domain;

public class PagingVO
{
    private int curentPageNo;
    private int totalCount;
    private int pageSize;
    private int upPageNo;
    private int nextPageNo;
    private int toPageNo;
    
    public PagingVO() {
        this.curentPageNo = 1;
        this.pageSize = 5;
        this.toPageNo = 0;
    }
    
    public void setToPageNo(final Integer toPageNo) {
        this.toPageNo = (toPageNo - 1) * this.pageSize;
        this.setCurentPageNo(toPageNo);
    }
    
    public Integer getTopageNo() {
        return this.toPageNo;
    }
    
    public int getCurentPageNo() {
        return this.curentPageNo;
    }
    
    public void setCurentPageNo(final int curentPageNo) {
        if (curentPageNo != 1) {
            this.upPageNo = curentPageNo - 1;
        }
        this.nextPageNo = curentPageNo + 1;
        this.curentPageNo = curentPageNo;
    }
    
    public int getTotalCount() {
        return this.totalCount;
    }
    
    public void setTotalCount(final int totalCount) {
        if (totalCount % this.pageSize > 0) {
            this.totalCount = totalCount / this.pageSize + 1;
        }
        else {
            this.totalCount = totalCount / this.pageSize;
        }
    }
    
    public int getPageSize() {
        return this.pageSize;
    }
    
    public void setPageSize(final int pageSize) {
        this.pageSize = pageSize;
    }
    
    public int getUpPageNo() {
        return this.upPageNo;
    }
    
    public void setUpPageNo(final int upPageNo) {
        this.upPageNo = upPageNo;
    }
    
    public int getNextPageNo() {
        return this.nextPageNo;
    }
    
    public void setNextPageNo(final int nextPageNo) {
        this.nextPageNo = nextPageNo;
    }
}
