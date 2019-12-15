package com.controller;

import com.entity.Comment;
import com.entity.Forum;
import com.entity.Reply;
import com.entity.SearchItem;
import com.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@ResponseBody
public class ForumController {
    @Autowired
    ForumService forumService;

    @RequestMapping(value = "/getTopics", method = RequestMethod.GET)
    public List<Forum> getTopics() {
        return forumService.getTopics();
    }

    @RequestMapping(value = "/searchByKey", method = RequestMethod.POST)
    public List<Forum> searchByKey(@RequestBody SearchItem searchItem) {
        return forumService.searchByKey(searchItem.getKey());
    }

    @RequestMapping(value = "/getTopicDetail", method = RequestMethod.POST)
    public List<Comment> getTopicDetail(@RequestBody Forum forum) {
        return forumService.getComments(forum.getId());
    }

    @RequestMapping(value = "/replyComment", method = RequestMethod.POST)
    public List<Comment> replyComment(@RequestBody Reply reply) {
        return forumService.replyComment(reply);
    }

    @RequestMapping(value = "/addTopic", method = RequestMethod.POST)
    public List<Forum> addTopic(@RequestBody Forum forum) {
        forum.setDate(new Date());
        return forumService.addTopic(forum);
    }

    @RequestMapping(value = "/addComment", method = RequestMethod.POST)
    public List<Comment> addComment(@RequestBody Comment comment) {
        forumService.addComment(comment);
        return forumService.getComments(comment.getTopicId());
    }
}