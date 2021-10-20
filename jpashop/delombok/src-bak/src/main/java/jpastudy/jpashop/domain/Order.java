package jpastudy.jpashop.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;
    //Member 와 N:1 관계
    //FetchType.LAZY 즉 지연로딩을 사용 하는 이유는 성능 최적화 및 JPQL에서 N+1 문제를 일으키는 것을 방지한다.
    //참조를 할때에 @joinColumn 어노테이션을 사용함.
    // ex) sql에서의 reference
    //멤버를 참조하는쪽. Order가 주인이 됨. 48P
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    //Delivery와 1:1 관계
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;
    //OrderItem과의 관계 1:N 관계
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();
    //주문날짜
    private LocalDateTime orderDate;
    //주문상태
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    //--연관관계 메서드
    //Order와 Member
    public void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }

    //Order와 delivery
    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);
    }

    //Order 와 OrderItem(1:N)
    public void addOrderItem(OrderItem orderItem) {
        this.orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public Long getId() {
        return this.id;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public Member getMember() {
        return this.member;
    }

    @SuppressWarnings("all")
    public Delivery getDelivery() {
        return this.delivery;
    }

    @SuppressWarnings("all")
    public List<OrderItem> getOrderItems() {
        return this.orderItems;
    }

    @SuppressWarnings("all")
    public LocalDateTime getOrderDate() {
        return this.orderDate;
    }

    @SuppressWarnings("all")
    public OrderStatus getStatus() {
        return this.status;
    }

    @SuppressWarnings("all")
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    public void setOrderItems(final List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @SuppressWarnings("all")
    public void setOrderDate(final LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    @SuppressWarnings("all")
    public void setStatus(final OrderStatus status) {
        this.status = status;
    }
    //</editor-fold>
}
