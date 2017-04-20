package com.brina.controler.dao;

import com.brina.controler.model.User;

public interface UserDao {

    User findByName(User user);
}
