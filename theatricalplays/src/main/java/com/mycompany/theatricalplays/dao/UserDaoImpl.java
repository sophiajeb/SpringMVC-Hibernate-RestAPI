/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.theatricalplays.dao;

import com.mycompany.theatricalplays.model.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository("UserDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

    @Override
    public User findById(int user_id) {
        return getByKey(user_id);
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public void saveUser(User user) {
        persist(user);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> findAllUsers() {
        Criteria criteria = createEntityCriteria();
        return (List<User>) criteria.list();
    }

    @Override
    public void deleteUserById(int user_id) {
        Query query = getSession().createSQLQuery("delete from User where user_id = :user_id");
        query.setInteger("user_id", user_id);
        query.executeUpdate();
    }

    // check if he is admin
    @Override
    public boolean isAdmin(String googleId) {
        // we need  to update the db so there is a field called googleId and 
        // store to this field his GoogleId when a user authenticating with his gmail account
        Query query = getSession().createQuery("from User where google_id = :googleId and role = 'ADMIN'");
        query.setString("googleId", googleId);
        List<User> users = query.list();
        if(users.isEmpty() || users.size() == 0) 
            return false;
        else
            return true;
    }
}
