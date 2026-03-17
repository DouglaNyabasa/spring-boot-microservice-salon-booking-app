package com.doug.bookingservice.controller;

import com.doug.bookingservice.model.Booking;
import com.doug.bookingservice.payload.BookingRequest;
import com.doug.bookingservice.payload.SalonDT0;
import com.doug.bookingservice.payload.ServiceDTO;
import com.doug.bookingservice.payload.UserDTO;
import com.doug.bookingservice.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

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

}
