package com.service;

import com.common.DateFormat;
import com.dao.*;
import com.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductDao productDao;
    @Autowired
    CategoryDao categoryDao;
    @Autowired
    RetailerDao retailerDao;
    @Autowired
    SKUCommentDao skuCommentDao;
    @Autowired
    UserDao userDao;

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

    public List<Category> getSearchPanelCategory() {
        List<Category> categoryByLevel = categoryDao.getCategoryByLevel(1);
        List<Category> categoryList = new ArrayList<>();
        for (Category c : categoryByLevel) {
            List<Category> categoryByParentId1 = productDao.getCategoryByParentId(c.getCategoryId());
            for (Category category : categoryByParentId1) {
                List<Category> categoryByParentId2 = productDao.getCategoryByParentId(category.getCategoryId());
                category.setList(categoryByParentId2);
                categoryList.add(category);
            }
        }
        return categoryByLevel;
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

    public List<SKU> getSKUByRetailerId(Integer id) {
        List<SKU> skuByRetailerId = productDao.getSKUByRetailerId(id);
        List<String> list = new ArrayList<>();
        for (SKU sku : skuByRetailerId) {
            Category categoryById = categoryDao.getCategoryById(sku.getSkuCategory());
            getCategoryDisplay(list, categoryById);
            String str = "";
            for (int i = list.size() - 1; i >= 0; i--) {
                str += list.get(i) + "\\";
            }
            sku.setCategoryDisplay(str);
            sku.setComments(getSKUComment(sku.getSkuId()));
            list.clear();
        }
        return skuByRetailerId;
    }

    public void getCategoryDisplay(List<String> list, Category category) {
        if (category.getParentId() != -1) {
            list.add(category.getCategoryName());
            Category lastCategory = categoryDao.getLastCategory(category.getParentId());
            getCategoryDisplay(list, lastCategory);
        } else {
            return;
        }
    }

    public void changeProductStatus(Integer statusId, Integer id) {
        productDao.changeProductStatus(statusId, id);
    }

    public void disableAllProduct(Integer statusId, Integer retailerId) {
        productDao.disableAllProduct(statusId, retailerId);
        retailerDao.changeStatusById(statusId, retailerId);
    }

    public List<SKU> getSKUByName(String name) {
        return productDao.getSKUByName(name);
    }

    public void addComment(SKUComment comment) {
        comment.setDate(new Date());
        skuCommentDao.addComment(comment);
        double rate = skuCommentDao.getRateSumBySKUId(comment.getSkuId()) / skuCommentDao.getSKUCommentBySKUId(comment.getSkuId()).size();
        productDao.updateSKURate(rate, comment.getSkuId());
    }

    public List<SKUComment> getSKUComment(Integer id) {
        List<SKUComment> skuCommentBySKUId = skuCommentDao.getSKUCommentBySKUId(id);
        for (SKUComment skuComment : skuCommentBySKUId) {
            skuComment.setUser(userDao.getUserById(skuComment.getUserId()));
            skuComment.setDisplayTime(DateFormat.stampToDate(skuComment.getDate().getTime()));
        }
        return skuCommentBySKUId;
    }

    public List<SKU> searchProductByCategory(Category category) {
        List<SKU> skuList = new ArrayList<>();
        if (category.getLevel() == 0) {
            List<Category> nestedCategory = categoryDao.findNestedCategory(category.getCategoryId());
            for (Category category1 : nestedCategory) {
                List<Category> nestedCategory1 = categoryDao.findNestedCategory(category1.getCategoryId());
                for (Category category2 : nestedCategory1) {
                    List<SKU> skuByCategory = productDao.getSKUByCategory(category2.getCategoryId());
                    for (SKU sku : skuByCategory) {
                        skuList.add(sku);
                    }
                }
            }
        } else if (category.getLevel() == 1) {
            List<Category> categoryList = categoryDao.findNestedCategory(category.getCategoryId());
            for (Category category1 : categoryList) {
                List<SKU> skuByCategory = productDao.getSKUByCategory(category1.getCategoryId());
                for (SKU sku : skuByCategory) {
                    skuList.add(sku);
                }
            }
        } else {
            List<SKU> skuByCategory = productDao.getSKUByCategory(category.getCategoryId());
            for (SKU sku : skuByCategory) {
                skuList.add(sku);
            }
        }
        return skuList;
    }
}