package com.doug.serviceoffering.repository;

import com.doug.serviceoffering.models.ServiceOffering;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceOfferingRepository extends JpaRepository<ServiceOffering,Long> {

    List<ServiceOffering> findBySalonId(Long salonId);
}
