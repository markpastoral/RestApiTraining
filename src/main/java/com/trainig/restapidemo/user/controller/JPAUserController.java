package com.trainig.restapidemo.user.controller;

import com.trainig.restapidemo.exceptions.UserNotFoundException;
import com.trainig.restapidemo.user.bean.User;
import com.trainig.restapidemo.user.bean.UserDTO;
import com.trainig.restapidemo.user.bean.UserMapper;
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
    private final UserMapper userMapper;

    public JPAUserController(JPAUserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public ResponseEntity<List<User>> retrieveAllUsers() {
        return new ResponseEntity<>(userService.retrieveAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> retrieveUserById(@PathVariable Integer id) throws UserNotFoundException {
        return new ResponseEntity<>(userService.retrieveUserById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@Valid @RequestBody UserDTO userDTO) {
        User user = userMapper.dtoToBean(userDTO);
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) throws UserNotFoundException {
        userService.deleteUser(id);
    }


}
