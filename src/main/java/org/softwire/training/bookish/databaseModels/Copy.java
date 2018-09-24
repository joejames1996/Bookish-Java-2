package org.softwire.training.bookish.databaseModels;

import java.util.ArrayList;
import java.util.List;

public class Copy
{
    private int copyId;
    private int bookId;
    private Book book;

    public static List<Copy> allCopies = new ArrayList<>();

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

    public static Copy getCopyFromId(int copyId)
    {
        Copy copy = new Copy();
        for(Copy c : allCopies)
        {
            if(c.copyId == copyId)
            {
                copy = c;
                break;
            }
        }
        return copy;
    }

    public void setBook()
    {
        this.book = Book.getBookFromId(this.bookId);
    }

    public Book getBook()
    {
        return book;
    }
}
