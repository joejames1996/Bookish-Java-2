package org.softwire.training.bookish.databaseModels;

public class BookCopy
{
    private int copyId;
    private int bookId;
    private int barcode;
    private int userId;

    public void setCopyId(int copyId)
    {
        this.copyId = copyId;
    }

    public int getCopyId()
    {
        return copyId;
    }

    public void setBookId(int bookId)
    {
        this.bookId = bookId;
    }

    public int getBookId()
    {
        return bookId;
    }

    public void setBarcode(int barcode)
    {
        this.barcode = barcode;
    }

    public int getBarcode()
    {
        return barcode;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public int getUserId()
    {
        return userId;
    }
}
