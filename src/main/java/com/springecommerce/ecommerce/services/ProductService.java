package com.springecommerce.ecommerce.services;

import com.springecommerce.ecommerce.interfaces.product.CreateProductRequest;
import com.springecommerce.ecommerce.models.Product;
import com.springecommerce.ecommerce.models.ProductRepository;
import com.springecommerce.ecommerce.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }


    public String addProduct(CreateProductRequest request){
        var product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();
        repository.save(product);
        return "Success";
    }

    public List<Product> getProducts(){
        return repository.findAll();
    }

    public Optional<Product> getProduct(Integer id){
        return repository.findById(id);
    }

    public String deleteProduct(Integer id){
        repository.deleteById(id);
        return "Success";
    }

    public String updateProduct(Integer id, CreateProductRequest request){
        repository.findById(id) // returns Optional<User>
                .ifPresent(product1 -> {
                    product1.setName(request.getName() != null? request.getName() : product1.getName());
                    product1.setDescription(request.getDescription() != null? request.getDescription() : product1.getDescription());
                    product1.setPrice(request.getPrice() != null? request.getPrice() : product1.getPrice());

                    repository.save(product1);
                });
        return "Success";
    }

}
