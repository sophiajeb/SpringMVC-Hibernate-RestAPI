package com.mycompany.theatricalplays.controller;

import com.mycompany.theatricalplays.model.User;
import com.mycompany.theatricalplays.service.UserService;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin(maxAge = 3600)
@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    UserService service;

    /*--------------------- USER -------------------------------------------------------------------*/
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String login(@ModelAttribute("login") User user,
            BindingResult result) {

        return "login";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String login(@Valid User u, BindingResult result,
            ModelMap model) {

        if (result.hasErrors()) {
            return "registration";
        } else {
            List<User> users = service.findAllUsers();
            model.addAttribute("user", users);
            return "index";
        }
    }

    @RequestMapping(value = {"/users", "/list"}, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {

        List<User> users = service.findAllUsers();
        model.addAttribute("user", users);
        return "index";
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String newUser(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        return "registration";
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result,
            ModelMap model) {

        if (result.hasErrors()) {
            return "registration";
        }

        service.saveUser(user);

        model.addAttribute("success", "User " + user.getUsername() + " registered successfully");
        return "success";
    }

    /*
	 * This method will provide the medium to update an existing employee.
     */
    @RequestMapping(value = {"/edit-{user_id}-user"}, method = RequestMethod.GET)
    public String editUser(@PathVariable String user_id, ModelMap model) {
        User user = service.findById(Integer.parseInt(user_id));
        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        return "registration";
    }

    /*
	 * This method will be called on form submission, handling POST request for
	 * updating employee in database. It also validates the user input
     */
    @RequestMapping(value = {"/edit-{user_id}-user"}, method = RequestMethod.POST)
    public String updateUser(@Valid User user, BindingResult result,
            ModelMap model, @PathVariable String user_id) {

        if (result.hasErrors()) {
            return "registration";
        }

        service.updateUser(user);

        model.addAttribute("success", "User " + user.getFirst_name() + user.getLast_name() + " updated successfully");
        return "success";
    }

    @RequestMapping(value = {"/delete-{user_id}-user"}, method = RequestMethod.GET)
    public String deleteUser(@PathVariable String user_id) {
        service.deleteUserById(Integer.parseInt(user_id));
        return "redirect:/list";
    }

}
