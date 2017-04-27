package com.brina.service;

import com.brina.model.User;

public interface UserService {

    User findUser(User user);

    User addUser(User user);

}
