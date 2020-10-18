/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.theatricalplays.dao;

import com.mycompany.theatricalplays.model.User;
import java.util.List;

/**
 *
 * @author user
 */
public interface UserDao {

    User findById(int user_id);
    
    boolean isAdmin(String GoogleId);

    User findByUsername(String username);

    List<User> findAllUsers();

    void saveUser(User user);

    void deleteUserById(int user_id);

}
