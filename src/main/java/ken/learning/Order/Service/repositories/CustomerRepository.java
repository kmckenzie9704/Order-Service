package ken.learning.Order.Service.repositories;

import ken.learning.Order.Service.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}