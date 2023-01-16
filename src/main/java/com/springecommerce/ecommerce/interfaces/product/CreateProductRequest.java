package com.springecommerce.ecommerce.interfaces.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {
    

    private String name;
    private String description;
    private Integer price;
}
