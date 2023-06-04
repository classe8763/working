package com.tuturu.socialplaform.entity;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="comment_id")
    private int id;
    @Column(name="content")
    private String content;

    @Column(name="create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @ManyToOne(cascade ={CascadeType.PERSIST,CascadeType.MERGE
            ,CascadeType.DETACH,CascadeType.REFRESH} )
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne(cascade ={CascadeType.PERSIST,CascadeType.MERGE
            ,CascadeType.DETACH,CascadeType.REFRESH} )
    @JoinColumn(name="post_id")
    private Post post;

    private Comment(){

    }

    public Comment(String content, Date createAt) {
        this.content = content;
        this.createAt = createAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", createAt=" + createAt +
                ", user=" + user +
                ", post=" + post +
                '}';
    }



}
