package tool.shopping.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import tool.shopping.AppConfig;
import tool.shopping.dto.ItemDto;
import tool.shopping.entity.Item;
import tool.shopping.repository.ItemRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
@Rollback(value = false)
@RunWith(SpringRunner.class)
public class ItemServiceTest {

    @Autowired
    ItemService itemService;

    @Autowired
    ItemRepository itemRepository;

    AppConfig appConfig = new AppConfig();

//    @Test
//    public void 상품등록() throws Exception {
//        ItemDto itemDto = new ItemDto("item1",10,20);
//        Long id = itemService.save(itemDto);
//        itemService.findByID(id)
//        System.out.println("save = "+ save.getName());
//        Assertions.assertThat(save.getName()).isEqualTo("item1");

//    }

    @Test
    public void 상품한개찾기() throws Exception {
        ItemDto itemDto = new ItemDto("item1",10,20);
        itemService.save(itemDto);
    }



    @Test
    public void 상품명검색(){
        ItemDto itemDto = new ItemDto("item1",10,20);
       itemService.save(itemDto);
        List<ItemDto> item1 = itemService.findByName("item1");
        for (ItemDto element : item1){
            System.out.println("element = " + element.getName());
        }
        Assertions.assertThat(item1.size()).isEqualTo(1);
    }

    @Test
    public void 상품삭제(){
        ItemDto itemDto = new ItemDto("item1",10,20);
        itemService.save(itemDto);

        List<ItemDto> finditem = itemService.findByName("item1");
        itemService.delete(finditem.get(0));

        List<ItemDto> item1 = itemService.findByName("item1");
        Assertions.assertThat(item1.size()).isEqualTo(0);
    }

    @Test
    public void 모든상품조회(){
        ItemDto itemDto = new ItemDto("item1",10,20);
        itemService.save(itemDto);
        ItemDto itemDt2 = new ItemDto("item2",10,20);
        itemService.save(itemDt2);
        List<ItemDto> findall = itemService.findall();
        Assertions.assertThat(findall.size()).isEqualTo(2);
    }




}