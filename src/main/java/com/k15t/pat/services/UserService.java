package com.k15t.pat.services;

import com.k15t.pat.pojos.User;
import com.k15t.pat.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements com.k15t.pat.services.Service<User, Long> {

    private final UserRepository userRepository;

    @Autowired
    public UserService (UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User save (User user) {
        if (user == null) return null;
        return userRepository.save(user);
    }


    @Override
    public Iterable<User> findAll (Iterable<Long> iterable) {
        ArrayList<User> usersList = new ArrayList<>();
        for (Long current : iterable) {
            if (userRepository.findById(current).isPresent()) {
                User user = userRepository.findById(current).get();
                usersList.add(user);
            }
        }
        return usersList;
    }

    @Override
    public long count () {
        return userRepository.count();
    }

    @Override
    public User findOne (Long aLong) {
        if (userRepository.findById(aLong).isPresent()) {
            User user = userRepository.findById(aLong).get();
            return user;
        }
        return null;
    }

    @Override
    public boolean exists (Long aLong) {
        return userRepository.existsById(aLong);
    }

    @Override
    public Iterable<User> findAll () {
        return userRepository.findAll();
    }

    @Override
    public void delete (Long aLong) {
        if (userRepository.findById(aLong).isPresent()) {
            User user = userRepository.findById(aLong).get();
            userRepository.delete(user);
        }

    }

    @Override
    public void delete (User user) {
        if (user == null) return;
        userRepository.delete(user);
    }

    @Override
    public void deleteAll () {
        userRepository.deleteAll();
        ;

    }
}
