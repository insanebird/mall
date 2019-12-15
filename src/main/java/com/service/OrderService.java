package com.service;

import com.common.DateFormat;
import com.dao.OrderDao;
import com.dao.ProductDao;
import com.dao.UserDao;
import com.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {
    @Autowired
    OrderDao orderDao;
    @Autowired
    ProductDao productDao;
    @Autowired
    RetailerService retailerService;
    @Autowired
    UserDao userDao;

    public List<Order> generateOrder(Order order) {
        String[] split = order.getSkuItem().split("#");
        Map<Integer, List<String>> map = new HashMap<>();
        List<Cart> carts = new ArrayList<>();
        for (String s : split) {
            String[] str = s.split("_");
            if (map.containsKey(Integer.parseInt(str[2]))) map.get(Integer.parseInt(str[2])).add(str[0] + "_" + str[1]);
            else {
                map.put(Integer.parseInt(str[2]), new ArrayList<>());
                map.get(Integer.parseInt(str[2])).add(str[0] + "_" + str[1]);
            }
        }
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            Order order1 = new Order();
            order1.setRetailerId(entry.getKey());
            order1.setRetailer(retailerService.getRetailerById(entry.getKey()));
            order1.setUserId(order.getUserId());
            order1.setDate(order.getDate());
            order1.setStatus(0);
            List<String> value = entry.getValue();
            double price = 0;
            String orderItem = "";
            for (String s : value) {
                orderItem += s + "#";
                String[] s1 = s.split("_");
                SKU skuById = productDao.getSKUById(Integer.parseInt(s1[0]));
                price += skuById.getSkuPrice() * Integer.parseInt(s1[1]);
                orderDao.decreaseProduct(Integer.parseInt(s1[1]), Integer.parseInt(s1[0]));
                orderDao.increaseSaleNum(Integer.parseInt(s1[1]), Integer.parseInt(s1[0]));
            }
            order1.setSkuItem(orderItem);
            order1.setPrice(price);
            orderDao.generateOrder(order1);
        }
        return getOrderListByUserId(order.getUserId());
    }

    public List<Order> getOrderListByUserId(Integer id) {
        List<Order> orderListByUserId = orderDao.getOrderListByUserId(id);
        for (Order order : orderListByUserId) {
            Retailer retailerById = retailerService.getRetailerById(order.getRetailerId());
            order.setRetailer(retailerById);
            order.setDisplayDate(DateFormat.stampToDate(order.getDate().getTime()));
            String skuItem = order.getSkuItem();
            String[] split = skuItem.split("#");
            List<Cart> carts = new ArrayList<>();
            for (String str : split) {
                String[] s = str.split("_");
                Cart cart = new Cart();
                cart.setSku(productDao.getSKUById(Integer.parseInt(s[0])));
                cart.setNum(Integer.parseInt(s[1]));
                cart.setSkuId(Integer.parseInt(s[0]));
                cart.setStatus(Integer.parseInt(s[2]));
                carts.add(cart);
            }
            order.setCartList(carts);
        }
        return orderListByUserId;
    }

    public List<Order> getOrderByRetailerId(Integer id) {
        List<Order> orderByRetailerId = orderDao.getOrderByRetailerId(id);
        for (Order order : orderByRetailerId) {
            Retailer retailerById = retailerService.getRetailerById(order.getRetailerId());
            order.setRetailer(retailerById);
            order.setDisplayDate(DateFormat.stampToDate(order.getDate().getTime()));
            order.setUser(userDao.getUserById(order.getUserId()));
            String skuItem = order.getSkuItem();
            String[] split = skuItem.split("#");
            List<Cart> carts = new ArrayList<>();
            for (String str : split) {
                String[] s = str.split("_");
                Cart cart = new Cart();
                cart.setSku(productDao.getSKUById(Integer.parseInt(s[0])));
                cart.setNum(Integer.parseInt(s[1]));
                cart.setSkuId(Integer.parseInt(s[0]));
                carts.add(cart);
            }
            order.setCartList(carts);
        }
        return orderByRetailerId;
    }

    public List<Order> getTodayOrder(Integer id) {
        List<Order> todayOrder = orderDao.getTodayOrder(id);
        for (Order order : todayOrder) {
            Retailer retailerById = retailerService.getRetailerById(order.getRetailerId());
            order.setRetailer(retailerById);
            order.setDisplayDate(DateFormat.stampToDate(order.getDate().getTime()));
            order.setUser(userDao.getUserById(order.getUserId()));
            String skuItem = order.getSkuItem();
            String[] split = skuItem.split("#");
            List<Cart> carts = new ArrayList<>();
            for (String str : split) {
                String[] s = str.split("_");
                Cart cart = new Cart();
                cart.setSku(productDao.getSKUById(Integer.parseInt(s[0])));
                cart.setNum(Integer.parseInt(s[1]));
                cart.setSkuId(Integer.parseInt(s[0]));
                carts.add(cart);
            }
            order.setCartList(carts);
        }
        return todayOrder;
    }

    public void buyProduct(Order order) {
        String skuItem = order.getSkuItem();
        String s1 = skuItem.substring(0, skuItem.length() - 1);
        String[] s = s1.split("_");
        SKU skuById = productDao.getSKUById(Integer.parseInt(s[0]));
        Order order1 = new Order();
        order1.setPrice(skuById.getSkuPrice() * Integer.parseInt(s[1]));
        order1.setDate(new Date());
        order1.setUserId(order.getUserId());
        s1 += "_0#";
        order1.setSkuItem(s1);
        orderDao.decreaseProduct(Integer.parseInt(s[1]), Integer.parseInt(s[0]));
        orderDao.increaseSaleNum(Integer.parseInt(s[1]), Integer.parseInt(s[0]));
        orderDao.generateOrder(order1);
    }

    public ProfitTend getOrderByMonthAndRetailerId(Integer id) {
        List<Order> orderByMonthAndRetailerId = orderDao.getOrderByMonthAndRetailerId(id);
        Map<Integer, Double> map = new HashMap<>();
        for (Order order : orderByMonthAndRetailerId) {
            if (map.containsKey(order.getDate().getDay())) {
                map.put(order.getDate().getDay(), map.get(order.getDate().getDay()) + order.getPrice());
            } else {
                map.put(order.getDate().getDay(), order.getPrice());
            }
        }
        Set<Map.Entry<Integer, Double>> entries = map.entrySet();
        ProfitTend profitTend = new ProfitTend();
        for (Map.Entry<Integer, Double> entry : entries) {
            profitTend.getDay().add(entry.getKey());
            profitTend.getProfit().add(entry.getValue());
        }
        return profitTend;
    }
}
