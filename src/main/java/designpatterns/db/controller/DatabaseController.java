package designpatterns.db.controller;

import designpatterns.customer.dto.CustomerRequestDto;
import designpatterns.customer.dto.CustomerResponseDto;
import designpatterns.customer.dto.ProductRequest;
import designpatterns.customer.dto.ProductResponseDto;
import designpatterns.customer.service.CustomerService;
import designpatterns.db.dbfactory.ChooseDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("database")
public class DatabaseController {
    private final ChooseDatabase chooseDatabase;
    @Autowired
    private CustomerService service;

    public DatabaseController() {
        this.chooseDatabase = new ChooseDatabase();
    }

//    @GetMapping("/{database}")
//    public void launch(@PathVariable("database") String connection) throws SQLException {
//        try {
//            chooseDatabase.getConnection(connection);
//
//        } catch (IllegalArgumentException e) {
//            System.out.println("❌ Invalid selection. Please enter one of: MySQL, H2, MONGODB");
//        } catch (SQLException e) {
//            System.out.println("❌ Failed to connect to database: " + e.getMessage());
//        }
//
//    }

    @PostMapping("/Create")
    public ResponseEntity<CustomerResponseDto> create(@RequestBody CustomerRequestDto dto) {
        return ResponseEntity.ok(service.createCu(dto));
    }

    @PostMapping("/CreateProduct")
    public ResponseEntity<ProductResponseDto> createP(@RequestBody ProductRequest dto) {
        return ResponseEntity.ok(service.createProduct(dto));
    }
}
//        System.out.println("Available options: MySQL | H2 | MONGODB");


