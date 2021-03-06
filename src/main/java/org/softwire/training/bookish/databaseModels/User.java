package org.softwire.training.bookish.databaseModels;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User
{
    private int userId;
    private String firstName;
    private String surname;
    private String userName;
    private String password;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dateOfBirth;

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }

    public void setDateOfBirth(Date dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }
}
