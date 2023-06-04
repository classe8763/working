package com.tuturu.socialplaform.service;

import ch.qos.logback.core.model.Model;
import com.tuturu.socialplaform.entity.User;

import java.util.List;

public interface UserService {

    void save(User theUuser);

    List<User> findAll();

    User userLogin(String phoneNumber,String password);

}
