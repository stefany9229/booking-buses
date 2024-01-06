package com.example.bookingbuses.model;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;


@Profile("mysql")
public interface IBookingRepository extends JpaRepository<Booking, String> {
}
