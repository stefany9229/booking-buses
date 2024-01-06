package com.example.bookingbuses.application.service;

import com.example.bookingbuses.model.Booking;
import com.example.bookingbuses.model.IBookingRepository;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    private IBookingRepository bookingRepository;
    private Booking book;
}
