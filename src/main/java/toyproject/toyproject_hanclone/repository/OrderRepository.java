package toyproject.toyproject_hanclone.repository;

import toyproject.toyproject_hanclone.domain.Order;

import java.util.Optional;

public interface OrderRepository {

    void save(Order order);

    Optional<Order> findById(Long id);

    void updateStat(Order order);

    void remove(Order order);
}
