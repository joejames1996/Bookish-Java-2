package org.softwire.training.bookish.services;

import org.jdbi.v3.core.Jdbi;
import org.softwire.training.bookish.databaseModels.Copy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CopyService
{
    private String hostname = "10.210.11.106:3306";
    private String database = "bookish";
    private String user = "bookish";
    private String password = "4q1WIfvybxBN";
    private String connectionString = "jdbc:mysql://" + hostname + "/" + database + "?user=" + user + "&password=" + password + "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT&useSSL=false&allowPublicKeyRetrieval=true";

    private Jdbi jdbi = Jdbi.create(connectionString);

    public List<Copy> getAllCopies() {
        List<Copy> copies = jdbi.withHandle(handle ->
                handle.createQuery("SELECT * FROM copies")
                        .mapToBean(Copy.class)
                        .list()
        );

        return copies;
    }

    public void addCopy(Copy copy) {
        jdbi.withHandle(handle ->
                handle.createUpdate("INSERT INTO copies (bookId) VALUES (:bookId)")
                        .bindBean(copy)
                        .execute()
        );
    }

    public void deleteCopy(int copyId) {
        jdbi.withHandle(handle ->
                handle.createUpdate("DELETE FROM copies WHERE copyId = :id")
                        .bind("id", copyId)
                        .execute()
        );
    }
}
