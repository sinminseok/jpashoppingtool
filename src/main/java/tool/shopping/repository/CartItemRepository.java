package tool.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tool.shopping.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
}
