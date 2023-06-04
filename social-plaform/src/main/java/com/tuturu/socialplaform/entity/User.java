package com.tuturu.socialplaform.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;
    @Column(name = "user_name")
    private String userName;

    @Column(name = "email",unique = true)
    @Email
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_number",unique = true)
    private String phoneNumber;

    @Column(name = "cover_image")
    private String coverImage;
    @Column(name = "biography",columnDefinition = "TEXT")
    private String biography;

    @OneToMany(mappedBy = "user",
            cascade ={CascadeType.PERSIST,CascadeType.MERGE
                    ,CascadeType.DETACH,CascadeType.REFRESH})
    private List<Post> posts;

    @OneToMany(mappedBy = "user",
            cascade ={CascadeType.PERSIST,CascadeType.MERGE
                    ,CascadeType.DETACH,CascadeType.REFRESH})
    private List<Comment> comments;




    public User(){

    }

    public User(String userName, String email, String phoneNumber, String coverImage, String biography) {
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.coverImage = coverImage;
        this.biography = biography;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", coverImage='" + coverImage + '\'' +
                ", biography='" + biography + '\'' +
                '}';
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void addPost(Post tempPost){
        if(posts==null){
            posts=new ArrayList<>();
        }
        posts.add(tempPost);
        tempPost.setUser(this);
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
        tempComment.setUser(this);
    }


}
