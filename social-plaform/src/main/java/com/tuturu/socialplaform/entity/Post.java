package com.tuturu.socialplaform.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private int id;
    @ManyToOne(cascade ={CascadeType.PERSIST,CascadeType.MERGE
            ,CascadeType.DETACH,CascadeType.REFRESH} )
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="content",columnDefinition = "TEXT")
    private String content;

    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @OneToMany(mappedBy = "post",
            cascade ={CascadeType.PERSIST,CascadeType.MERGE
                    ,CascadeType.DETACH,CascadeType.REFRESH})
    private List<Comment> comments;

    private Post(){

    }

    public Post(String content, Date dateTime) {
        this.content = content;
        this.createAt = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public void setCreateAt(Date dateTime) {
        this.createAt = dateTime;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", user=" + user +
                ", content='" + content + '\'' +
                ", dateTime=" + createAt +
                '}';
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void addComment(Comment tempComment){
        if(comments==null){
            comments=new ArrayList<>();
        }
        comments.add(tempComment);
        tempComment.setPost(this);
    }

}
