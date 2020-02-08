package com.trainig.restapidemo.user.dao;

import com.trainig.restapidemo.user.bean.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAUserDAO extends JpaRepository<UserBean, Integer> {
}
