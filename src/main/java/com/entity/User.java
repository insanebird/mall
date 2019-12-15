package com.entity;

import java.util.Date;
import java.util.List;

public class User {
    private int id;
    private String name;
    private Date birthday;
    private String image;
    private int identity;
    private String username;
    private String password;
    private int isRetailer;
    private String displayTime;
    private int isSpeak;
    private List<Forum> topics;
    private int isAdmin;

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public List<Forum> getTopics() {
        return topics;
    }

    public void setTopics(List<Forum> topics) {
        this.topics = topics;
    }

    public int getIsSpeak() {
        return isSpeak;
    }

    public void setIsSpeak(int isSpeak) {
        this.isSpeak = isSpeak;
    }

    public String getDisplayTime() {
        return displayTime;
    }

    public void setDisplayTime(String displayTime) {
        this.displayTime = displayTime;
    }

    public int getIsRetailer() {
        return isRetailer;
    }

    public void setIsRetailer(int isRetailer) {
        this.isRetailer = isRetailer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
