package com.controller;

import com.entity.Order;
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
        order.setUserId(1);
        return orderService.generateOrder(order);
    }

    @RequestMapping(value = "/getOrderList", method = RequestMethod.GET)
    public List<Order> getOrderList() {
        return orderService.getOrderListByUserId(1);
    }
}
