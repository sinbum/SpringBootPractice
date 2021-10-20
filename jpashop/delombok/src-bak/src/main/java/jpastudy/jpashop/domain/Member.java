package jpastudy.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private long id;
    private String name;
    @Embedded
    private Address address;
    //OrderClass 에서 참조하는쪽에게 매핑을 걸어준다. mappedBy = "member"
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    public String getName() {
        return this.name;
    }

    @SuppressWarnings("all")
    public Address getAddress() {
        return this.address;
    }

    @SuppressWarnings("all")
    public List<Order> getOrders() {
        return this.orders;
    }

    @SuppressWarnings("all")
    public void setId(final long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    public void setName(final String name) {
        this.name = name;
    }

    @SuppressWarnings("all")
    public void setAddress(final Address address) {
        this.address = address;
    }

    @SuppressWarnings("all")
    public void setOrders(final List<Order> orders) {
        this.orders = orders;
    }
    //</editor-fold>
}
