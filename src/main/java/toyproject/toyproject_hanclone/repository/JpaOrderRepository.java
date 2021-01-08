package toyproject.toyproject_hanclone.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class JpaOrderRepository implements OrderRepository {

    private final EntityManager em;

    public JpaOrderRepository(EntityManager em) {
        this.em = em;
    }
}
