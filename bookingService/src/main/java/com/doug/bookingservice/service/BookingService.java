package com.doug.bookingservice.service;

import com.doug.bookingservice.domain.BookingStatus;
import com.doug.bookingservice.model.Booking;
import com.doug.bookingservice.payload.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface BookingService {
    Booking createBooking(BookingRequest booking, UserDTO userDTO, SalonDT0 salonDT0, Set<ServiceDTO> serviceDTOSet);
    List<Booking> getBookingsByCustomer(Long customerId);
    List<Booking> getBookingsBySalon(Long salonId);
    Booking getBookingById(Long id);
    Booking updateBookingStatus(Long bookingId, BookingStatus status);
    List<Booking> getBookingsByDate(LocalDate date, Long salonId);

    SalonReport getSalonReport(Long salonId);
}
