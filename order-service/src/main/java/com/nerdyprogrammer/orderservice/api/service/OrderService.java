package com.nerdyprogrammer.orderservice.api.service;

import com.nerdyprogrammer.orderservice.api.common.Payment;
import com.nerdyprogrammer.orderservice.api.common.TransactionRequest;
import com.nerdyprogrammer.orderservice.api.common.TransactionResponse;
import com.nerdyprogrammer.orderservice.api.entity.Order;
import com.nerdyprogrammer.orderservice.api.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;


    @Autowired
    private RestTemplate restTemplate;

    public TransactionResponse saveOrder(TransactionRequest request) {
        String response = "";
        Order order = request.getOrder();
        Payment payment = request.getPayment();
        payment.setOrderId(order.getOrderId());
        payment.setAmount(order.getPrice());
       Payment paymentResponse =  restTemplate.postForObject("http://payment-service/payment/do-payment", payment, Payment.class);
       response =  paymentResponse.getPaymentStatus().equals("success")? "payment processing successful and order placed": "there is a failure in payment, order added to cart";
       orderRepo.save(order);
       return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), response);
    }
}
