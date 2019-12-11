package com.service;

import com.common.DateFormat;
import com.dao.OrderDao;
import com.dao.ProductDao;
import com.entity.Cart;
import com.entity.Order;
import com.entity.Retailer;
import com.entity.SKU;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    @Autowired
    OrderDao orderDao;
    @Autowired
    ProductDao productDao;
    @Autowired
    RetailerService retailerService;

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
            order.setRetailerId(entry.getKey());
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
                carts.add(cart);
            }
            order.setCartList(carts);
        }
        return orderListByUserId;
    }

}
