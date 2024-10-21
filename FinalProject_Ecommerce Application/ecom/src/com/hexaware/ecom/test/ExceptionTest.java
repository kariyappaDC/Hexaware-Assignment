package com.hexaware.ecom.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.hexaware.ecom.exceptions.CustomerNotFoundException;
import com.hexaware.ecom.exceptions.OrderNotFoundException;
import com.hexaware.ecom.exceptions.ProductNotFoundException;

class ExceptionTest {

	@Test
    public void testCustomerNotFoundExceptionMessage() {
        Exception exception = assertThrows(CustomerNotFoundException.class, () -> {
            throw new CustomerNotFoundException("Customer not found");
        });

        assertTrue(exception.getMessage().contains("Customer not found"));
    }

    @Test
    public void testOrderNotFoundExceptionMessage() {
        Exception exception = assertThrows(OrderNotFoundException.class, () -> {
            throw new OrderNotFoundException("Order not found");
        });

        assertTrue(exception.getMessage().contains("Order not found"));
    }

    @Test
    public void testProductNotFoundExceptionMessage() {
        Exception exception = assertThrows(ProductNotFoundException.class, () -> {
            throw new ProductNotFoundException("Product not found");
        });

        assertTrue(exception.getMessage().contains("Product not found"));
    }
}
