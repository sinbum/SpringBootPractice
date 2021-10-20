package jpastudy.jpashop.domain;

import javax.persistence.*;

@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private Long id;
    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;
    @Embedded
    private Address address;
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

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
    public Address getAddress() {
        return this.address;
    }

    @SuppressWarnings("all")
    public DeliveryStatus getStatus() {
        return this.status;
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
    public void setAddress(final Address address) {
        this.address = address;
    }

    @SuppressWarnings("all")
    public void setStatus(final DeliveryStatus status) {
        this.status = status;
    }
    //</editor-fold>
}
