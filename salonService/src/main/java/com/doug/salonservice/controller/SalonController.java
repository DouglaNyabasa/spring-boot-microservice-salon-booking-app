package com.doug.salonservice.controller;

import com.doug.salonservice.mapper.SalonMapper;
import com.doug.salonservice.models.Salon;
import com.doug.salonservice.payload.dto.SalonDT0;
import com.doug.salonservice.payload.dto.UserDTO;
import com.doug.salonservice.service.SalonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PatchMapping("/{id}")
    public ResponseEntity<SalonDT0> updateSalon(@PathVariable("id") Long salonId,  @RequestBody SalonDT0 salonDT0) throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Salon salon = salonService.updateSalon(salonDT0, userDTO,salonId);
        SalonDT0 salonDT1 = SalonMapper.mapToDTO(salon);

        return ResponseEntity.ok(salonDT1);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<SalonDT0>> getAllSalons() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        List<Salon> salons = salonService.getAllSalons();
        List<SalonDT0> salonDT0s = salons.stream().map((salon)->{
            SalonDT0 salonDT0 = SalonMapper.mapToDTO(salon);
            return salonDT0;
        }).toList();
        return ResponseEntity.ok(salonDT0s);
    }

    @GetMapping("/{salonId}")
    public ResponseEntity<SalonDT0> getSalonsById(@PathVariable Long salonId) throws Exception {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        Salon salon = salonService.getSalonById(salonId);
        SalonDT0 salonDT0 = SalonMapper.mapToDTO(salon);

        return ResponseEntity.ok(salonDT0);
    }


}
