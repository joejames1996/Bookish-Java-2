package org.softwire.training.bookish.databaseModels;

import java.util.Date;

public class Booking
{
    private int bookingId;
    private int copyId;
    private int userId;
    private Date dateTaken;
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
