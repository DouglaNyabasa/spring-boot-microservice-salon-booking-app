package com.doug.serviceoffering.controller;

import com.doug.serviceoffering.models.ServiceOffering;
import com.doug.serviceoffering.service.ServiceOfferingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/serviceOffering")
public class ServiceOfferingController {


    private final ServiceOfferingService serviceOfferingService;

    public ServiceOfferingController(ServiceOfferingService serviceOfferingService) {
        this.serviceOfferingService = serviceOfferingService;
    }

    @GetMapping("/salon/{salonId}")
    public ResponseEntity<Set<ServiceOffering>> getServiceOfferingBySalonId(@PathVariable Long salonId, @RequestParam(required = false) Long categoryId){
      Set<ServiceOffering> serviceOfferings =  serviceOfferingService.getAllServiceBySalon(salonId,categoryId);
      return ResponseEntity.ok(serviceOfferings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceOffering> getServiceOfferingById(@PathVariable Long id) throws Exception {
        ServiceOffering serviceOffering =  serviceOfferingService.getServiceById(id);
        return ResponseEntity.ok(serviceOffering);
    }

    @GetMapping("/list/{ids}")
    public ResponseEntity<Set<ServiceOffering>> getServiceOfferingByIds(@PathVariable Set<Long> ids){
        Set<ServiceOffering> serviceOfferings =  serviceOfferingService.getServiceByIds(ids);
        return ResponseEntity.ok(serviceOfferings);
    }



}
