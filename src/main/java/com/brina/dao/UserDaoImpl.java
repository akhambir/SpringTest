package com.brina.dao;

import com.brina.model.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findUser(User user) {
        String hql = "from User where name = :name";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString("name", user.getName());
        return (User) query.uniqueResult();
    }

    @Override
    public User addUser(User user) {
        Integer userId = (Integer) sessionFactory.getCurrentSession().save(user);
        return (User) sessionFactory.getCurrentSession().get(User.class, userId);
    }
}
