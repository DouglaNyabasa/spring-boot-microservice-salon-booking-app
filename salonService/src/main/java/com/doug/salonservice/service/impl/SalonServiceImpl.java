package com.doug.salonservice.service.impl;

import com.doug.salonservice.models.Salon;
import com.doug.salonservice.payload.dto.SalonDT0;
import com.doug.salonservice.payload.dto.UserDTO;
import com.doug.salonservice.repository.SalonRepository;
import com.doug.salonservice.service.SalonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalonServiceImpl implements SalonService {


    private final SalonRepository salonRepository;

    public SalonServiceImpl(SalonRepository salonRepository) {
        this.salonRepository = salonRepository;
    }

    @Override
    public Salon createSalon(SalonDT0 salon, UserDTO user) {
        return null;
    }

    @Override
    public Salon updateSalon(SalonDT0 salon, UserDTO user, Long salonId) {
        return null;
    }

    @Override
    public List<Salon> getAllSalons() {
        return List.of();
    }

    @Override
    public Salon getSalonById(Long salonId) {
        return null;
    }

    @Override
    public Salon getSalonByOwnerId(Long ownerId) {
        return null;
    }

    @Override
    public List<Salon> searchSalonByCityName(String city) {
        return List.of();
    }
}
