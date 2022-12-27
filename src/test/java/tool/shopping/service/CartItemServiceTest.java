package tool.shopping.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import tool.shopping.AppConfig;
import tool.shopping.dto.CartItemDto;
import tool.shopping.dto.ItemDto;
import tool.shopping.dto.MemberDto;
import tool.shopping.entity.CartItem;
import tool.shopping.entity.Item;
import tool.shopping.entity.Member;
import tool.shopping.repository.ItemRepository;
import tool.shopping.repository.MemberRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@RunWith(SpringRunner.class)
public class CartItemServiceTest {

    @Autowired
    CartItemService cartItemService;
    @Autowired MemberService memberService;
    @Autowired ItemService itemService;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    ItemRepository itemRepository;

    AppConfig appConfig = new AppConfig();

    @Test
    public void 장바구니담기() throws Exception {
        ItemDto byID = itemService.findByID(5L);
        //int count, String name, int price, Member member, Item item
        MemberDto memberDto = memberService.findByName("33");

        CartItemDto cartItemDto = new CartItemDto(memberDto,byID);
        cartItemService.save(cartItemDto);
    }



}