package com.dao;

import com.entity.Comment;
import com.entity.Forum;
import com.entity.Reply;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForumDao {
    @Select("select * from forum")
    public List<Forum> getTopics();

    @Select("select * from forum where topic like '%${key}%'")
    public List<Forum> searchByKey(String key);

    @Select("select * from comment where topic_id=#{id}")
    public List<Comment> getComments(Integer id);

    @Select("select * from reply where comment_id=#{id}")
    public List<Reply> getReplies(Integer id);

    @Insert("insert into reply (sender,content,date,comment_id,receiver) values (#{sender},#{content},#{date},#{commentId},#{receiver})")
    public void replyComment(Reply reply);

    @Insert("insert into forum (topic,date,author) values (#{topic},#{date},#{author})")
    public void addTopic(Forum forum);

    @Select("select * from forum where author=#{id}")
    public List<Forum> getTopicsByAuthor(Integer id);

    @Select("select * from comment where topic_id=#{param1} and reviewer=#{param2}")
    public List<Comment> getCommentByTopicIdAndUserId(Integer topicId, Integer userId);

    @Select("select * from reply where comment_id=#{param1} and sender=#{param2}")
    public List<Reply> getRepliesByCommentIdAndUserId(Integer commentId, Integer userId);

    @Insert("insert into comment (reviewer,content,topic_id,date) values(#{reviewer},#{content},#{topicId},#{date})")
    public void addComment(Comment comment);

    @Update("update forum set comment_num=comment_num+1 where id=#{id}")
    public void changeCommentNum(Integer id);

    @Select("select * from comment where id=#{id}")
    public Comment getCommentById(Integer id);
}