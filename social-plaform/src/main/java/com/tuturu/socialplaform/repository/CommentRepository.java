package com.tuturu.socialplaform.repository;

import com.tuturu.socialplaform.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
}
