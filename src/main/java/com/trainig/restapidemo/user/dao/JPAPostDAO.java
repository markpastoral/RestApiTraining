package com.trainig.restapidemo.user.dao;

import com.trainig.restapidemo.user.bean.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAPostDAO extends JpaRepository<Post, Integer> {
}
