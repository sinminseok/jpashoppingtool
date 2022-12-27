package tool.shopping.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import tool.shopping.entity.Item;
import tool.shopping.repository.customrepository.ItemRepositoryCustom;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,Long>, ItemRepositoryCustom {

    List<Item> findByNameContaining(String name);

}
