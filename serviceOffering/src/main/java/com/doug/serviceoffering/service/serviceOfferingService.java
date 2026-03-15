package com.doug.serviceoffering.service;

import com.doug.serviceoffering.models.ServiceOffering;
import com.doug.serviceoffering.payload.SalonDT0;
import com.doug.serviceoffering.payload.ServiceDTO;

public interface serviceOfferingService {

    ServiceOffering createService(SalonDT0 salonDT0, ServiceDTO serviceDTO, CategoryDTO categoryDTO);
}
