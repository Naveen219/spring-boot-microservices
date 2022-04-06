package com.nerdyprogrammer.orderservice.api.controller;

import com.nerdyprogrammer.orderservice.api.common.Payment;
import com.nerdyprogrammer.orderservice.api.common.TransactionRequest;
import com.nerdyprogrammer.orderservice.api.common.TransactionResponse;
import com.nerdyprogrammer.orderservice.api.entity.Order;
import com.nerdyprogrammer.orderservice.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/book-order")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request) {
        return orderService.saveOrder(request);

    }

}
