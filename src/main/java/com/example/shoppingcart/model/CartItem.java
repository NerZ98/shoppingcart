package com.example.shoppingcart.model;

import lombok.Data;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;
    @ManyToOne
    private Cart cart;
    @ManyToOne
    private Product product;
    private Integer quantity;
    private BigDecimal totalPrice;
}