package jpastudy.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member") //OrderClass 에서 참조하는쪽에게 매핑을 걸어준다. mappedBy = "member"
    private List<Order> orders = new ArrayList<>();



}
