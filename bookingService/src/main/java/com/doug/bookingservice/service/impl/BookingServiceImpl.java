package com.doug.bookingservice.service.impl;

import com.doug.bookingservice.domain.BookingStatus;
import com.doug.bookingservice.model.Booking;
import com.doug.bookingservice.payload.*;
import com.doug.bookingservice.repository.BookingRepository;
import com.doug.bookingservice.service.BookingService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking createBooking(BookingRequest booking, UserDTO userDTO, SalonDT0 salonDT0, Set<ServiceDTO> serviceDTOSet) throws Exception {

        int totalDuration = serviceDTOSet.stream()
                .mapToInt(ServiceDTO::getDuration)
                .sum();
        LocalDateTime bookingStartTime = booking.getStartTime();
        LocalDateTime bookingEndTime = bookingStartTime.plusMinutes(totalDuration);
        Boolean isSlotAvailable = isTimeSlotAvailable(salonDT0,bookingStartTime,bookingEndTime);

        int totalPrice = serviceDTOSet.stream()
                .mapToInt(ServiceDTO::getPrice)
                .sum();
        Set<Long> idList = serviceDTOSet.stream().map(ServiceDTO::getId).collect(Collectors.toSet());
        Booking newBooking = new Booking();
        newBooking.setCustomerId(userDTO.getId());
        newBooking.setSalonId(salonDT0.getId());
        newBooking.setServiceIds(idList);
        newBooking.setStatus(BookingStatus.PENDING);
        newBooking.setStartTime(bookingStartTime);
        newBooking.setEndTime(bookingEndTime);
        newBooking.setTotalPrice(totalPrice);

        return bookingRepository.save(newBooking);
    }
    public Boolean isTimeSlotAvailable(SalonDT0 salonDT0,LocalDateTime bookingStartTime,LocalDateTime bookingEndTime) throws Exception {

      List<Booking> existingBookings = getBookingsBySalon(salonDT0.getId());
     LocalDateTime salonOpenTime = salonDT0.getOpenTime().atDate(bookingStartTime.toLocalDate());
     LocalDateTime salonCloseTime = salonDT0.getCloseTime().atDate(bookingEndTime.toLocalDate());

     if (bookingStartTime.isBefore(salonOpenTime) || bookingEndTime.isAfter(salonCloseTime)){
         throw new Exception("booking time must be within the salon working hours");
     }
     for (Booking existingBooking : existingBookings){
         LocalDateTime existingBookingStartTime = existingBooking.getStartTime();
         LocalDateTime existingBookingEndTime = existingBooking.getEndTime();

         if (bookingStartTime.isBefore(existingBookingEndTime) && bookingEndTime.isAfter(existingBookingStartTime)){
             throw new Exception("slot not available, choose a different time.");

         }

         if (bookingStartTime.isEqual(existingBookingStartTime) || bookingEndTime.isEqual(existingBookingEndTime)){
             throw new Exception("slot not available, choose a different time.");
         }
     }
        return true;
    }

    @Override
    public List<Booking> getBookingsByCustomer(Long customerId) {
        return bookingRepository.findByCustomerId(customerId);
    }

    @Override
    public List<Booking> getBookingsBySalon(Long id) {

        return null;
    }

    @Override
    public Booking getBookingById(Long id) throws Exception {
        Booking booking = bookingRepository.findById(id).orElse(null);
        if (booking == null){
            throw new Exception("booking not found");
        }
        return null;
    }

    @Override
    public Booking updateBookingStatus(Long bookingId, BookingStatus status) {
        return null;
    }

    @Override
    public List<Booking> getBookingsByDate(LocalDate date, Long salonId) {
        return List.of();
    }

    @Override
    public SalonReport getSalonReport(Long salonId) {
        return null;
    }
}
