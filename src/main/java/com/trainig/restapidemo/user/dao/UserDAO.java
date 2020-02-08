package com.trainig.restapidemo.user.dao;

import com.trainig.restapidemo.exceptions.UserAlreadyExistException;
import com.trainig.restapidemo.exceptions.UserNotFoundException;
import com.trainig.restapidemo.user.bean.User;

import java.util.List;

public interface UserDAO {

    List<User> findAll();

    User findById(Integer id) throws UserNotFoundException;

    User save(User user) throws UserAlreadyExistException;

    User delete (Integer id) throws UserNotFoundException;
}
