package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.databaseModels.Book;
import org.softwire.training.bookish.databaseModels.BookCopy;
import org.softwire.training.bookish.services.BookCopyService;
import org.softwire.training.bookish.services.BookService;
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

    @Autowired
    private BookService bookService;

    @RequestMapping("/bookCopy")
    ModelAndView bookCopies(@RequestParam int bookId) {

        List<BookCopy> allCopies = bookCopyService.getAllBooks(bookId);
        Book book = bookService.getBook(bookId);

        BookCopiesPageModel bookCopiesPageModel = new BookCopiesPageModel();
        bookCopiesPageModel.copies = allCopies;
        bookCopiesPageModel.book = book;

        return new ModelAndView("bookCopy", "model", bookCopiesPageModel);
    }

    @RequestMapping("/bookCopy/add")
    RedirectView addBookCopy(@ModelAttribute BookCopy bookCopy) {

        bookCopyService.addBookCopy(bookCopy);

        return new RedirectView("/bookCopy?bookId=" + bookCopy.getBookId());
    }

//    @RequestMapping("/bookCopy/add")
//    RedirectView addBookCopy(@RequestParam int bookId, @RequestParam int barcode) {
//
//        bookCopyService.addBookCopy(bookId, barcode);
//
//        return new RedirectView("/bookCopy");
//    }

    @RequestMapping("/bookCopy/delete")
    RedirectView deleteBookCopy(@RequestParam int copyId, @RequestParam int bookId) {

        bookCopyService.deleteBookCopy(copyId);

        return new RedirectView("/bookCopy?bookId=" );
    }

    @RequestMapping("/bookCopy/deleteBook")
    RedirectView deleteBook(@RequestParam int bookId) {
        bookCopyService.deleteBook(bookId);

        return new RedirectView("/books");
    }
}
