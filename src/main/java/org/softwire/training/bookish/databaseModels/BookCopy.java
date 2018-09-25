package org.softwire.training.bookish.databaseModels;

import java.util.ArrayList;
import java.util.List;

public class BookCopy
{
    private int copyId;
    private int bookId;
    private int barcode;

    public static List<BookCopy> allBooks = new ArrayList<>();

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
}
