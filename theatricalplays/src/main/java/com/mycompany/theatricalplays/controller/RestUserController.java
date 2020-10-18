/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.theatricalplays.controller;

import com.mycompany.theatricalplays.model.User;
import com.mycompany.theatricalplays.service.UserService;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

/* based on this example http://websystique.com/springmvc/spring-mvc-4-restful-web-services-crud-example-resttemplate/ */
@CrossOrigin
@RestController
@RequestMapping("/api")

public class RestUserController {

    @Autowired
    UserService userService;  //Service which will do all data retrieval/manipulation work
    
    @Autowired
    private ServletContext servletContext;

    //-------------------Retrieve All Users--------------------------------------------------------
    // /theatricalplays/api/users
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userService.findAllUsers();
        System.out.println("no of users:" + users.size());
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); //You may decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //-------------------Retrieve Single User--------------------------------------------------------
    // /theatricalplays/api/user/{id}
    @RequestMapping(value = "/user/{user_id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("user_id") int user_id) {
        System.out.println("Fetching User with id " + user_id);
        User user = userService.findById(user_id);
        if (user == null) {
            System.out.println("User with id " + user_id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    
    //-------------------Retrieve Single User's Photo--------------------------------------------------------
    // /theatricalplays/api/user/{id}/photo
    @RequestMapping(value = "/user/{user_id}/photo", method = RequestMethod.GET)
    public ResponseEntity<Resource> getUserPhoto(@PathVariable("user_id") int user_id) {
        System.out.println("Fetching User's Photo with id " + user_id);
        System.out.println("servlet's path=" + servletContext.getRealPath("/userimages/"));
        User user = userService.findById(user_id);
        if (user == null) {
            System.out.println("User with id " + user_id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            final HttpHeaders headers = new HttpHeaders();
            Resource resource = new ServletContextResource(servletContext, "/userimages/" + user.getPhoto());
            return new ResponseEntity<>(resource, headers, HttpStatus.OK);
        }
    }
    
    //-------------------Save Single User's Photo--------------------------------------------------------
    // /theatricalplays/api/user/{id}/photo
    @RequestMapping(value = "/user/{user_id}/photo", method = RequestMethod.POST,consumes = {"multipart/form-data"})
    public boolean setUserPhoto(@RequestParam(value = "file") MultipartFile file, @PathVariable("user_id") int user_id) throws IOException {
        System.out.println("Saving User's Photo with id " + user_id);
        System.out.println("servlet's path=" + servletContext.getRealPath("/userimages/"));
        User user = userService.findById(user_id);
        if(user == null) {
            System.out.println("User with id " + user_id + " not found");
            return false;
        }
        else {
            try {
                byte[] bytes = file.getBytes();
                System.out.println("ftype="+file.getContentType().substring(6));
                String photoName = user_id + "." + file.getContentType().substring(6);
                File targetFile = new File(servletContext.getRealPath("/userimages/") + photoName);
                file.transferTo(targetFile);
                user.setPhoto(photoName);
                user.setRole("USER");
                System.out.println("user data=" + user);
                userService.updateUser(user);
                return true;
            } catch (IOException ex) {
                Logger.getLogger(RestUserController.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
    }

    //-------------------Create a User--------------------------------------------------------
    // /theatricalplays/api/user
    /* example for post / put
    {
        "username": "bbb",
        "password": "bbb",
        "first_name": "bbb",
        "last_name": "bbb",
        "mobile_phone": "12345",
        "email": "b@b",
        "role": "user"
    }
    */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + user.getUsername());

        if (userService.findByUsername(user.getUsername()) != null) {
            System.out.println("A User with username " + user.getUsername() + " already exist");
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        userService.saveUser(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{user_id}").buildAndExpand(user.getUser_id()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a User --------------------------------------------------------
    // /theatricalplays/api/user/{id}
    @RequestMapping(value = "/user/{user_id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("user_id") int user_id, @RequestBody User user) {
        System.out.println("Updating User " + user_id);

        User currentUser = userService.findById(user_id);

        if (currentUser == null) {
            System.out.println("User with id " + user_id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        currentUser.setFirst_name(user.getFirst_name());
        currentUser.setLast_name(user.getLast_name());
        currentUser.setEmail(user.getEmail());
        currentUser.setMobile_phone(user.getMobile_phone());
        currentUser.setRole(user.getRole());
        currentUser.setUsername(user.getUsername());
        currentUser.setPassword(user.getPassword());

        userService.updateUser(currentUser);
        return new ResponseEntity<>(currentUser, HttpStatus.OK);
    }

    //------------------- Delete a User --------------------------------------------------------
    // /theatricalplays/api/user/{id}
    @RequestMapping(value = "/user/{user_id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("user_id") int user_id) {
        System.out.println("Fetching & Deleting User with id " + user_id);

        User user = userService.findById(user_id);
        if (user == null) {
            System.out.println("Unable to delete. User with id " + user_id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        userService.deleteUserById(user_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
