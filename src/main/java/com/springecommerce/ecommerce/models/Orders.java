package com.springecommerce.ecommerce.models;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Data
@Builder
@Entity
@Table(name = "orders")
public class Orders {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    private Integer productId;
    private Integer quantity;

    public Orders(Integer id, String username, Integer productId, Integer quantity) {
        this.id = id;
        this.username = username;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Orders() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return username;
    }

    public void setUser(String username) {
        this.username = username;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return Objects.equals(id, orders.id) && Objects.equals(username, orders.username) && Objects.equals(productId, orders.productId) && Objects.equals(quantity, orders.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, productId, quantity);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
