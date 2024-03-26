package com.example.shoppingcart.model;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    private String cartName;
    @ManyToOne
    private User user;
}