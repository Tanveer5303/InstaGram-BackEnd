package com.bilal.instaclonebackend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer post_id;
    private String text;
    private String image_url;
    private Date time;

    public Post() {
    }

    public Post(Integer post_id, String text, String image_url, Date time) {
        this.post_id = post_id;
        this.text = text;
        this.image_url = image_url;
        this.time = time;
    }

    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Post{" +
                "post_id=" + post_id +
                ", text='" + text + '\'' +
                ", image_url='" + image_url + '\'' +
                ", time=" + time +
                '}';
    }
}
