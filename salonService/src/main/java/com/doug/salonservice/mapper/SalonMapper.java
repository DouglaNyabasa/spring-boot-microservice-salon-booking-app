package com.doug.salonservice.mapper;

import com.doug.salonservice.models.Salon;
import com.doug.salonservice.payload.dto.SalonDT0;

public class SalonMapper {

    public static SalonDT0 mapToDTO(Salon salon){
        SalonDT0 salonDT0 = new SalonDT0();
        salonDT0.setId(salonDT0.getId());
        salonDT0.setName(salon.getName());
        salonDT0.setAddress(salon.getAddress());
        salonDT0.setCity(salon.getCity());
        salonDT0.setImages(salon.getImages());
        salonDT0.setEmail(salon.getEmail());
        salonDT0.setOpenTime(salon.getOpenTime());
        salonDT0.setCloseTime(salon.getCloseTime());
        salonDT0.setPhoneNumber(salon.getPhoneNumber());
        salonDT0.setOwnerId(salon.getOwnerId());
        return salonDT0;
    }
}
