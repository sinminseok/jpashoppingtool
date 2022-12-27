package tool.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tool.shopping.entity.CartItem;
import tool.shopping.repository.customrepository.CartItemRepositoryCustom;

public interface CartItemRepository extends JpaRepository<CartItem,Long>, CartItemRepositoryCustom {
}
