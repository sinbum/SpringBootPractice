package jpastudy.jpashop.web;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookForm {
    private Long id;
    private String name;
    private int price;
//    @Min(Value = 1,message = "상품 재고수량은 1개 이상이어야 합니다.")
    private int stockQuantity;
    private String author;
    private String isbn;
}
