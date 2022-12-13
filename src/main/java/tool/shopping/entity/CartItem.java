package tool.shopping.entity;


import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class CartItem extends BaseTimeEntity{

    @Id
    @GeneratedValue
    @Column(name = "cartitem_id")
    private Long id;

    private int count;
    private String name;
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
