package com.example.customerproto.client;

import com.example.customerproto.generated.CustomerOuterClass;
import com.example.customerproto.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductClient {

    @Autowired
    @Qualifier("restTemplateProto")
    private RestTemplate restTemplateProto;

    @Autowired
    @Qualifier("restTemplate")
    private RestTemplate restTemplate;

    private static final String SEARCH_PRODUCT_PROTO = "http://localhost:8081/product/orders/search-proto";
    private static final String SEARCH_PRODUCT = "http://localhost:8081/product/orders/search";

    public CustomerOuterClass.Customer getCustomerProductsProto(CustomerOuterClass.Customer request) {

        ResponseEntity<CustomerOuterClass.Customer> entity = restTemplateProto.postForEntity(SEARCH_PRODUCT_PROTO, request, CustomerOuterClass.Customer.class);

        return entity.getBody();

    }

    public Customer getCustomerProducts(Customer request) {

        ResponseEntity<Customer> entity = restTemplate.postForEntity(SEARCH_PRODUCT, request, Customer.class);

        return entity.getBody();

    }

}
