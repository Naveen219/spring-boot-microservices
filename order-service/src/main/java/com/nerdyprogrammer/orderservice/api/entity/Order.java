package com.nerdyprogrammer.orderservice.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ORDER_TB")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    private int orderId;
    private String orderName;
    private int qty;
    private double price;
}
