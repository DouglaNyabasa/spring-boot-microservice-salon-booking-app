package com.doug.paymentservice.controller;

import com.doug.paymentservice.domain.PaymentMethod;
import com.doug.paymentservice.payload.BookingDTO;
import com.doug.paymentservice.payload.Response.PaymentLinkResponse;
import com.doug.paymentservice.payload.UserDTO;
import com.doug.paymentservice.service.PaymentService;
import com.stripe.exception.StripeException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;


    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }



    @PostMapping("/create")
    public ResponseEntity<PaymentLinkResponse> createPaymentLink(@RequestBody BookingDTO bookingDTO, @RequestParam PaymentMethod paymentMethod) throws StripeException {
        UserDTO userDTO = new UserDTO();
        userDTO.setFullName("dummy test user");
        userDTO.setEmail("dumyuser@gmail.com");
        userDTO.setId(1L);

        PaymentLinkResponse res = paymentService.createOrder(userDTO,bookingDTO,paymentMethod);

        return  ResponseEntity.ok(res);
    }
}
