package com.k15t.pat.services;

import com.k15t.pat.pojos.User;

public interface Service<S, ID> {

    S save (S s);

    User findOne (Long aLong);

    boolean exists (Long aLong);

    Iterable<User> findAll ();

    void delete (Long aLong);

    void delete (User user);

    void deleteAll ();

    Iterable<User> findAll (Iterable<Long> iterable);

    long count ();
}
