package com.nerdyprogrammer.orderservice.api.repo;

import com.nerdyprogrammer.orderservice.api.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface OrderRepo extends JpaRepository<Order, Integer> {

}
