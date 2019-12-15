package com.controller;

import com.entity.Order;
import com.entity.ProfitTend;
import com.entity.Retailer;
import com.entity.User;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Controller
@ResponseBody
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/generateOrder", method = RequestMethod.POST)
    public List<Order> generateOrder(@RequestBody Order order, HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("cart")) {
                cookie.setValue("");
                cookie.setPath("/");
                response.addCookie(cookie);
                break;
            }
        }
        User user = (User) request.getSession().getAttribute("user");
        order.setStatus(0);
        order.setDate(new Date());
        order.setUserId(user.getId());
        return orderService.generateOrder(order);
    }

    @RequestMapping(value = "/getOrderList", method = RequestMethod.POST)
    public List<Order> getOrderList(@RequestBody User user) {
        return orderService.getOrderListByUserId(user.getId());
    }

    @RequestMapping(value = "/getOrderByRetailerId", method = RequestMethod.POST)
    public List<Order> getOrderByRetailerId(@RequestBody Retailer retailer) {
        return orderService.getOrderByRetailerId(retailer.getId());
    }

    @RequestMapping(value = "/getTodayOrder", method = RequestMethod.POST)
    public List<Order> getTodayOrder(@RequestBody Retailer retailer) {
        return orderService.getTodayOrder(retailer.getId());
    }

    @RequestMapping(value = "/buyProduct", method = RequestMethod.POST)
    public void buyProduct(@RequestBody Order order) {
        orderService.buyProduct(order);
    }

    @RequestMapping(value = "/getMonthOrderTend", method = RequestMethod.POST)
    public ProfitTend getMonthOrderTend(@RequestBody Retailer retailer) {
        return orderService.getOrderByMonthAndRetailerId(retailer.getId());
    }
}