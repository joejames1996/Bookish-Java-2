package org.softwire.training.bookish.viewModels;

import org.softwire.training.bookish.databaseModels.BookingQuery;
import org.softwire.training.bookish.databaseModels.User;

import java.util.List;

public class UserBookPageModel
{
    public List<BookingQuery> bookings;
    public User user;
}
