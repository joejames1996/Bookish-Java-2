package org.softwire.training.bookish.services;

import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.databaseModels.Booking;
import org.softwire.training.bookish.databaseModels.BookingQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService
{
    private String hostname = "10.210.11.106:3306";
    private String database = "bookish";
    private String user = "bookish";
    private String password = "4q1WIfvybxBN";
    private String connectionString = "jdbc:mysql://" + hostname + "/" + database + "?user=" + user + "&password=" + password + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT&useSSL=false&allowPublicKeyRetrieval=true";

    private Jdbi jdbi = Jdbi.create(connectionString);

    public List<BookingQuery> getAllBookings() {
        List<BookingQuery> bookings = jdbi.withHandle(handle ->
                handle.createQuery("SELECT bookings.bookingId, copies.copyId, users.userId, books.title, books.author, books.isbn, copies.barcode, users.firstName, users.surname, bookings.dateTaken, bookings.dateDue " +
                        "FROM bookish.bookings " +
                        "JOIN bookish.copies ON copies.copyId = bookings.copyId " +
                        "JOIN bookish.books ON books.bookId = copies.bookId " +
                        "JOIN bookish.users ON users.userId = bookings.userId")
                        .mapToBean(BookingQuery.class)
                        .list()
        );

        return bookings;
    }

    public void addBooking(Booking booking) {
        jdbi.withHandle(handle ->
                handle.createUpdate("INSERT INTO bookings (copyId, userId, dateTaken, dateDue) VALUES (:copyId, :userId, :dateTaken, :dateDue)")
                        .bindBean(booking)
                        .execute()
        );
    }

    public void deleteBooking(int bookingId) {
        jdbi.withHandle(handle ->
                handle.createUpdate("DELETE FROM bookings WHERE bookingId = :id")
                        .bind("id", bookingId)
                        .execute()
        );
    }
}
