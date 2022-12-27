package tool.shopping.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import tool.shopping.dto.DeliveryDto;
import tool.shopping.entity.DeliveryStatus;
import tool.shopping.entity.Order;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
@Rollback(value = false)
@RunWith(SpringRunner.class)
public class DeliveryServiceTest {

    @Autowired DeliveryService deliveryService;

    @Test
    public void findByOrderTest(){
        //DeliveryStatus status,String address
        DeliveryDto deliveryDto = new DeliveryDto(DeliveryStatus.DELIVERY,"das");
        deliveryService.registerDelivery(deliveryDto);
    }

}