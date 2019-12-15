package com.service;

import com.common.DateFormat;
import com.dao.ForumDao;
import com.dao.UserDao;
import com.entity.Comment;
import com.entity.Forum;
import com.entity.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ForumService {
    @Autowired
    ForumDao forumDao;
    @Autowired
    UserDao userDao;

    public List<Forum> getTopics() {
        List<Forum> topics = forumDao.getTopics();
        for (Forum forum : topics) {
            forum.setUser(userDao.getUserById(forum.getAuthor()));
            forum.setDisplayTime(DateFormat.stampToDate(forum.getDate().getTime()));
        }
        return topics;
    }

    public List<Forum> searchByKey(String key) {
        List<Forum> topics = forumDao.searchByKey(key);
        for (Forum forum : topics) {
            forum.setUser(userDao.getUserById(forum.getAuthor()));
            forum.setDisplayTime(DateFormat.stampToDate(forum.getDate().getTime()));
        }
        return topics;
    }

    public List<Comment> getComments(Integer id) {
        List<Comment> comments = forumDao.getComments(id);
        for (Comment comment : comments) {
            comment.setDisplayTime(DateFormat.stampToDate(comment.getDate().getTime()));
            comment.setUser(userDao.getUserById(comment.getReviewer()));
            List<Reply> replies = forumDao.getReplies(comment.getId());
            for (Reply reply : replies) {
                reply.setDisplayTime(DateFormat.stampToDate(reply.getDate().getTime()));
                reply.setUser(userDao.getUserById(reply.getSender()));
                reply.setReceiveUser(userDao.getUserById(reply.getReceiver()));
            }
            comment.setChildren(replies);
        }
        return comments;
    }

    public List<Comment> replyComment(Reply reply) {
        reply.setDate(new Date());
        forumDao.replyComment(reply);
        Comment commentById = forumDao.getCommentById(reply.getCommentId());
        forumDao.changeCommentNum(commentById.getTopicId());
        return getComments(commentById.getTopicId());
    }

    public List<Forum> addTopic(Forum forum) {
        forumDao.addTopic(forum);
        return forumDao.getTopics();
    }

    public void addComment(Comment comment) {
        comment.setDate(new Date());
        forumDao.addComment(comment);
        forumDao.changeCommentNum(comment.getTopicId());
    }
}