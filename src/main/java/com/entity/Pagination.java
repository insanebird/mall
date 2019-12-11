package com.entity;

import java.util.List;

public class Pagination {
    private int total;
    private int pageSize;
    private int pageCount;
    private int currentPage;
    private List<SKU> products;

    public List<SKU> getProducts() {
        return products;
    }

    public void setProducts(List<SKU> products) {
        this.products = products;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
