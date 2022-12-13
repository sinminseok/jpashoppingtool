package tool.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tool.shopping.entity.Delivery;
import tool.shopping.repository.customrepository.DeliveryRepositoryCustom;

public interface DeliveryRepository extends JpaRepository<Delivery,Long>, DeliveryRepositoryCustom {

}
