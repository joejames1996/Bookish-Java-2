package org.softwire.training.bookish.databaseModels;

public class Copy
{
    private int copyId;
    private int bookId;

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
}
