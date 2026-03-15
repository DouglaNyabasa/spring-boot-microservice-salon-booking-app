package com.doug.serviceoffering.controller;

import com.doug.serviceoffering.models.ServiceOffering;
import com.doug.serviceoffering.payload.CategoryDTO;
import com.doug.serviceoffering.payload.SalonDT0;
import com.doug.serviceoffering.payload.ServiceDTO;
import com.doug.serviceoffering.service.ServiceOfferingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/service-offering/salon-owner")
public class SalonServiceOfferingController {

    private final ServiceOfferingService serviceOfferingService;

    public SalonServiceOfferingController(ServiceOfferingService serviceOfferingService) {
        this.serviceOfferingService = serviceOfferingService;
    }



    @PostMapping("/create")
    public ResponseEntity<ServiceOffering> createService(@RequestBody ServiceDTO serviceDTO){
        SalonDT0 salonDT0 = new SalonDT0();
        salonDT0.setId(1L);

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(serviceDTO.getCategoryId());

        ServiceOffering serviceOffering = serviceOfferingService.createService(salonDT0,serviceDTO,categoryDTO);
        return ResponseEntity.ok(serviceOffering);


    }
}
