package org.softwire.training.bookish.services;

import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.databaseModels.Book;
import org.softwire.training.bookish.databaseModels.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService
{
    private String hostname = "10.210.11.106:3306";
    private String database = "bookish";
    private String user = "bookish";
    private String password = "4q1WIfvybxBN";
    private String connectionString = "jdbc:mysql://" + hostname + "/" + database + "?user=" + user + "&password=" + password + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT&useSSL=false&allowPublicKeyRetrieval=true";

    private Jdbi jdbi = Jdbi.create(connectionString);

    public List<User> getAllUsers() {
        List<User> users = jdbi.withHandle(handle ->
            handle.createQuery("SELECT * FROM users " +
                    "ORDER BY surname, firstName, userName")
                .mapToBean(User.class)
                .list()
        );

        return users;
    }

    public void addUser(User user) {
        jdbi.withHandle(handle ->
            handle.createUpdate("INSERT INTO users (firstName, surname, userName, password, dateOfBirth) VALUES (:firstName, :surname, :userName, :password, :dateOfBirth)")
                .bindBean(user)
                .execute()
        );
    }

    public void deleteUser(int userId) {
        jdbi.withHandle(handle ->
                handle.createUpdate("DELETE FROM bookings WHERE userId = :id")
                .bind("id", userId)
                .execute()
        );

        jdbi.withHandle(handle ->
            handle.createUpdate("DELETE FROM users WHERE userId = :id")
                .bind("id", userId)
                .execute()
        );
    }
}
