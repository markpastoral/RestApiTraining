package com.trainig.restapidemo.user.service;

import com.trainig.restapidemo.exceptions.PostNotFoundException;
import com.trainig.restapidemo.user.bean.Post;
import com.trainig.restapidemo.user.dao.JPAPostDAO;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JPAPostService {

    private final JPAPostDAO jpaPostDAO;

    public JPAPostService(JPAPostDAO jpaPostDAO) {
        this.jpaPostDAO = jpaPostDAO;
    }

    public List<Post> retrieveAllPost() {
        return jpaPostDAO.findAll();
    }

    public Post retrievePostById(Integer id) throws PostNotFoundException {
        return jpaPostDAO.findById(id).orElseThrow(() -> new PostNotFoundException(String.format("Post with id %d not found", id)));
    }

    public Post savePost(Post bean) {
        return jpaPostDAO.save(bean);
    }

    public void deletePost(Integer id) throws PostNotFoundException {
        try {
            jpaPostDAO.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new PostNotFoundException(String.format("Post with id %d not found", id));
        }
    }


}
