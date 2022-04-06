package com.nerdyprogrammer.paymentservice.api.service;

import com.nerdyprogrammer.paymentservice.api.entity.Payment;
import com.nerdyprogrammer.paymentservice.api.repo.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepo paymentRepo;


    public Payment doPayment(Payment payment) {
        payment.setPaymentStatus((paymentProcessing()));
        payment.setTransactionId((UUID.randomUUID().toString()));
        return paymentRepo.save(payment);
    }
    public String paymentProcessing() {
        // api should be 3rd party payment gateway (paypal, paytm)
        Boolean tempRandVal = new Random().nextBoolean();
        return tempRandVal ? "success": "failure";
    }

    public  Payment findPaymentHistoryByOrderId(int orderId) {
        return paymentRepo.findByOrderId(orderId);
    }
}
