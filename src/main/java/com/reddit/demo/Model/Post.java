package com.reddit.demo.Model;

import javax.persistence.*;

@Entity
@Table(name="PostTomas")
public class Post {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String url;
    private long votes;

    @ManyToOne
    private User user;

    public Post(String title, String url, long votes) {
        this.title = title;
        this.url = url;
        this.votes = votes;
    }

    public Post() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getVotes() {
        return votes;
    }

    public void setVotes(long votes) {
        this.votes = votes;
    }
}
