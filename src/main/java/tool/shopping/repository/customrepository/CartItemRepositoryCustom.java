package tool.shopping.repository.customrepository;

import org.springframework.data.jpa.repository.EntityGraph;
import tool.shopping.entity.CartItem;
import tool.shopping.entity.Member;

import java.util.List;

public interface CartItemRepositoryCustom {

    //장바구니 아이템 가져올때 fetch join으로 연관된 item,member를 쿼리하나로 조회한다.
    @EntityGraph(attributePaths = {"item"})
    List<CartItem> findAllByMember(Member member);
}
