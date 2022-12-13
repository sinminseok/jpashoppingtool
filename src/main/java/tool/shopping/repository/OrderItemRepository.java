package tool.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tool.shopping.entity.Order;
import tool.shopping.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
