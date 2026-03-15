package com.doug.salonservice.payload.dto;

import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
public class SalonDT0 {

    private Long id;

    private String name;

    private List<String> images;

    private String address;

    private String phoneNumber;


    private String email;

    private String city;

    private Long ownerId;

    private LocalTime openTime;

    private LocalTime closeTime;
}
