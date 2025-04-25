package designpatterns.customer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="customers")
public class Customer {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
private String name;

}
