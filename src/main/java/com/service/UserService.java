package com.service;

import com.dao.UserDao;
import com.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public void addUser(User user) {
        user.setIdentity(0);
        userDao.addUser(user);
    }

    public User signIn(User user) {
        return userDao.signIn(user);
    }

    public boolean check(String username) {
        if (userDao.check(username) != null) {
            return false;
        } else {
            return true;
        }
    }
}