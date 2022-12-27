package tool.shopping.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class CartItem extends BaseTimeEntity{

    @Id
    @GeneratedValue
    @Column(name = "cartitem_id")
    private Long id;

    //추후제거
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
