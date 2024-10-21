package com.hexaware.ecom.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.assertFalse;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.hexaware.ecom.entity.Product;

import com.hexaware.ecom.service.IProductService;
import com.hexaware.ecom.service.ProductServiceImp;

class ProductServiceImpTest {

    static IProductService productService;

    @BeforeAll
    public static void beforeAll() {
        productService = new ProductServiceImp(); 
    }

    @Test
    void testCreatePrdSuccess() {
       
        Product product = new Product(201, "Product1", 150, "Description", 10);

       
        boolean result = productService.createPrd(product);

        assertTrue(result, "Product creation should be successful.");
    }

    @Test
    void testRemovePrdSuccess() {
       
        Product product = new Product(201, "Product2", 100, "Description", 5);

      
        boolean result = productService.removePrd(product);

        assertTrue(result, "Product removal should be successful.");
    }

    @Test
    void testRemovePrdFailure() {
      
        Product product = new Product(999, "InvalidProduct", 100, "Description", 5);

        
        boolean result = productService.removePrd(product);

       
        assertFalse(result, "Product removal should fail for a non-existent product.");

        System.out.println("Expected error: Product not found ID=" + product.getProductId());
    }



}
