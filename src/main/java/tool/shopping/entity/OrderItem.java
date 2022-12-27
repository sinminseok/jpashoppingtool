package tool.shopping.entity;


import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class OrderItem extends BaseTimeEntity{


    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;
    private int count;
    private int price;

    //cascade = CascadeType.PERSIST 삭제
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;
}
