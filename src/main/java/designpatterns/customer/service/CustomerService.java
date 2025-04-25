package designpatterns.customer.service;

import designpatterns.customer.dto.CustomerRequestDto;
import designpatterns.customer.dto.CustomerResponseDto;
import designpatterns.customer.dto.ProductRequest;
import designpatterns.customer.dto.ProductResponseDto;

public interface CustomerService {
    CustomerResponseDto createCu(CustomerRequestDto dto);
    ProductResponseDto createProduct(ProductRequest products);
}
