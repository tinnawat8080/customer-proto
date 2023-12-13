package com.example.customerproto.controller;

import com.example.customerproto.client.ProductClient;
import com.example.customerproto.generated.CustomerOuterClass;
import com.example.customerproto.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class CustomerController {

    @Autowired
    private ProductClient productClient;

    @RequestMapping("/{customerId}/product-orders-proto")
    CustomerOuterClass.Customer getCustomerProductOrdersProto(@PathVariable Integer customerId) {
        UUID uuid = UUID.randomUUID();
        CustomerOuterClass.Customer customer = CustomerOuterClass.Customer.newBuilder()
                .setId(uuid.toString())
                .setFirstName("Tinnawat")
                .setLastName("Chongrag")
                .setEmail("tinnawat@gmail.com")
                .build();

        return productClient.getCustomerProductsProto(customer);
    }

    @RequestMapping("/{customerId}/product-orders")
    Customer getCustomerProductOrders(@PathVariable Integer customerId) {
        UUID uuid = UUID.randomUUID();
        Customer customer = Customer.builder()
                .id(uuid.toString())
                .firstName("Tinnawat")
                .lastName("Chongrag")
                .email("tinnawat@gmail.com")
                .build();

        return productClient.getCustomerProducts(customer);
    }


}
