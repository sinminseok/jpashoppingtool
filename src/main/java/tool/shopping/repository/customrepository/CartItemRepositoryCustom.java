package tool.shopping.repository.customrepository;

import tool.shopping.entity.CartItem;
import tool.shopping.entity.Member;

import java.util.List;

public interface CartItemRepositoryCustom {

    List<CartItem> findAllByMember(Member member);
}
