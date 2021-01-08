package toyproject.toyproject_hanclone.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class JpaProductRepository implements ProductRepository {

    private final EntityManager em;

    public JpaProductRepository(EntityManager em) {
        this.em = em;
    }
}
