package org.softwire.training.bookish.databaseModels;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class BookingQuery
{
    private int bookingId;
    private int copyId;
    private int userId;
    private String title;
    private String author;
    private String isbn;
    private int barcode;
    private String firstName;
    private String surname;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dateTaken;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dateDue;


    public void setBookingId(int bookingId)
    {
        this.bookingId = bookingId;
    }

    public int getBookingId()
    {
        return bookingId;
    }

    public void setCopyId(int copyId)
    {
        this.copyId = copyId;
    }

    public int getCopyId()
    {
        return copyId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }

    public String getIsbn()
    {
        return isbn;
    }

    public void setBarcode(int barcode)
    {
        this.barcode = barcode;
    }

    public int getBarcode()
    {
        return barcode;
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

    public void setDateTaken(Date dateTaken)
    {
        this.dateTaken = dateTaken;
    }

    public Date getDateTaken()
    {
        return dateTaken;
    }

    public void setDateDue(Date dateDue)
    {
        this.dateDue = dateDue;
    }

    public Date getDateDue()
    {
        return dateDue;
    }
}
