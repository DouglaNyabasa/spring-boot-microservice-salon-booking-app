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
    public Salon createSalon(SalonDT0 salonDT0, UserDTO userDTO) {
        Salon salon = new Salon();
        salon.setName(salonDT0.getName());
        salon.setAddress(salonDT0.getAddress());
        salon.setEmail(salonDT0.getEmail());
        salon.setCity(salonDT0.getCity());
        salon.setImages(salonDT0.getImages());
        salon.setOwnerId(userDTO.getId());
        salon.setOpenTime(salonDT0.getOpenTime());
        salon.setCloseTime(salonDT0.getCloseTime());
        salon.setPhoneNumber(salonDT0.getPhoneNumber());
        return salonRepository.save(salon);
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
