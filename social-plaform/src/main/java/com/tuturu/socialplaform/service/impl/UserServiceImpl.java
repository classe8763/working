package com.tuturu.socialplaform.service.impl;

import ch.qos.logback.core.model.Model;
import com.tuturu.socialplaform.entity.User;
import com.tuturu.socialplaform.repository.UserRepository;
import com.tuturu.socialplaform.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private PasswordEncoder passwordEncoder= PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Autowired
    UserRepository userRepository;
    private EntityManager entityManager;

    @Autowired
    public UserServiceImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }

    @Override
    @Transactional
    public void save(User theUser) {
        theUser.setPassword(passwordEncoder.encode(theUser.getPassword()));
        entityManager.persist(theUser);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User userLogin(String phoneNumber,String password) {
        User theUser=this.findByUserPhone(phoneNumber);
        if(theUser==null){
            throw new RuntimeException("使用者不存在");
        }else{
            if(passwordEncoder.matches(password, theUser.getPassword())){
                return theUser;
            }
        }


        return null;
    }
    public User findByUserPhone(String phoneNumber) {

        Query query = entityManager.createQuery("select user from User user where user.phoneNumber = ?1");
        query.setParameter(1, phoneNumber);
        User theUser = (User) query.getSingleResult();
        return theUser;
    }


}
