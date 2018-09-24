package org.softwire.training.bookish.controllers;

import org.softwire.training.bookish.databaseModels.Booking;
import org.softwire.training.bookish.services.BookingService;
import org.softwire.training.bookish.viewModels.BookingsPageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class BookingController
{
    @Autowired
    private BookingService bookingService;

    @RequestMapping("/bookings")
    ModelAndView bookings() {

        List<Booking> allBookings = bookingService.getAllBookings();

        BookingsPageModel bookingsPageModel = new BookingsPageModel();
        bookingsPageModel.bookings = allBookings;

        return new ModelAndView("bookings", "model", bookingsPageModel);
    }

    @RequestMapping("/bookings/add")
    RedirectView addBooking(@ModelAttribute Booking booking) {

        bookingService.addBooking(booking);

        return new RedirectView("/bookings");
    }

    @RequestMapping("/bookings/delete")
    RedirectView deleteBooking(@RequestParam int bookingId) {

        bookingService.deleteBooking(bookingId);

        return new RedirectView("/bookings");
    }
}
