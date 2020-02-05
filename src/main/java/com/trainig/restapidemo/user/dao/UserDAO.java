package com.trainig.restapidemo.user.dao;

import com.trainig.restapidemo.exceptions.UserAlreadyExistException;
import com.trainig.restapidemo.exceptions.UserNotFoundException;
import com.trainig.restapidemo.user.bean.UserBean;

import java.util.List;

public interface UserDAO {

    List<UserBean> findAll();

    UserBean findById(Integer id) throws UserNotFoundException;

    UserBean save(UserBean user) throws UserAlreadyExistException;

    UserBean delete (Integer id) throws UserNotFoundException;
}
