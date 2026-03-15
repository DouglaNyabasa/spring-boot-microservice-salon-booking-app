package com.doug.salonservice.service;

import com.doug.salonservice.models.Salon;
import com.doug.salonservice.payload.dto.SalonDT0;
import com.doug.salonservice.payload.dto.UserDTO;

import java.util.List;

public interface SalonService {

    Salon createSalon(SalonDT0 salonDT0, UserDTO userDTO);

    Salon updateSalon(SalonDT0 salon, UserDTO user,Long salonId);

    List<Salon> getAllSalons();
    Salon getSalonById(Long salonId);
    Salon getSalonByOwnerId(Long ownerId);
    List<Salon> searchSalonByCityName(String city);

}
