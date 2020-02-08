package com.trainig.restapidemo.user.controller;

import com.trainig.restapidemo.exceptions.UserNotFoundException;
import com.trainig.restapidemo.user.bean.UserBean;
import com.trainig.restapidemo.user.service.JPAUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/jpa/users")
public class JPAUserController {

    private final JPAUserService userService;

    public JPAUserController(JPAUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserBean>> retrieveAllUsers() {
        return new ResponseEntity<>(userService.retrieveAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserBean> retrieveUserById(@PathVariable Integer id) throws UserNotFoundException {
        return new ResponseEntity<>(userService.retrieveUserById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserBean> saveUser(@Valid @RequestBody UserBean user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) throws UserNotFoundException {
        userService.deleteUser(id);
    }


}