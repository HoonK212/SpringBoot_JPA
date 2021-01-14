package toyproject.toyproject_hanclone.service;

import org.springframework.stereotype.Service;
import toyproject.toyproject_hanclone.domain.Order;
import toyproject.toyproject_hanclone.domain.User;
import toyproject.toyproject_hanclone.repository.OrderRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // 구매
    public Long buy(Order order) {
        orderRepository.save(order);
        return order.getId();
    }

    // 특정 주문 조회
    public Optional<Order> findOne(Long id) {
        return orderRepository.findById(id);
    }

    // 배송
    public void deliver(Order order) {
        orderRepository.updateStat(order);
    }

    // 주문 취소
    public void cancel(Order order) {
        orderRepository.remove(order);
    }
}
