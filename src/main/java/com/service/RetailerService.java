package com.service;

import com.dao.RetailerDao;
import com.entity.Retailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RetailerService {
    @Autowired
    RetailerDao retailerDao;

    public Retailer getRetailerById(Integer id) {
        return retailerDao.getRetailerById(id);
    }
}
