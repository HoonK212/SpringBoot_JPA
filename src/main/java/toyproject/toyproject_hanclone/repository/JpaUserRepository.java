package toyproject.toyproject_hanclone.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class JpaUserRepository implements UserRepository {

    private final EntityManager em;

    public JpaUserRepository(EntityManager em) {
        this.em = em;
    }
}
