package com.github.wesleyegberto.eurekaclientstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StockServiceUsingRibbon implements StockService {

    @Autowired
    private LoadBalancerClient loadBalancer;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Integer getAvailableStock(String sku) {
        ServiceInstance instance = loadBalancer.choose("stock-service");

        String uri = new StringBuilder(instance.getUri().toString())
            .append("/stocks/products/")
            .append(sku)
            .append("/available")
            .toString();

        ResponseEntity<Integer> response = restTemplate.getForEntity(uri, Integer.class);
        return response.getBody();
    }
}
