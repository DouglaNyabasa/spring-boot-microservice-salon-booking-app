package com.doug.salonservice.service;

import com.doug.salonservice.models.Salon;
import com.doug.salonservice.payload.dto.SalonDT0;

public interface SalonService {

    Salon createSalon(SalonDT0 salon, UserDTO user);
}
