package com.controller;

import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@ResponseBody
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public void addUser(@RequestBody User user, HttpServletRequest request) {
        userService.addUser(user);
        request.getSession().setAttribute("user", user);
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String signIn(@RequestBody User user, HttpServletRequest request) {
        User user1 = userService.signIn(user);
        if (user1 != null) {
            request.getSession().setAttribute("user", user1);
            return "true";
        } else {
            return "false";
        }
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public String check(@RequestBody User user) {
        if (userService.check(user.getUsername())) {
            return "true";
        } else {
            return "false";
        }
    }
}