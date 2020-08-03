package com.k15t.pat.builders;

import com.k15t.pat.pojos.User;

public class UserBuilder {


    private User user;

    public UserBuilder withId (Long id) {
        this.user = new User();
        this.user.setId(id);
        return this;
    }

    public UserBuilder name (String name) {
        this.user.setName(name);
        return this;
    }

    public UserBuilder email (String email) {
        this.user.setEmail(email);
        return this;
    }

    public UserBuilder number (String number) {
        this.user.setEmail(number);
        return this;
    }

    public UserBuilder password (String password) {
        this.user.setPassword(password);
        return this;
    }


    public User build () {
        return this.user;
    }
}