package com.example.shoppingcart.service;

import com.example.shoppingcart.exception.ResourceNotFoundException;
import com.example.shoppingcart.model.CartItem;
import com.example.shoppingcart.repository.CartItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {
    private final CartItemRepository cartItemRepository;

    public CartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    public CartItem getCartItemById(Long id) {
        return cartItemRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("CartItem", "id", id));
    }

    public CartItem createCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    public CartItem updateCartItem(Long id, CartItem cartItemDetails) {
        CartItem cartItem = getCartItemById(id);
        cartItem.setCart(cartItemDetails.getCart());
        cartItem.setProduct(cartItemDetails.getProduct());
        cartItem.setQuantity(cartItemDetails.getQuantity());
        cartItem.setTotalPrice(cartItemDetails.getTotalPrice());
        return cartItemRepository.save(cartItem);
    }

    public void deleteCartItem(Long id) {
        CartItem cartItem = getCartItemById(id);
        cartItemRepository.delete(cartItem);
    }
}