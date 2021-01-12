package toyproject.toyproject_hanclone.repository;

import toyproject.toyproject_hanclone.domain.Product;
import toyproject.toyproject_hanclone.domain.User;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    void save(Product product);

    List<Product> findAll();

    Optional<Product> findById(Long id);
    Optional<Product> findByName(String name);
}
