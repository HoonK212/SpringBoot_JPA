package toyproject.toyproject_hanclone.repository;

import org.springframework.stereotype.Repository;
import toyproject.toyproject_hanclone.domain.Order;
import toyproject.toyproject_hanclone.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Optional;

@Repository
public class JpaOrderRepository implements OrderRepository {

    private final EntityManager em;

    public JpaOrderRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Order order) {
        em.persist(order);
    }

    @Override
    public Optional<Order> findById(Long id) {
        Order order = em.find(Order.class, id);
        return Optional.ofNullable(order);
    }

    @Override
    public void updateStat(Order order) {
        order.setStat(1L);
    }

    @Override
    public void remove(Order order) {
        em.remove(order);
    }
}
