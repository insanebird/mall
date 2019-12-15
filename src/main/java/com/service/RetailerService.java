package com.service;

import com.common.DateFormat;
import com.dao.RetailerDao;
import com.dao.UserDao;
import com.entity.Retailer;
import org.joda.time.Interval;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RetailerService {
    @Autowired
    RetailerDao retailerDao;
    @Autowired
    UserDao userDao;
    @Autowired
    ProductService productService;
    @Autowired
    OrderService orderService;

    public Retailer getRetailerById(Integer id) {
        return retailerDao.getRetailerById(id);
    }

    public List<Retailer> getRetailerList() {
        List<Retailer> retailerList = retailerDao.getRetailerList();
        for (Retailer retailer : retailerList) {
            retailer.setDisplayTime(DateFormat.stampToDate(retailer.getFoundTime().getTime()));
            retailer.setFounderName(userDao.getUserById(retailer.getFounder()).getUsername());
            retailer.setSkuList(productService.getSKUByRetailerId(retailer.getId()));
            retailer.setOrders(orderService.getOrderByRetailerId(retailer.getId()));
            retailer.setAge(new Interval(retailer.getFoundTime().getTime(), new Date().getTime()).toPeriod().getHours());
        }
        return retailerList;
    }

    public void addRetailer(Retailer retailer) {
        retailerDao.addRetailer(retailer);
    }

    public boolean checkRetailer(String name) {
        if (retailerDao.checkRetailer(name) != null) {
            return false;
        } else {
            return true;
        }
    }

    public Retailer getRetailerByFounder(Integer id) {
        Retailer retailerByFounder = retailerDao.getRetailerByFounder(id);
        retailerByFounder.setDisplayTime(DateFormat.stampToDate(retailerByFounder.getFoundTime().getTime()));
        retailerByFounder.setAge(new Interval(retailerByFounder.getFoundTime().getTime(), new Date().getTime()).toPeriod().getHours());
        return retailerByFounder;
    }

    public Retailer changeRetailerInformation(Retailer retailer) {
        retailerDao.changeRetailerInformation(retailer);
        Retailer retailerById = retailerDao.getRetailerById(retailer.getId());
        retailerById.setDisplayTime(DateFormat.stampToDate(retailerById.getFoundTime().getTime()));
        return retailerById;
    }
}