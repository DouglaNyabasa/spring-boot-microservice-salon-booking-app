package com.doug.paymentservice.service.impl;

import com.doug.paymentservice.domain.PaymentMethod;
import com.doug.paymentservice.model.PaymentOrder;
import com.doug.paymentservice.payload.BookingDTO;
import com.doug.paymentservice.payload.Response.PaymentLinkResponse;
import com.doug.paymentservice.payload.UserDTO;
import com.doug.paymentservice.repository.PaymentOrderRepository;
import com.doug.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class PaymentServiceImpl implements PaymentService {


    private final PaymentOrderRepository paymentOrderRepository;
    @Value("${stripe.api.key}")
    private String stripeSecretKey;

    public PaymentServiceImpl(PaymentOrderRepository paymentOrderRepository) {
        this.paymentOrderRepository = paymentOrderRepository;
    }

    @Override
    public PaymentLinkResponse createOrder(UserDTO userDT0, BookingDTO bookingDTO, PaymentMethod paymentMethod) {
        Long amount = (long)bookingDTO.getTotalPrice();


        PaymentLinkResponse paymentLinkResponse = new PaymentLinkResponse();
        PaymentOrder order = new PaymentOrder();
        order.setAmount(amount);
        order.setPaymentMethod(paymentMethod);
        order.setBookingId(bookingDTO.getId());
        order.setSalonId(bookingDTO.getSalonId());
        PaymentOrder savedOrder = paymentOrderRepository.save(order);
        String paymentUrl = createStripePaymentLink(userDT0,savedOrder.getAmount(),savedOrder.getId());
        paymentLinkResponse.setPayment_link_url(paymentUrl);
        return paymentLinkResponse;
    }

    @Override
    public PaymentOrder getPaymentOrderById(Long id) throws Exception {
        PaymentOrder paymentOrder = paymentOrderRepository.findById(id).orElse(null);
        if(paymentOrder == null){
            throw new Exception("payment order not found");
        }
        return paymentOrder;
    }

    @Override
    public PaymentOrder getPaymentOrderByPaymentId(String paymentId) {
        return paymentOrderRepository.findByPaymentLinkId(paymentId);
    }

    @Override
    public String createStripePaymentLink(UserDTO userDTO, Long amount, Long orderId) {
        return "";
    }
}
