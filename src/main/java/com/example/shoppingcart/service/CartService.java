package com.example.shoppingcart.service;

import com.example.shoppingcart.exception.ResourceNotFoundException;
import com.example.shoppingcart.model.Cart;
import com.example.shoppingcart.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Cart getCartById(Long id) {
        return cartRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cart", "id", id));
    }

    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Cart updateCart(Long id, Cart cartDetails) {
        Cart cart = getCartById(id);
        cart.setCartName(cartDetails.getCartName());
        cart.setUser(cartDetails.getUser());
        return cartRepository.save(cart);
    }

    public void deleteCart(Long id) {
        Cart cart = getCartById(id);
        cartRepository.delete(cart);
    }
}