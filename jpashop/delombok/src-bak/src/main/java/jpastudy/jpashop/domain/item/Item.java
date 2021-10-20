package jpastudy.jpashop.domain.item;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
public abstract class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;
    //상품이름
    private String name;
    //상품가격
    private int price;
    //재고수량
    private int stockQuantity;

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public Long getId() {
        return this.id;
    }

    @SuppressWarnings("all")
    public String getName() {
        return this.name;
    }

    @SuppressWarnings("all")
    public int getPrice() {
        return this.price;
    }

    @SuppressWarnings("all")
    public int getStockQuantity() {
        return this.stockQuantity;
    }

    @SuppressWarnings("all")
    public void setId(final Long id) {
        this.id = id;
    }

    @SuppressWarnings("all")
    public void setName(final String name) {
        this.name = name;
    }

    @SuppressWarnings("all")
    public void setPrice(final int price) {
        this.price = price;
    }

    @SuppressWarnings("all")
    public void setStockQuantity(final int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
    //</editor-fold>
}
