package toyproject.toyproject_hanclone.repository;

import org.springframework.stereotype.Repository;
import toyproject.toyproject_hanclone.domain.Product;
import toyproject.toyproject_hanclone.domain.User;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class JpaProductRepository implements ProductRepository {

    private final EntityManager em;
    public JpaProductRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Product product) {
        em.persist(product);
    }

    @Override
    public List<Product> findAll() {
        return em.createQuery("select p from Product p", Product.class)
                .getResultList();
    }

    @Override
    public Optional<Product> findById(Long id) {
        Product product = em.find(Product.class, id);
        return Optional.ofNullable(product);
    }

    @Override
    public Optional<Product> findByName(String name) {
        List<Product> result = em.createQuery("select p from Product p where p.name = :name", Product.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }
}
