package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.databaseModels.User;
import org.softwire.training.bookish.services.UserService;
import org.softwire.training.bookish.viewModels.UsersPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class UserController
{
    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    ModelAndView users() {

        List<User> allUsers = userService.getAllUsers();

        UsersPageModel usersPageModel = new UsersPageModel();
        usersPageModel.users = allUsers;

        return new ModelAndView("users", "model", usersPageModel);
    }

    @RequestMapping("/users/add")
    RedirectView addUser(@ModelAttribute User user) {

        userService.addUser(user);

        return new RedirectView("/users");
    }

    @RequestMapping("/users/delete")
    RedirectView deleteUser(@RequestParam int userId) {

        userService.deleteUser(userId);

        return new RedirectView("/users");
    }
}
