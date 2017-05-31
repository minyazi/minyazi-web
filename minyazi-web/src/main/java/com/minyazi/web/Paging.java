package com.minyazi.web;

import java.util.List;

/**
 * 分页Model
 * 
 * @author minyazi
 */
public class Paging<T> {
    /**
     * 总记录数
     */
    private int totalNumber;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 当前页码
     */
    private int currentPage;
    /**
     * 每页记录数
     */
    private int pageSize;
    /**
     * 当前页的首条记录索引
     */
    private int offset; 
    /**
     * 是否是第一页
     */
    private boolean firstPage;
    /**
     * 是否是最后一页
     */
    private boolean lastPage;
    /**
     * 当前页的所有记录
     */
    private List<T> list;
    
    /**
     * 构造一个分页Model对象
     * 
     * @param page 页码
     * @param pageSize 每页记录数
     * @param totalNumber 总记录数
     */
    public Paging(int page, int pageSize, int totalNumber) {
        // 设置总记录数
        this.setTotalNumber((totalNumber <= 0) ? 0 : totalNumber);
        // 设置每页记录数
        this.setPageSize((pageSize <= 0) ? 10 : pageSize);
        // 设置总页数
        this.setTotalPage((this.getTotalNumber() % this.getPageSize() == 0)
                ? (this.getTotalNumber() / this.getPageSize())
                : (this.getTotalNumber() / this.getPageSize() + 1));
        // 设置当前页码
        this.setCurrentPage((page <= 0) ? 1 : page);
        this.setCurrentPage((this.getCurrentPage() > this.getTotalPage())
                ? this.getTotalPage() : this.getCurrentPage());
        // 设置当前页的首条记录索引
        this.setOffset((this.getCurrentPage() == 0) ? 0 : (this.getPageSize() * (this.getCurrentPage() - 1)));
        // 判断是否是第一页
        this.setFirstPage(this.getCurrentPage() <= 1);
        // 判断是否是最后一页
        this.setLastPage(this.getCurrentPage() == this.getTotalPage());
    }
    
    public int getTotalNumber() {
        return totalNumber;
    }
    
    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }
    
    public int getTotalPage() {
        return totalPage;
    }
    
    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
    
    public int getCurrentPage() {
        return currentPage;
    }
    
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    
    public int getPageSize() {
        return pageSize;
    }
    
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    
    public int getOffset() {
        return offset;
    }
    
    public void setOffset(int offset) {
        this.offset = offset;
    }
    
    public boolean isFirstPage() {
        return firstPage;
    }

    public void setFirstPage(boolean firstPage) {
        this.firstPage = firstPage;
    }

    public boolean isLastPage() {
        return lastPage;
    }

    public void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
    }

    public List<T> getList() {
        return list;
    }
    
    public void setList(List<T> list) {
        this.list = list;
    }
    
    @Override
    public String toString() {
        if (list == null) {
            return super.toString();
        }
        return list.toString();
    }
}
