package tool.shopping.form;

import lombok.Getter;
import lombok.Setter;
import tool.shopping.entity.OrderStatus;

@Getter
@Setter
public class OrderSearch {
    private String memberName;
    private OrderStatus orderStatus;
}
