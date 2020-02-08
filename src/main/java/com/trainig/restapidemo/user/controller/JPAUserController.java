package com.trainig.restapidemo.user.controller;

import com.trainig.restapidemo.exceptions.UserNotFoundException;
import com.trainig.restapidemo.user.bean.Post;
import com.trainig.restapidemo.user.bean.PostDTO;
import com.trainig.restapidemo.user.bean.User;
import com.trainig.restapidemo.user.bean.UserDTO;
import com.trainig.restapidemo.user.bean.mapper.PostMapper;
import com.trainig.restapidemo.user.bean.mapper.UserMapper;
import com.trainig.restapidemo.user.service.JPAPostService;
import com.trainig.restapidemo.user.service.JPAUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/jpa/users")
public class JPAUserController {

    private final JPAUserService userService;
    private final JPAPostService postService;
    private final UserMapper userMapper;
    private final PostMapper postMapper;

    public JPAUserController(JPAUserService userService, JPAPostService postService, UserMapper userMapper, PostMapper postMapper) {
        this.userService = userService;
        this.postService = postService;
        this.userMapper = userMapper;
        this.postMapper = postMapper;
    }

    @GetMapping
    public ResponseEntity<Object> retrieveAllUsers() {
        return new ResponseEntity<>(userService.retrieveAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> retrieveUserById(@PathVariable Integer id) throws UserNotFoundException {
        return new ResponseEntity<>(userService.retrieveUserById(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<Object> retrieveUserPosts(@PathVariable Integer id) throws UserNotFoundException {
        return new ResponseEntity<>(userService.retrieveUserById(id).getPosts(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> saveUser(@Valid @RequestBody UserDTO userDTO) {
        User user = userMapper.dtoToBean(userDTO);
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/{id}/post")
    public ResponseEntity<Object> savePost(@PathVariable Integer id,@RequestBody PostDTO postDTO) throws UserNotFoundException {
        Post post = postMapper.dtoToBean(postDTO);
        post.setUser(userService.retrieveUserById(id));
        return new ResponseEntity<>(postService.savePost(post), HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) throws UserNotFoundException {
        userService.deleteUser(id);
    }


}
