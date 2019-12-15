package com.service;

import com.common.DateFormat;
import com.dao.ForumDao;
import com.dao.UserDao;
import com.entity.Comment;
import com.entity.Forum;
import com.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    ForumDao forumDao;

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

    public void toBeVIP(Integer id) {
        userDao.toBeVIP(id);
    }

    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    public void toBeRetailer(Integer id) {
        userDao.toBeRetailer(id);
    }

    public List<User> findAll() {
        List<User> all = userDao.findAll();
        for (User user : all) {
            user.setDisplayTime(DateFormat.stampToDate(user.getBirthday().getTime()));
        }
        return all;
    }

    public List<User> getVIPList() {
        List<User> vipList = userDao.getVIPList();
        for (User user : vipList) {
            user.setDisplayTime(DateFormat.stampToDate(user.getBirthday().getTime()));
            List<Forum> topicsByAuthor = forumDao.getTopicsByAuthor(user.getId());
            for (Forum forum : topicsByAuthor) {
                List<Comment> commentByTopicIdAndUserId = forumDao.getCommentByTopicIdAndUserId(forum.getId(), user.getId());
                for (Comment comment : commentByTopicIdAndUserId) {
                    comment.setChildren(forumDao.getRepliesByCommentIdAndUserId(comment.getId(), user.getId()));
                }
                forum.setComments(commentByTopicIdAndUserId);
            }
            user.setTopics(topicsByAuthor);
        }
        return vipList;
    }

    public void changeStatus(Integer status, Integer id) {
        userDao.changeStatus(status, id);
    }

    public boolean checkPassword(User user) {
        if (userDao.checkPassword(user) == null) {
            return false;
        } else {
            return true;
        }
    }

    public void changePassword(User user) {
        userDao.changePassword(user);
    }

    public User changeUserInformation(User user) {
        userDao.updateUserInformation(user);
        return userDao.getUserById(user.getId());
    }
}