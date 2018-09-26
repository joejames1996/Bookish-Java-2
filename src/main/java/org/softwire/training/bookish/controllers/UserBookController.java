package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.databaseModels.Book;
import org.softwire.training.bookish.databaseModels.BookCopy;
import org.softwire.training.bookish.databaseModels.BookingQuery;
import org.softwire.training.bookish.databaseModels.User;
import org.softwire.training.bookish.services.*;
import org.softwire.training.bookish.viewModels.BookCopiesPageModel;
import org.softwire.training.bookish.viewModels.UserBookPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class UserBookController
{
    @Autowired
    private UserBookService userBookService;

    @Autowired
    private UserService userService;

    @RequestMapping("/users/books")
    ModelAndView bookCopies(@RequestParam int userId) {

        List<BookingQuery> bookings = userBookService.getAllBookings(userId);
        User user = userService.getUser(userId);

        UserBookPageModel userBookPageModel = new UserBookPageModel();
        userBookPageModel.bookings = bookings;
        userBookPageModel.user = user;

        return new ModelAndView("userBooks", "model", userBookPageModel);
    }

//    @RequestMapping("/bookCopy/add")
//    RedirectView addBookCopy(@ModelAttribute BookCopy bookCopy) {
//
//        bookCopyService.addBookCopy(bookCopy);
//
//        return new RedirectView("/bookCopy?bookId=" + bookCopy.getBookId());
//    }
//
//    @RequestMapping("/bookCopy/delete")
//    RedirectView deleteBookCopy(@RequestParam int copyId, @RequestParam int bookId) {
//
//        bookCopyService.deleteBookCopy(copyId);
//
//        return new RedirectView("/bookCopy?bookId=" + bookId);
//    }
//
//    @RequestMapping("/bookCopy/deleteBook")
//    RedirectView deleteBook(@RequestParam int bookId) {
//
//        generalService.deleteBook(bookId);
//
//        return new RedirectView("/books");
//    }
}
