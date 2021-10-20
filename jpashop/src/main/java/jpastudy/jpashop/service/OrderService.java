package jpastudy.jpashop.service;

import jpastudy.jpashop.domain.*;
import jpastudy.jpashop.domain.item.Item;
import jpastudy.jpashop.repository.ItemRepository;
import jpastudy.jpashop.repository.MemberRepository;
import jpastudy.jpashop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {
    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;

    /**
     * 주문생성 처리
     * @param memberId 회원Id
     * @param itemId 상품id
     * @param count 주문수량
     * @return 주문 id
     */
    @Transactional
    public Long order(Long memberId, Long itemId, int count) {

        //멤버 조회
        Member member = memberRepository.findOne(memberId);

        //아이템 조회
        Item item = itemRepository.findOne(itemId);

        //배송정보 생성
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());
        delivery.setStatus(DeliveryStatus.READY);

        //주문상품 생성(Order Item 생성)
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        //주문 생성(Order 생성)
        Order order = Order.createOrder(member, delivery, orderItem);

        //주문 저장
        orderRepository.save(order);
        return order.getId();
    }

    /**
     * 주문 취소
     * @param orderId 주문id
     */
    @Transactional
    public void cancelOrder(Long orderId) {
//주문 엔티티 조회
        Order order = orderRepository.findOne(orderId);
//주문 취소
        order.cancel();
    }

    /**
     * 주문 검색
     * @param orderSearch 회원번호, 주문상태
     * @return 주문목록
     *
     */
//    public List<Order> findOrders(OrderSearch orderSearch) {
//        return orderRepository.findAll(orderSearch);
//    }
}
