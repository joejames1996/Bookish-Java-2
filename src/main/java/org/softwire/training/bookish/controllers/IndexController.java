package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.databaseModels.Book;
import org.softwire.training.bookish.databaseModels.User;
import org.softwire.training.bookish.services.BookService;
import org.softwire.training.bookish.services.UserService;
import org.softwire.training.bookish.viewModels.BooksPageModel;
import org.softwire.training.bookish.viewModels.UsersPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

/**
 * Controller for the index page
 */
@Controller
public class IndexController
{
    @RequestMapping("/")
    ModelAndView home() {
        return new ModelAndView("index");
    }
}
