package com.training.controller;


import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.training.entity.User;


@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    private static final User USER_1 = new User(1L, "David", Arrays.asList("david"), 26, "david@xyz.com");
    private static final User USER_2 = new User(2L, "Tania", Arrays.asList("tania"), 26, "tania@xyz.com");
    private static final User USER_3 = new User(3L, "Aaron", Arrays.asList("aaron"), 30, "aaron@xyz.com");

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public User findById(@PathVariable Long userId) throws Exception {
        LOG.info("Find user by id: {}", userId);
        if (userId.equals(1L)) {
            return USER_1;
        } else if (userId.equals(2L)) {
            return USER_2;
        } else if (userId.equals(3L)) {
            return USER_3;
        } else {
            throw new Exception("I just created 1 user to test!");
        }
    }

}
