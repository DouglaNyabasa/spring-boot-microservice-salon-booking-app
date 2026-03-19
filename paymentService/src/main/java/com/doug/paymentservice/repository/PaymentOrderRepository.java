package com.doug.paymentservice.repository;

import com.doug.paymentservice.model.PaymentOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentOrderRepository extends JpaRepository<PaymentOrder,Long> {


    PaymentOrder findByPaymentLinkId(String paymentLinkId);
}
