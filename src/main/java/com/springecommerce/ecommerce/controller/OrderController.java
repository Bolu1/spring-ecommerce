package com.springecommerce.ecommerce.controller;

import com.springecommerce.ecommerce.interfaces.order.AddOrderRequest;
import com.springecommerce.ecommerce.interfaces.product.CreateProductRequest;
import com.springecommerce.ecommerce.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping("/add")
    public ResponseEntity addOrder(
            @RequestBody AddOrderRequest request
    ){
        return ResponseEntity.ok(service.addOrder(request));
    }

    @GetMapping("/getUserOrder")
    public ResponseEntity getUserOrder(){
        return ResponseEntity.ok(service.getUserOrder());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.deleteOrder(id));
    }
}
