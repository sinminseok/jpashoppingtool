package tool.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tool.shopping.entity.Item;
import tool.shopping.repository.customrepository.ItemRepositoryCustom;

public interface ItemRepository extends JpaRepository<Item,Long>, ItemRepositoryCustom {
}
