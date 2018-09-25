package org.softwire.training.bookish.databaseModels;

import java.util.ArrayList;
import java.util.List;

public class CopyQuery
{
    private int copyId;
    private int bookId;
    private String title;
    private String subtitle;
    private String author;
    private String isbn;
    private int barcode;

    public static List<CopyQuery> allBooks = new ArrayList<>();

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

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }

    public void setSubtitle(String subtitle)
    {
        this.subtitle = subtitle;
    }

    public String getSubtitle()
    {
        return subtitle;
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

    public static CopyQuery getBookFromId(int bookId)
    {
        CopyQuery book = new CopyQuery();
        for(CopyQuery b : allBooks)
        {
            if(b.bookId == bookId)
            {
                book = b;
                break;
            }
        }
        return book;
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
