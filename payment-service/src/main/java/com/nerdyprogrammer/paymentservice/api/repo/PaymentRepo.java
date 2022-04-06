package com.nerdyprogrammer.paymentservice.api.repo;

import com.nerdyprogrammer.paymentservice.api.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment, Integer> {
    Payment findByOrderId(int orderId);
}
