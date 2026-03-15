package com.doug.salonservice.controller;

import com.doug.salonservice.mapper.SalonMapper;
import com.doug.salonservice.models.Salon;
import com.doug.salonservice.payload.dto.SalonDT0;
import com.doug.salonservice.payload.dto.UserDTO;
import com.doug.salonservice.service.SalonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/salons")
public class SalonController {

    private final SalonService salonService;

    public SalonController( SalonService salonService) {
        this.salonService = salonService;
    }

    @PostMapping("/create")
    public ResponseEntity<SalonDT0> createSalon(@RequestBody SalonDT0 salonDT0){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Salon salon = salonService.createSalon(salonDT0, userDTO);
        SalonDT0 salonDT1 = SalonMapper.mapToDTO(salon);

       return ResponseEntity.ok(salonDT1);
    }


}
