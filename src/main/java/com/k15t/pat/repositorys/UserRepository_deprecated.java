package com.k15t.pat.repositorys;

import com.k15t.pat.pojos.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Optional;

// DEPECATED_ JUST FOR TESTING PURPOSES
// BETTER USE JPA + H2 Database
@Repository
public class UserRepository_deprecated {


    public String MESSAGE = "";
    private HashMap<String, User> registredUsers = new HashMap<>();
    private User createdUser = null;

    public Optional<User> saveUser (User user) {
        if (user == null) {
            this.MESSAGE = "Error Creating User";
            return Optional.ofNullable(user);
        }
        final String email = user.getEmail();
        if (registredUsers.containsKey(email)) return Optional.ofNullable(registredUsers.get(email));
        this.registredUsers.put(email, user);
        this.createdUser = user;
        this.MESSAGE = "Created User: " + user.getEmail();
        return Optional.of(user);
    }


    public Optional<User> getUserInformationByEmail (String email) {
        if (email.isEmpty()) return Optional.empty();
        User user = this.registredUsers.get(email);
        return Optional.ofNullable(user);

    }

    public HashMap<String, User> getRegistredUsers () {
        return registredUsers;
    }


    public User getCreatedUser () {
        return createdUser;
    }

}
