package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.databaseModels.Book;
import org.softwire.training.bookish.databaseModels.CopyQuery;
import org.softwire.training.bookish.services.BookService;
import org.softwire.training.bookish.viewModels.BooksPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class BookController
{
    @Autowired
    private BookService bookService;

    @RequestMapping("/books")
    ModelAndView books() {

        List<CopyQuery> allCopies = bookService.getAllBooks();

        BooksPageModel booksPageModel = new BooksPageModel();
        booksPageModel.copies = allCopies;

        return new ModelAndView("books", "model", booksPageModel);
    }

    @RequestMapping("/books/add")
    RedirectView addBook(@ModelAttribute Book book) {

        bookService.addBook(book);

        return new RedirectView("/books");
    }

    @RequestMapping("/books/delete")
    RedirectView deleteBook(@RequestParam int bookId) {

        bookService.deleteBook(bookId);

        return new RedirectView("/books");
    }

}
