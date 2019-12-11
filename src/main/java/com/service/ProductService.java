package com.service;

import com.dao.CategoryDao;
import com.dao.ProductDao;
import com.dao.RetailerDao;
import com.entity.Category;
import com.entity.Pagination;
import com.entity.Retailer;
import com.entity.SKU;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductDao productDao;
    @Autowired
    CategoryDao categoryDao;
    @Autowired
    RetailerDao retailerDao;

    public List<SKU> findAll() {
        List<SKU> all = productDao.findAll();
        for (SKU sku : all) {
            Retailer retailerById = retailerDao.getRetailerById(sku.getRetailerId());
            sku.setRetailer(retailerById);
            Category categoryById = categoryDao.getCategoryById(sku.getSkuCategory());
            sku.setCategory(categoryById);
        }
        return all;
    }

    public Pagination accessIndex(Pagination pagination) {
        pagination.setTotal(productDao.getCount());
        int page = pagination.getTotal() % pagination.getPageSize();
        if (page == 0) {
            pagination.setPageCount(pagination.getTotal() / pagination.getPageSize());
        } else {
            pagination.setPageCount(pagination.getTotal() / pagination.getPageSize() + 1);
        }
        int index = (pagination.getCurrentPage() - 1) * pagination.getPageSize();
        pagination.setProducts(productDao.getPaginationProduct(index, pagination.getPageSize()));
        return pagination;
    }

    public SKU getProductInfo(Integer pId) {
        return productDao.getProductById(pId);
    }

    public List<Category> getCategory() {
        List<Category> firstCategory = productDao.getFirstCategory();
        for (Category c : firstCategory) {
            List<Category> categoryByParentId = productDao.getCategoryByParentId(c.getCategoryId());
            c.setList(categoryByParentId);
        }
        return firstCategory;
    }

    public List<Category> getSecondCategory(Integer id) {
        List<Category> categoryByParentId = productDao.getCategoryByParentId(id);
        List<Category> categoryList = new ArrayList<>();
        for (Category c : categoryByParentId) {
            List<Category> categoryByParentId1 = productDao.getCategoryByParentId(c.getCategoryId());
            for (Category category : categoryByParentId1) {
                List<Category> categoryByParentId2 = productDao.getCategoryByParentId(category.getCategoryId());
                category.setList(categoryByParentId2);
                categoryList.add(category);
            }
        }
        return categoryList;
    }

    public SKU getSKUById(Integer id) {
        return productDao.getSKUById(id);
    }

    public List<SKU> getCartList(List<Integer> list) {
        return productDao.getSKUsById(list);
    }

    public void addProduct(SKU sku) {
        productDao.addProduct(sku);
    }
}