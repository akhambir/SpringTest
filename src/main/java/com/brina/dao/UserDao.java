package com.brina.dao;

import com.brina.model.User;

public interface UserDao {

    User findUser(User user);

    User addUser(User user);
}
