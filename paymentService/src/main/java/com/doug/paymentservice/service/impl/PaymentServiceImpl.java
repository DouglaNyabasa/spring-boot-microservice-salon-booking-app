package com.doug.paymentservice.service.impl;

import com.doug.paymentservice.domain.PaymentMethod;
import com.doug.paymentservice.model.PaymentOrder;
import com.doug.paymentservice.payload.BookingDTO;
import com.doug.paymentservice.payload.Response.PaymentLinkResponse;
import com.doug.paymentservice.payload.UserDTO;
import com.doug.paymentservice.service.PaymentService;

public class PaymentServiceImpl implements PaymentService {
    @Override
    public PaymentLinkResponse createOrder(UserDTO userDT0, BookingDTO bookingDTO, PaymentMethod paymentMethod) {
        return null;
    }

    @Override
    public PaymentOrder getPaymentOrderById(Long id) {
        return null;
    }

    @Override
    public PaymentOrder getPaymentOrderByPaymentId(String paymentId) {
        return null;
    }

    @Override
    public String createStripePaymentLink(UserDTO userDTO, Long amount, Long orderId) {
        return "";
    }
}
