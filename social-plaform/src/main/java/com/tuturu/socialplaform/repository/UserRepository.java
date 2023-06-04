package com.tuturu.socialplaform.repository;

import com.tuturu.socialplaform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Integer> {
}
