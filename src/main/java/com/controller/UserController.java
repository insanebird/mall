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
import java.util.Date;
import java.util.List;

@Controller
@ResponseBody
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public User addUser(@RequestBody User user, HttpServletRequest request) {
        user.setBirthday(new Date());
        userService.addUser(user);
        request.getSession().setAttribute("user", user);
        return userService.getUserById(user.getId());
    }

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public User signIn(@RequestBody User user, HttpServletRequest request) {
        User user1 = userService.signIn(user);
        if (user1 != null && user.getIsAdmin() == 0) {
            request.getSession().setAttribute("user", user1);
            return user1;
        } else if (user.getIsAdmin() == 1 && user.getUsername().equals("root") && user.getPassword().equals("root")) {
            user.setImage("http://localhost:8081/mall/static/images/admin.jpg");
            return user;
        } else {
            return null;
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

    @RequestMapping(value = "/toBeVIP", method = RequestMethod.POST)
    public User toBeVIP(@RequestBody User user) {
        userService.toBeVIP(user.getId());
        return userService.getUserById(user.getId());
    }

    @RequestMapping(value = "/toBeRetailer", method = RequestMethod.POST)
    public User toBeRetailer(@RequestBody User user) {
        userService.toBeRetailer(user.getId());
        return userService.getUserById(user.getId());
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public void logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
    }

    @RequestMapping(value = "/findAllUser", method = RequestMethod.GET)
    public List<User> findAllUser() {
        return userService.findAll();
    }

    @RequestMapping(value = "/getVIPList", method = RequestMethod.GET)
    public List<User> getVIPList() {
        return userService.getVIPList();
    }

    @RequestMapping(value = "/changeSpeakStatus", method = RequestMethod.POST)
    public void changeStatus(@RequestBody User user) {
        userService.changeStatus(user.getIsSpeak(), user.getId());
    }

    @RequestMapping(value = "/checkPassword", method = RequestMethod.POST)
    public String checkPassword(@RequestBody User user) {
        if (userService.checkPassword(user)) {
            return "true";
        } else {
            return "false";
        }
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public void changePassword(@RequestBody User user) {
        userService.changePassword(user);
    }

    @RequestMapping(value = "/changeUserInformation", method = RequestMethod.POST)
    public User changeUserInformation(@RequestBody User user) {
        return userService.changeUserInformation(user);
    }
}