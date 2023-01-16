package com.springecommerce.ecommerce.interfaces.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddOrderRequest {

    private Integer productId;
    private Integer quantity;
}
