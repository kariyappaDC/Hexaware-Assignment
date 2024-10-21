package com.hexaware.ecom.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.hexaware.ecom.entity.OrderItems;
import com.hexaware.ecom.entity.Orders;
import com.hexaware.ecom.service.OrderServiceImp;
import com.hexaware.ecom.service.IOrderService;

class OrderServiceImpTest {

    static IOrderService orderService;

    @BeforeAll
    public static void beforeAll() {
        orderService = new OrderServiceImp(); 
    }

    @Test
    void testAddOrder() {
        
        Orders order = new Orders(420, 101, LocalDate.now(),0.0, "vrp");
        OrderItems orderItem = new OrderItems(5, 401, 201, 3); 

      
        double totalPrice = orderService.calculateTotalPrice(order, orderItem);


        assertEquals(90000.00 , totalPrice, "Total price should be calculated correctly."); 
        
        // Add order and order items
        boolean isOrderAdded = orderService.addOrder(order);
        boolean isOrderItemAdded = orderService.addOrderItems(orderItem);

        
        assertTrue(isOrderAdded, "Order should be added successfully.");
        assertTrue(isOrderItemAdded, "Order item should be added successfully.");
    }



    @Test
    void testValidateOrder() {
        
        OrderItems validOrderItem = new OrderItems(201, 401, 301, 2);

       
        boolean isValid = OrderServiceImp.validateOrder(validOrderItem);

       
        assertTrue(isValid, "Order validation should pass for a valid order item.");
    }
}
