package org.softwire.training.bookish.services;

import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.databaseModels.Book;
import org.softwire.training.bookish.databaseModels.BookCopy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCopyService
{
    private String hostname = "10.210.11.106:3306";
    private String database = "bookish";
    private String user = "bookish";
    private String password = "4q1WIfvybxBN";
    private String connectionString = "jdbc:mysql://" + hostname + "/" + database + "?user=" + user + "&password=" + password + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT&useSSL=false&allowPublicKeyRetrieval=true";

    private Jdbi jdbi = Jdbi.create(connectionString);

    public List<BookCopy> getAllBooks() {
        List<BookCopy> books = jdbi.withHandle(handle ->
            handle.createQuery("SELECT copies.copyId, books.title, books.subtitle, books.author, books.isbn, copies.barcode " +
                    "FROM bookish.copies " +
                    "JOIN bookish.books ON books.bookId = copies.bookId " +
                    "ORDER BY books.author, books.title, copies.barcode")
                .mapToBean(BookCopy.class)
                .list()
        );

        return books;
    }

    public void addBookCopy(BookCopy bookCopy) {
        jdbi.withHandle(handle ->
            handle.createUpdate("INSERT INTO copies (bookId, barcode) VALUES (:bookId, :barcode)")
                .bindBean(bookCopy)
                .execute()
        );
    }

    public void deleteBookCopy(int copyId) {
        jdbi.withHandle(handle ->
            handle.createUpdate("DELETE FROM copies WHERE copyId = :id")
                .bind("id", copyId)
                .execute()
        );
    }
}
