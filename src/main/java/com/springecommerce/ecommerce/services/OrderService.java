package com.springecommerce.ecommerce.services;


import com.springecommerce.ecommerce.interfaces.order.AddOrderRequest;
import com.springecommerce.ecommerce.models.Orders;
import com.springecommerce.ecommerce.models.OrdersRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrdersRepository repository;


    public OrderService(OrdersRepository repository) {
        this.repository = repository;
    }

    public String addOrder(AddOrderRequest request){

        System.out.println("sd");
        String username;
        var principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
            System.out.println(((UserDetails)principal).getUsername());
        } else {
            username = principal.toString();
        }

        System.out.println(principal);
        var order = Orders.builder()
                .productId(request.getProductId())
                .quantity(request.getQuantity())
                .username(username)

                .build();
        repository.save(order);
        return "Success";
    }

    public String deleteOrder(Integer id){
        repository.deleteById(id);
        return "Success";
    }

    public Optional<Orders> getUserOrder(){

        String username;
        var principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
            System.out.println(((UserDetails)principal).getUsername());
        } else {
            username = principal.toString();
        }
        return repository.findByUsername(username);
    }
}
