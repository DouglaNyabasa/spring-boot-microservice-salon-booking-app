package com.doug.bookingservice.controller;

import com.doug.bookingservice.domain.BookingStatus;
import com.doug.bookingservice.mapper.BookingMapper;
import com.doug.bookingservice.model.Booking;
import com.doug.bookingservice.payload.*;
import com.doug.bookingservice.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }


    @PostMapping("/create")
    public ResponseEntity<Booking> createBooking (@RequestParam Long salonId, @RequestBody BookingRequest bookingRequest) throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        SalonDT0 salonDT0 = new SalonDT0();
        salonDT0.setId(salonId );
        Set<ServiceDTO> serviceDTOSet = new HashSet<>();
        ServiceDTO serviceDTO = new ServiceDTO();
        serviceDTO.setId(1L);
        serviceDTO.setPrice(399);
        serviceDTO.setDuration(45);
        serviceDTO.setName("dummy static test data for demo");
        serviceDTOSet.add(serviceDTO);
        Booking  booking = bookingService.createBooking(bookingRequest,userDTO,salonDT0,serviceDTOSet);


        return ResponseEntity.ok(booking);
    }

    @GetMapping("/customer")
    public ResponseEntity<Set<BookingDTO>> getBookingsByCustomer(){

        List<Booking> bookings = bookingService.getBookingsByCustomer(1L);

        return ResponseEntity.ok(getBookingDTOs(bookings));

    }

    @GetMapping("/salon")
    public ResponseEntity<Set<BookingDTO>> getBookingsBySalon(){

        List<Booking> bookings = bookingService.getBookingsBySalon(1L);

        return ResponseEntity.ok(getBookingDTOs(bookings));

    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<BookingDTO> getBookingsById(@PathVariable Long bookingId) throws Exception {

        Booking booking = bookingService.getBookingById(bookingId);

        return ResponseEntity.ok(BookingMapper.toDTO(booking));

    }



    @PutMapping("/status/{bookingId}")
    public ResponseEntity<BookingDTO> updateBookingStatus(@PathVariable Long bookingId, @RequestParam BookingStatus status) throws Exception {

        Booking booking = bookingService.updateBookingStatus(bookingId,status);

        return ResponseEntity.ok(BookingMapper.toDTO(booking));

    }

    private Set<BookingDTO> getBookingDTOs(List<Booking> bookings){
        return bookings.stream().map(booking -> {return BookingMapper.toDTO(booking);
        }).collect(Collectors.toSet());
    }








}
