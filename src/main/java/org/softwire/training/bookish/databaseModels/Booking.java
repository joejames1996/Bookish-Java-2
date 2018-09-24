package org.softwire.training.bookish.databaseModels;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Booking
{
    private int bookingId;
    private int copyId;
    private Copy copy;
    private int userId;
    private User user;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dateTaken;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dateDue;

    public static List<Booking> allBookings;

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

    public void setCopy()
    {
        this.copy = Copy.getCopyFromId(this.copyId);
    }

    public Copy getCopy()
    {
        return copy;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public User getUser()
    {
        return user;
    }
}
