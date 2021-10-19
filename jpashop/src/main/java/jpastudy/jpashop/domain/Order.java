package jpastudy.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    //FetchType.LAZY 즉 지연로딩을 사용 하는 이유는 성능 최적화 및 JPQL에서 N+1 문제를 일으키는 것을 방지한다.
    @JoinColumn(name = "member_id") //멤버를 참조하는쪽. Order가 주인이 됨. 48P
    //참조를 할때에 @joinColumn 어노테이션을 사용함.
    // ex) sql에서의 reference
    private Member member;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;
}
