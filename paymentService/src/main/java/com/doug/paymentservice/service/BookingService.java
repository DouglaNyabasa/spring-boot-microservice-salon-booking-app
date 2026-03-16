package com.doug.paymentservice.service;

import com.doug.paymentservice.domain.BookingStatus;
import com.doug.paymentservice.model.Booking;
import com.doug.paymentservice.payload.BookingRequest;
import com.doug.paymentservice.payload.SalonDT0;
import com.doug.paymentservice.payload.ServiceDTO;
import com.doug.paymentservice.payload.UserDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface BookingService {

    Booking createBooking(BookingRequest booking, UserDTO userDTO, SalonDT0 salonDT0, Set<ServiceDTO> serviceDTOSet);
    List<Booking> getBookingsByCustomer(Long customerId);
    List<Booking> getBookingsBySalon(Long salonId);
    Booking getBookingById(Long id);
    Booking updateBookingStatus(Long bookingId, BookingStatus status);
    List<Booking> getBookingsByDate(LocalDate date,Long salonId);

}
