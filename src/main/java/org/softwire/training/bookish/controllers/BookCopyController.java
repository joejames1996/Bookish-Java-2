package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.databaseModels.Book;
import org.softwire.training.bookish.databaseModels.BookCopy;
import org.softwire.training.bookish.services.BookCopyService;
import org.softwire.training.bookish.viewModels.BookCopiesPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class BookCopyController
{
    @Autowired
    private BookCopyService bookCopyService;

    @RequestMapping("/bookCopy")
    ModelAndView bookCopies() {

        List<BookCopy> allCopies = bookCopyService.getAllBooks();

        BookCopiesPageModel bookCopiesPageModel = new BookCopiesPageModel();
        bookCopiesPageModel.copies = allCopies;

        return new ModelAndView("bookCopy", "model", bookCopiesPageModel);
    }

    @RequestMapping("/bookCopy/add")
    RedirectView addBookCopy(@ModelAttribute BookCopy bookCopy) {

        bookCopyService.addBookCopy(bookCopy);

        return new RedirectView("/bookCopy");
    }

    @RequestMapping("/bookCopy/delete")
    RedirectView deleteBookCopy(@RequestParam int copyId) {

        bookCopyService.deleteBookCopy(copyId);

        return new RedirectView("/bookCopy");
    }

}
