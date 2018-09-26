package org.softwire.training.bookish.services;

import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.databaseModels.BookCopy;
import org.softwire.training.bookish.databaseModels.BookingQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBookService
{
    private String hostname = "10.210.11.106:3306";
    private String database = "bookish";
    private String user = "bookish";
    private String password = "4q1WIfvybxBN";
    private String connectionString = "jdbc:mysql://" + hostname + "/" + database + "?user=" + user + "&password=" + password + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT&useSSL=false&allowPublicKeyRetrieval=true";

    private Jdbi jdbi = Jdbi.create(connectionString);

    public List<BookingQuery> getAllBookings(int userId) {
        List<BookingQuery> bookings = jdbi.withHandle(handle ->
            handle.createQuery("SELECT copies.copyId, bookings.userId, books.title, books.author, books.isbn, copies.barcode, bookings.dateTaken, bookings.dateDue " +
                    "FROM bookish.copies " +
                    "JOIN bookish.books ON books.bookId = copies.bookId " +
                    "LEFT JOIN bookish.bookings ON copies.copyId = bookings.copyId " +
                    "WHERE bookings.userId = :id " +
                    "ORDER BY books.author, books.title, copies.barcode"
                    )
                    .bind("id", userId)
                    .mapToBean(BookingQuery.class)
                    .list()
        );

        return bookings;
    }
}
