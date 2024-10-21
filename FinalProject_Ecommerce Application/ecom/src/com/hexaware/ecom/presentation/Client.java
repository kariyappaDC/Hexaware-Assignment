package com.hexaware.ecom.presentation;

/**
 * Author: Kariyappa D C , Eshwar Reddy V
 * Date: October 18, 2024
 * Description: This class is the client-facing presentation layer for the  e-commerce system. 
 * It provides a menu-driven interface for customers to 
 * register, create products, add products to the cart, view cart items, place 
 * orders, and view customer orders. It interacts with services for handling 
 * customer, cart, product, and order-related functionalities.
 */

import com.hexaware.ecom.entity.Cart;
import com.hexaware.ecom.entity.Customer;
import com.hexaware.ecom.entity.OrderItems;
import com.hexaware.ecom.entity.Orders;
import com.hexaware.ecom.entity.Product;
import com.hexaware.ecom.exceptions.CustomerNotFoundException;
import com.hexaware.ecom.exceptions.ProductNotFoundException;
import com.hexaware.ecom.service.IOrderService;
import com.hexaware.ecom.service.OrderServiceImp;
import com.hexaware.ecom.service.CartServiceImp;
import com.hexaware.ecom.service.CustomerServiceImp;
import com.hexaware.ecom.service.ICartService;
import com.hexaware.ecom.service.ICustomerService;
import com.hexaware.ecom.service.IProductService;
import com.hexaware.ecom.service.ProductServiceImp;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Client {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] Args) {

        boolean flag;
        ICustomerService servicecus = new CustomerServiceImp();
        ICartService serviceCar = new CartServiceImp();
        IOrderService serviceOrd = new OrderServiceImp();
        IOrderService serviceOrderItem = new OrderServiceImp();
        IProductService servicePro = new ProductServiceImp();

        do {
            System.out.println("\nE-Commerce System Menu:");
            System.out.println("1. Register Customer");
            System.out.println("2. Create Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Add to Cart");
            System.out.println("5. View Cart");
            System.out.println("6. Place Order");
            System.out.println("7. View Customer Order");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Customer cst = readCstData();
                    boolean Valid = CustomerServiceImp.vaildateCst(cst);
                    if (Valid) {
                        boolean count = servicecus.createCst(cst);
                        if (count == true) {
                            System.out.println("Customer Added");
                        } else {
                            System.err.println("Customer Added failed");
                        }
                    } else {
                        System.err.println("Invalid Customer Data");
                    }
                    break;

                case 2:
                    Product prd = readPrdData();
                    boolean isValidPrd = ProductServiceImp.vaildatePrd(prd);
                    if (isValidPrd) {
                        boolean count = servicePro.createPrd(prd);
                        if (count == true) {
                            System.out.println("Product Added");
                        } else {
                            System.err.println("Product Add failed");
                        }
                    } else {
                        System.err.println("Invalid Input");
                    }
                    break;

                case 3:
                	
			        Product prdrm=new Product();
        			
        			System.out.print("Enter ProductId=");
        				prdrm.setProductId(scanner.nextInt());
        				try {
        				Boolean count = servicePro.removePrd(prdrm);
        				
        				if(count ) {
        					System.out.println("Product removed");
        				}
        				}
        				catch(ProductNotFoundException e) {
        					System.err.println(e.getMessage());
        				}
                	
                    break;


                case 4:
                    Cart car = new Cart();
                    System.out.println("enter the cart id.");
                    car.setCartId(scanner.nextInt());
                    System.out.println("enter the customer id.");
                    car.setCustomerId(scanner.nextInt());
                    System.out.println("enter the product id.");
                    car.setProductId(scanner.nextInt());
                    System.out.println("enter the quantity id.");
                    car.setQuantity(scanner.nextInt());

                    boolean isValidCar = CartServiceImp.validateCart(car);
                    if (isValidCar) {
                        boolean countC = serviceCar.addCart(car);
                        if (countC == true) {
                            System.out.println(" item added to cart ");
                        } else {
                            System.err.println(" item not added to cart ");
                        }
                    } else {
                        System.err.println("invalid....");
                    }
                    break;

                case 5:
                    List<Cart> list = serviceCar.getAllCart();
                    for (Cart cart : list) {
                        System.out.println(cart);
                    }
                    break;

                case 6:
                    Orders order = new Orders();
                    OrderItems orderItem = new OrderItems();

                    
                    System.out.println("Enter order id:");
                    order.setOrderId(scanner.nextInt());

                    System.out.println("Enter customer id:");
                    order.setCustomerId(scanner.nextInt());
                    scanner.nextLine(); 

                    
                    LocalDate currentDate = LocalDate.now();
                    order.setOrderDate(currentDate);

                    System.out.println("Enter shipping address:");
                    order.setShippingAddress(scanner.nextLine());

                 
                    System.out.println("Enter product id:");
                    int productId = scanner.nextInt();
                    orderItem.setProductId(productId);

                    System.out.println("Enter quantity:");
                    int quantity = scanner.nextInt();
                    orderItem.setQuantity(quantity);

                    
                    orderItem.setOrderId(order.getOrderId());

                    
                    boolean isValidOrder = OrderServiceImp.validateOrder(orderItem);

                    if (isValidOrder) {
                        // Calculate total price and set in the order
                        double totalPrice = serviceOrd.calculateTotalPrice(order, orderItem); 
                        System.out.println("Total price for the order: " + totalPrice);

                        // Place the order and add order items
                        boolean countOrder = serviceOrd.addOrder(order);
                        boolean countOrderItm = serviceOrderItem.addOrderItems(orderItem);

                        if (countOrder == true && countOrderItm == true) {
                            System.out.println("Order placed successfully.");
                        } else {
                            System.out.println("Unable to place order.");
                        }
                    } else {
                        System.err.println("Invalid order details. Unable to place order.");
                    }
                    break;

                case 7:
                	
                    System.out.println("Enter customer ID:");
                    int customerId = scanner.nextInt();
                    try {
                        List<Orders> ordersList = serviceOrd.getAllOrders(customerId);
                        if (ordersList.isEmpty()) {
                            System.out.println("No orders found for customer ID: " + customerId);
                        } else {
                            for (Orders orderCus : ordersList) {
                                System.out.println(orderCus);
                            }
                        }
                    } catch (CustomerNotFoundException e) {
                        System.err.println("Error: " + e.getMessage());
                    }
                    break;
                    

                case 0:
                    System.out.println("*****Exit******");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.print("Do you want to continue? (true/false): ");
            flag = scanner.nextBoolean();

        } while (flag);

    }

    public static Customer readCstData() {
        Customer cst = new Customer();
        System.out.println("Enter CustomerID=");
        cst.setCustomerId(scanner.nextInt());
        System.out.println("Enter Customer Name=");
        cst.setName(scanner.next());
        System.out.println("Enter Customer Email=");
        cst.setEmail(scanner.next());
        System.out.println("Enter password=");
        cst.setPassword(scanner.next());
        return cst;
    }

    public static Product readPrdData() {
        Product prd = new Product();
        System.out.print("Enter ProductID=");
        prd.setProductId(scanner.nextInt());
        System.out.print("Enter Product Name=");
        prd.setName(scanner.next());
        System.out.print("Enter Product Price=");
        prd.setPrice(scanner.nextInt());
        System.out.print("Enter the Product Description=");
        prd.setDescription(scanner.next());
        System.out.print("Enter number of Stock Quantity=");
        prd.setStockQuantity(scanner.nextInt());
        return prd;
    }
}
