package com.hexaware.ecom.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.hexaware.ecom.entity.Cart;
import com.hexaware.ecom.exceptions.CustomerNotFoundException;
import com.hexaware.ecom.service.CartServiceImp;
import com.hexaware.ecom.service.ICartService;

class CartServiceImpTest {

    static ICartService cartService;

    @BeforeAll
    public static void beforeAll() {
        cartService = new CartServiceImp(); 
    }

    @Test
    void testAddCartSuccess() {
        
        Cart cart = new Cart(301,101, 201, 3); 

        
        boolean result = cartService.addCart(cart);

        
        assertTrue(result, "Cart should be added successfully");
    }

    @Test
    void testAddCartFailure() {
       
        Cart cart = new Cart(301,999, 201, 3); 

        // Check if adding an invalid cart throws CustomerNotFoundException
        assertThrows(CustomerNotFoundException.class, () -> {
            cartService.addCart(cart);
        }, "Should throw CustomerNotFoundException when customer is not found");
    }

    @Test 
    void testValidateCart() {
      
        Cart validCart = new Cart(301,201,301,2);

      
        boolean isValid = CartServiceImp.validateCart(validCart);

        
        assertTrue(isValid, "Cart validation should pass for valid quantity");
    }
}
