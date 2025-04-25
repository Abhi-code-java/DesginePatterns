package designpatterns.customer.customercontrol;

import designpatterns.customer.entity.Customer;
import designpatterns.customer.repos.DatabaseServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class CustomerController {
    private final DatabaseServiceFactory databaseServiceFactory;



    public CustomerController(DatabaseServiceFactory databaseServiceFactory) {
        this.databaseServiceFactory = databaseServiceFactory;
    }


}
