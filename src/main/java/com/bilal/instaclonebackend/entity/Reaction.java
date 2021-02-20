package com.bilal.instaclonebackend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Reaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer reaction_id;
    private String reactor;
    private String post;
    private String reaction;
    private Date time;

    public Reaction() {
    }

    public Reaction(String reactor, String post, String reaction, Date time) {
        this.reactor = reactor;
        this.post = post;
        this.reaction = reaction;
        this.time = time;
    }

    public Integer getReaction_id() {
        return reaction_id;
    }

    public void setReaction_id(Integer reaction_id) {
        this.reaction_id = reaction_id;
    }

    public String getReactor() {
        return reactor;
    }

    public void setReactor(String reactor) {
        this.reactor = reactor;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getReaction() {
        return reaction;
    }

    public void setReaction(String reaction) {
        this.reaction = reaction;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Reaction{" +
                "reaction_id=" + reaction_id +
                ", reactor='" + reactor + '\'' +
                ", post='" + post + '\'' +
                ", reaction='" + reaction + '\'' +
                ", time=" + time +
                '}';
    }
}
