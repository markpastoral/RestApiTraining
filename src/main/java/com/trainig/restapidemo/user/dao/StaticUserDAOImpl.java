package com.trainig.restapidemo.user.dao;

import com.trainig.restapidemo.exceptions.UserAlreadyExistException;
import com.trainig.restapidemo.exceptions.UserNotFoundException;
import com.trainig.restapidemo.user.bean.User;
import com.trainig.restapidemo.user.bean.UserBeanBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Primary
@Repository("staticUserDAO")
public class StaticUserDAOImpl implements UserDAO {

    private static List<User> users = new ArrayList<>();
    private static Integer userCount = 0;

    static {
        users.add(new UserBeanBuilder().setId(++userCount).setName("test1").setBirthDate(LocalDate.now()).createUserBean());
        users.add(new UserBeanBuilder().setId(++userCount).setName("test2").setBirthDate(LocalDate.now()).createUserBean());
        users.add(new UserBeanBuilder().setId(++userCount).setName("test3").setBirthDate(LocalDate.now()).createUserBean());
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findById(Integer id) throws UserNotFoundException {
        return users.stream().filter(user -> user.getId().equals(id)).findAny().orElseThrow(() -> new UserNotFoundException(String.format("User with id %d not found", id)));
    }

    @Override
    public User save(User user) throws UserAlreadyExistException {
        if (user.getId() == null) {
            user.setId(incrementUserCount());
        } else if (users.contains(user)) {
            throw new UserAlreadyExistException(String.format("User with id %d already exists", user.getId()));
        }

        users.add(user);
        return user;
    }

    @Override
    public User delete(Integer id) throws UserNotFoundException {
        Iterator<User> userIterator = users.iterator();

        while (userIterator.hasNext()) {
            User user = userIterator.next();
            if (user.getId().equals(id)) {
                userIterator.remove();
                return user;
            }
        }

        throw new UserNotFoundException(String.format("User with id %d not found", id));
    }

    private static Integer incrementUserCount() {
        return ++userCount;
    }
}
