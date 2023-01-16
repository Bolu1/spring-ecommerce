package com.springecommerce.ecommerce.controller;



import com.springecommerce.ecommerce.config.JwtService;
import com.springecommerce.ecommerce.interfaces.AuthenticationRequest;
import com.springecommerce.ecommerce.interfaces.AuthenticationResponse;
import com.springecommerce.ecommerce.interfaces.RegisterRequest;
import com.springecommerce.ecommerce.interfaces.product.CreateProductRequest;
import com.springecommerce.ecommerce.models.User;
import com.springecommerce.ecommerce.services.AuthenticationService;
import com.springecommerce.ecommerce.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductService service;
    
    @PostMapping("/add")
    public ResponseEntity addProducts(
        @RequestBody CreateProductRequest request
    ){
        return ResponseEntity.ok(service.addProduct(request));
    }

    @GetMapping("/getAll")
    public ResponseEntity getProducts(){
        return ResponseEntity.ok(service.getProducts());

    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity getOne(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.getProduct(id));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.deleteProduct(id));
    }

    @PutMapping("update/{id}")
    public ResponseEntity updateProduct(@PathVariable("id") Integer id,
                                        @RequestBody CreateProductRequest request){

        return ResponseEntity.ok(service.updateProduct(id, request));
    }
}
