package ken.learning.Order.Service.repositories;

import ken.learning.Order.Service.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}