package com.doug.serviceoffering.service.impl;

import com.doug.serviceoffering.models.ServiceOffering;
import com.doug.serviceoffering.payload.CategoryDTO;
import com.doug.serviceoffering.payload.SalonDT0;
import com.doug.serviceoffering.payload.ServiceDTO;
import com.doug.serviceoffering.repository.ServiceOfferingRepository;
import com.doug.serviceoffering.service.ServiceOfferingService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ServiceOfferingServiceImpl implements ServiceOfferingService {

    private final ServiceOfferingRepository serviceOfferingRepository;

    public ServiceOfferingServiceImpl(ServiceOfferingRepository serviceOfferingRepository) {
        this.serviceOfferingRepository = serviceOfferingRepository;
    }

    @Override
    public ServiceOffering createService(SalonDT0 salonDT0, ServiceDTO serviceDTO, CategoryDTO categoryDTO) {
        ServiceOffering serviceOffering = new ServiceOffering();
        serviceOffering.setImage(serviceDTO.getImage());
        serviceOffering.setSalonId(salonDT0.getId());
        serviceOffering.setName(serviceDTO.getName());
        serviceOffering.setDescription(serviceDTO.getDescription());
        serviceOffering.setCategoryId(categoryDTO.getId());
        serviceOffering.setPrice(serviceDTO.getPrice());
        serviceOffering.setDuration(serviceDTO.getDuration());
        return serviceOfferingRepository.save(serviceOffering);
    }

    @Override
    public ServiceOffering updateService(Long serviceId, ServiceOffering serviceOffering) {

        return null;
    }

    @Override
    public Set<ServiceOffering> getAllServiceBySalon(Long salonId) {
        return Set.of();
    }

    @Override
    public Set<ServiceOffering> getServiceByIds(Set<Long> ids) {
        return Set.of();
    }
}
