package tool.shopping.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import tool.shopping.dto.DeliveryDto;
import tool.shopping.dto.ItemDto;
import tool.shopping.dto.MemberDto;
import tool.shopping.entity.Delivery;
import tool.shopping.entity.DeliveryStatus;
import tool.shopping.entity.Member;
import tool.shopping.entity.MemberRole;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
@Rollback(value = false)
@RunWith(SpringRunner.class)
public class OrderServiceTest {

    @Autowired OrderService orderService;
    @Autowired MemberService memberService;
    @Autowired ItemService itemService;
    @Autowired DeliveryService deliveryService;




}