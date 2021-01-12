package toyproject.toyproject_hanclone.service;

import org.springframework.stereotype.Service;
import toyproject.toyproject_hanclone.domain.Product;
import toyproject.toyproject_hanclone.domain.User;
import toyproject.toyproject_hanclone.repository.ProductRepository;
import toyproject.toyproject_hanclone.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 상품 추가
    public Long add(Product product) {
        productRepository.save(product);
        return product.getId();
    }

    // 전체 상품 조회
    public List<Product> findProducts() {
        return productRepository.findAll();
    }

    // 특정 상품 조회
    public Optional<Product> findOne(Long id) { return productRepository.findById(id);
    }
    public Optional<Product> findOne(String name) {
        return productRepository.findByName(name);
    }
}
