package com.example.shoppingcart.model;

import lombok.Data;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private BigDecimal price;
    private String description;
}