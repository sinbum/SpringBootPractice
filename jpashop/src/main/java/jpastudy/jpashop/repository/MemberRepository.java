package jpastudy.jpashop.repository;

import jpastudy.jpashop.domain.Member;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;
//final 변수를 인자로 받는 생성자 함수를 자동으로 생성.
@Repository
public class MemberRepository {
    //@PersistenceContext
    //@Autowired 대체 가능함.
    private final EntityManager em;

    //등록
    public void save(Member member) {
        em.persist(member);
    }

    // id로 member 한개 조회
    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    // Member 모두 조회
    public List<Member> findAll() {
        //TypedQuery
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    // Name 으로 Member 하나 또는 여러개 조회
    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class).setParameter("name", name).getResultList();
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public MemberRepository(final EntityManager em) {
        this.em = em;
    }
    //</editor-fold>
}
