package org.softwire.training.bookish.services;

import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.databaseModels.Book;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {
    private String hostname = "10.210.11.106:3306";
    private String database = "bookish";
    private String user = "bookish";
    private String password = "4q1WIfvybxBN";
    private String connectionString = "jdbc:mysql://" + hostname + "/" + database + "?user=" + user + "&password=" + password + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT&useSSL=false&allowPublicKeyRetrieval=true";

    private Jdbi jdbi = Jdbi.create(connectionString);

    public List<Book> getAllBooks() {
        List<Book> books = jdbi.withHandle(handle ->
            handle.createQuery("SELECT * FROM books")
                .mapToBean(Book.class)
                .list()
        );

        return books;
    }

    public void addBook(Book book) {
        jdbi.withHandle(handle ->
            handle.createUpdate("INSERT INTO books (title, subtitle, author, isbn) VALUES (:title, :subtitle, :author, :isbn)")
                .bindBean(book)
                .execute()
        );
    }

    public void deleteBook(int bookId) {
        jdbi.withHandle(handle ->
            handle.createUpdate("DELETE FROM books WHERE bookId = :id")
                .bind("id", bookId)
                .execute()
        );
    }
}
