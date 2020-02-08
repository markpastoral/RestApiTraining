package com.trainig.restapidemo.user.service;

import com.trainig.restapidemo.exceptions.UserNotFoundException;
import com.trainig.restapidemo.user.bean.User;
import com.trainig.restapidemo.user.dao.JPAUserDAO;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JPAUserService {

    private final JPAUserDAO jpaUserDAO;

    public JPAUserService(JPAUserDAO jpaUserDAO) {
        this.jpaUserDAO = jpaUserDAO;
    }

    public List<User> retrieveAllUsers() {
        return jpaUserDAO.findAll();
    }

    public User retrieveUserById(Integer id) throws UserNotFoundException {
        return jpaUserDAO.findById(id).orElseThrow(() -> new UserNotFoundException(String.format("User with id %d not found", id)));
    }

    public User saveUser(User bean) {
        return jpaUserDAO.save(bean);
    }

    public void deleteUser(Integer id) throws UserNotFoundException {
        try {
            jpaUserDAO.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new UserNotFoundException(String.format("User with id %d not found", id));
        }
    }


}
