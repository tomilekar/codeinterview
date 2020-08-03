package com.k15t.pat;

import com.k15t.pat.pojos.User;
import com.k15t.pat.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

// USED TO LOAD TEST DATA ON INITALIZATION
@Component
public class DataLoader implements ApplicationRunner {

    private UserService userService;

    @Autowired
    public DataLoader (UserService userService) {
        this.userService = userService;
    }

    public void run (ApplicationArguments args) {
        User user = new User("Tomi Lekar", "tomi.lekar@outlook.de", "Passowrd", "+4915752476323");
        userService.save(user);
        user = new User("Jürgen ", "jrgen.@outlook.de", "Passowrd", "+4915752476323");
        userService.save(user);
        user = new User("Hans ", "hans.@outlook.de", "Passowrd", "+4915752476323");
        userService.save(user);
        user = new User("Jasmin ", "jasmin.@outlook.de", "Passowrd", "+4915752476323");
        userService.save(user);
        user = new User("Franziska ", "franziska.@outlook.de", "Passowrd", "+4915752476323");
        userService.save(user);

    }
}