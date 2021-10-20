package jpastudy.jpashop.domain;

import jpastudy.jpashop.domain.item.Item;
import javax.persistence.*;

@Entity
@Table(name = "order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long id;
    //Order와의 관계 n:1
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
    //Item 과의 관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;
    //주문가격
    private int orderPrice;
    //주문수량
    private int count;

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public Long getId() {
        return this.id;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public Order getOrder() {
        return this.order;
    }

    @SuppressWarnings("all")
    public Item getItem() {
        return this.item;
    }

    @SuppressWarnings("all")
    public int getOrderPrice() {
        return this.orderPrice;
    }

    @SuppressWarnings("all")
    public int getCount() {
        return this.count;
    }

    @SuppressWarnings("all")
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    public void setOrder(final Order order) {
        this.order = order;
    }

    @SuppressWarnings("all")
    public void setItem(final Item item) {
        this.item = item;
    }

    @SuppressWarnings("all")
    public void setOrderPrice(final int orderPrice) {
        this.orderPrice = orderPrice;
    }

    @SuppressWarnings("all")
    public void setCount(final int count) {
        this.count = count;
    }

    @SuppressWarnings("all")
    protected OrderItem() {
    }
    //</editor-fold>
}
