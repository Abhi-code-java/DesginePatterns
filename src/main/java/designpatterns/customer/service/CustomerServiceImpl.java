package designpatterns.customer.service;

import designpatterns.customer.dto.CustomerRequestDto;
import designpatterns.customer.dto.CustomerResponseDto;
import designpatterns.customer.dto.ProductRequest;
import designpatterns.customer.dto.ProductResponseDto;
import designpatterns.customer.entity.Customer;
import designpatterns.customer.prostEntity.Products;
import designpatterns.customer.repos.mysql.CustomerRepo;
import designpatterns.customer.repos.postgres.PostGresRepository;
import designpatterns.db.seconddbconnection.singletondesgine.MySQLConnectionSingleton;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class CustomerServiceImpl implements CustomerService{
    private CustomerRepo customerRepo;
    private PostGresRepository postGresRepository;

    public CustomerServiceImpl(CustomerRepo customerRepo, PostGresRepository postGresRepository) {
        this.customerRepo = customerRepo;
        this.postGresRepository = postGresRepository;
    }

    @Override
    public CustomerResponseDto createCu(CustomerRequestDto dto) {
        Customer customer=new Customer();
        customer.setName(dto.getName());
        customerRepo.save(customer);
//        postGresRepository.save(customer);
        return FROMeNTITY(customer);
    }
    public void addCustomer(int id, String name) {
        try {
            Connection conn = MySQLConnectionSingleton.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO customer (id, name) VALUES (?, ?)");
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ProductResponseDto createProduct(ProductRequest products) {
        Products products1=new Products();
        products1.setName(products.getName());
        postGresRepository.save(products1);
        return fromEntity(products1);
    }

    private CustomerResponseDto FROMeNTITY(Customer customer){
        CustomerResponseDto dto=new CustomerResponseDto();
        dto.setName(customer.getName());
        return dto;
    }
    private ProductResponseDto  fromEntity(Products products){
        ProductResponseDto dto=new ProductResponseDto();
        dto.setId(products.getId());
        dto.setName(products.getName());
        return dto;
    }
}
