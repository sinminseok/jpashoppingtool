package tool.shopping.repository.customrepository;

import tool.shopping.entity.Item;

import java.util.List;

public interface ItemRepositoryCustom {

    //상품이름 검색 메서드
    List<Item> findByName(String name);
}
