package com.group08.onlineShop.repository;

import com.group08.onlineShop.model.OrderItemDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderItemDetailRepo
        extends JpaRepository<OrderItemDetail, Long> {
}
