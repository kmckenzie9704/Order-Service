package ken.learning.Order.Service.repositories;

import ken.learning.Order.Service.domain.OrderHeader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderHeaderRepository  extends JpaRepository<OrderHeader, Long>{
//    OrderHeader getOrderHeaderById(Long Id);

//    OrderHeader deleteById(Long id);
}
