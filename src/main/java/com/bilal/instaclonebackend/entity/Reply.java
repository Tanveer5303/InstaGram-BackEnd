package com.bilal.instaclonebackend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer reply_id;
    private String reply;
    private String reply_user;
    private String post;
    private String comment;
    private Date date;

    public Reply() {
    }

    public Reply(String reply, String reply_user, String post, String comment, Date date) {
        this.reply = reply;
        this.reply_user = reply_user;
        this.post = post;
        this.comment = comment;
        this.date = date;
    }

    public Integer getReply_id() {
        return reply_id;
    }

    public void setReply_id(Integer reply_id) {
        this.reply_id = reply_id;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getReply_user() {
        return reply_user;
    }

    public void setReply_user(String reply_user) {
        this.reply_user = reply_user;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "reply_id=" + reply_id +
                ", reply='" + reply + '\'' +
                ", reply_user='" + reply_user + '\'' +
                ", post='" + post + '\'' +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                '}';
    }
}
