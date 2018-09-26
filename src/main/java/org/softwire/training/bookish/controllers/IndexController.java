package org.softwire.training.bookish.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
