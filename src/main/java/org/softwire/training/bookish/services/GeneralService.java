package org.softwire.training.bookish.services;

import org.jdbi.v3.core.Jdbi;
import org.springframework.stereotype.Service;

@Service
public class GeneralService
{
    private String hostname = "10.210.11.106:3306";
    private String database = "bookish";
    private String user = "bookish";
    private String password = "4q1WIfvybxBN";
    private String connectionString = "jdbc:mysql://" + hostname + "/" + database + "?user=" + user + "&password=" + password + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT&useSSL=false&allowPublicKeyRetrieval=true";

    private Jdbi jdbi = Jdbi.create(connectionString);

    public void deleteBook(int bookId) {

        jdbi.withHandle(handle ->
                handle.createUpdate("DELETE bookish.bookings " +
                        "FROM bookish.bookings " +
                        "JOIN bookish.copies ON bookings.copyId = copies.copyId " +
                        "WHERE copies.bookId = :id")
                        .bind("id", bookId)
                        .execute()
        );

        jdbi.withHandle(handle ->
                handle.createUpdate("DELETE FROM copies WHERE bookId = :id")
                        .bind("id", bookId)
                        .execute()
        );

        jdbi.withHandle(handle ->
                handle.createUpdate("DELETE FROM books WHERE bookId = :id")
                        .bind("id", bookId)
                        .execute()
        );
    }
}
