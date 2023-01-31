package ken.learning.Order.Service.repositories;

import ken.learning.Order.Service.domain.OrderApproval;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderApprovalRepository extends JpaRepository<OrderApproval, Long> {
}
