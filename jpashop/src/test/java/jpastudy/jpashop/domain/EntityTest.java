package jpastudy.jpashop.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//스프링 프레임워크에서 지원하는 Transactional 어노테이션을 사용하느느것이 javax에서 보다 디테일한 기능을 제공한다.
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class EntityTest {

    @Autowired
    EntityManager em;


    @Test
    //롤백 시키지말라고 옵션을 적어준다.
    @Rollback(value = true)
    public void entity() throws Exception{
        //Member 생성
        Member member = new Member();
        member.setName("몽타");
        Address address = new Address("서울","강남","00011");
        //Member에 Address 를 저장.
        member.setAddress(address);
        em.persist(member);
    }

}