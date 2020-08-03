package com.k15t.pat.controllers;

import com.k15t.pat.exception.UserIdMissMatchException;
import com.k15t.pat.exception.UserNotFoundException;
import com.k15t.pat.pojos.User;
import com.k15t.pat.services.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

//REST BACKEND
@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserRestController {

    private final UserService userService;

    public UserRestController (UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(path = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    User findById (@PathVariable Long id) {
        User user = userService.findOne(id);
        if (user == null) {

            throw new UserNotFoundException("USER NOT FOUND", new Throwable());
        }
        return user;
    }


    @RequestMapping(path = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    User save (@RequestBody User user) {
        if (user == null) return null;
        return userService.save(user);
    }

    @RequestMapping(path = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Iterable<User> findAll () {
        return userService.findAll();
    }

    @RequestMapping(path = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    User deleteUser (@PathVariable Long id) {
        User user = userService.findOne(id);
        userService.delete(id);
        return user;
    }

    @RequestMapping(path = "/", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    User deleteUser (@RequestBody User user) {
        if (user == null) return null;
        userService.delete(user);
        return user;
    }

    @RequestMapping(path = "/update/{id}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    User updateUser (@RequestBody User user, @PathVariable Long id) {
        if (user == null) return null;

        if (user.getId().equals(id)) {
            throw new UserIdMissMatchException("ID MISSMATCH", new Throwable());
        }
        return userService.save(user);
    }
}
