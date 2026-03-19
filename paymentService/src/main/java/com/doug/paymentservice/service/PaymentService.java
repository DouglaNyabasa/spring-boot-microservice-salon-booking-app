package com.doug.paymentservice.service;

import com.doug.paymentservice.domain.PaymentMethod;
import com.doug.paymentservice.model.PaymentOrder;
import com.doug.paymentservice.payload.BookingDTO;
import com.doug.paymentservice.payload.Response.PaymentLinkResponse;
import com.doug.paymentservice.payload.UserDTO;
import com.stripe.model.PaymentLink;

public interface PaymentService {

 PaymentLinkResponse createOrder(UserDTO userDT0, BookingDTO bookingDTO, PaymentMethod paymentMethod);
 PaymentOrder getPaymentOrderById(Long id);
 PaymentOrder getPaymentOrderByPaymentId(String paymentId);
 String  createStripePaymentLink(UserDTO userDTO,Long amount, Long orderId );

}
