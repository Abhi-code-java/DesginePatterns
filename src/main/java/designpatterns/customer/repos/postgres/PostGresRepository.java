package designpatterns.customer.repos.postgres;

import designpatterns.customer.prostEntity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostGresRepository extends JpaRepository<Products,Integer> {

}
