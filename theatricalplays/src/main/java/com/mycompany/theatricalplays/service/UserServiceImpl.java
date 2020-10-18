/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.theatricalplays.service;

import com.mycompany.theatricalplays.dao.UserDao;
import com.mycompany.theatricalplays.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user
 */
@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    public User findById(int user_id) {
        return dao.findById(user_id);
    }

    public User findByUsername(String username) {
        // need to implement it in UserDaoImpl
        return dao.findByUsername(username);
    }

    public List<User> findAllUsers() {
        return dao.findAllUsers();
    }

    public void saveUser(User user) {
        dao.saveUser(user);
    }

    public void deleteUserById(int user_id) {
        dao.deleteUserById(user_id);
    }

    public void updateUser(User user) {
        User entity = dao.findById(user.getUser_id());
        if (entity != null) {
            entity.setUsername(user.getUsername());
            entity.setPassword(user.getPassword());
            entity.setFirst_name(user.getFirst_name());
            entity.setLast_name(user.getLast_name());
            entity.setMobile_phone(user.getMobile_phone());
            entity.setEmail(user.getEmail());
//            entity.setRole(user.getRole());
            entity.setPhoto(user.getPhoto());
            entity.setRole("USER");
        }
    }

    // check if he is admin
    @Override
    public boolean isAdmin(String googleId) {
        if(!dao.isAdmin(googleId)) 
            return false; 
        else 
            return true;
    }

}
