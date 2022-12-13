package tool.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tool.shopping.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
