package com.doug.serviceoffering.service;

import com.doug.serviceoffering.models.ServiceOffering;
import com.doug.serviceoffering.payload.CategoryDTO;
import com.doug.serviceoffering.payload.SalonDT0;
import com.doug.serviceoffering.payload.ServiceDTO;

import java.util.Set;

public interface ServiceOfferingService {

    ServiceOffering createService(SalonDT0 salonDT0, ServiceDTO serviceDTO, CategoryDTO categoryDTO);

    ServiceOffering updateService(Long serviceId,ServiceOffering service) throws Exception;

    Set<ServiceOffering> getAllServiceBySalon(Long salonId);

    Set<ServiceOffering> getServiceByIds(Set<Long> ids);
}
