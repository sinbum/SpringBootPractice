package jpastudy.jpashop.domain.item;


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


}
