package tool.shopping.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "Orders")
@NoArgsConstructor
public class Order extends BaseTimeEntity{

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    private LocalDateTime orderdate;

    //Order Member 연관관계
    //연관관계 주인에서 지연로딩 설정(필요할때만 조회)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    //Order Delivery 연관관계
    //연관관계 주인에서 지연로딩 설정(필요할때만 조회)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @OneToMany(mappedBy = "order",cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Order(Member member,Delivery delivery,List<OrderItem> orderItem){
        this.member = member;
        this.delivery =delivery;
        this.orderItems = orderItem;
    }





}
