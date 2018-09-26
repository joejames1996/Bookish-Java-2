package org.softwire.training.bookish.viewModels;

import org.softwire.training.bookish.databaseModels.BookingQuery;
import org.softwire.training.bookish.databaseModels.User;

import java.util.List;

public class BookingsPageModel
{
    public List<BookingQuery> bookings;
    public List<BookingQuery> books;
    public List<User> users;
}
