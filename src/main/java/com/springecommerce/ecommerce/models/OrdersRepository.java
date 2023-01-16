package com.springecommerce.ecommerce.models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

    Optional<Orders> findByUsername(String username);

}
