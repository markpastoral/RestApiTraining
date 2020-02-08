package com.trainig.restapidemo.user.service;

import com.trainig.restapidemo.exceptions.UserAlreadyExistException;
import com.trainig.restapidemo.exceptions.UserNotFoundException;
import com.trainig.restapidemo.user.bean.User;
import com.trainig.restapidemo.user.dao.UserDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserDAO userDAO;

    public UserService(@Qualifier("staticUserDAO") UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> retrieveAllUsers() {
        return userDAO.findAll();
    }

    public User retrieveUserById(Integer id) throws UserNotFoundException {
        return userDAO.findById(id);
    }

    public User saveUser(User bean) throws UserAlreadyExistException {
        return userDAO.save(bean);
    }

    public User deleteUser(Integer id) throws UserNotFoundException {
        return userDAO.delete(id);
    }

}
