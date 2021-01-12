package toyproject.toyproject_hanclone.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import toyproject.toyproject_hanclone.domain.Product;
import toyproject.toyproject_hanclone.domain.User;

import javax.transaction.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
public class ProductServiceIntegrationTest {

    @Autowired ProductService productService;

    @BeforeEach
    void beforeEach() {}

    @AfterEach
    void afterEach() {}

    @Test
    public void add() throws Exception {
        // given
        Product prod = new Product();
        prod.setName("Item");
        prod.setPrice(1000L);

        // when
        Long saveId = productService.add(prod);
        Product findProd = productService.findOne(saveId).get();

        // then
        assertThat(findProd.getName()).isEqualTo(prod.getName());
    }

    @Test
    public void findProducts() {
        // given
        Product prod1 = new Product();
        prod1.setName("Item1");
        prod1.setPrice(1000L);
        Product prod2 = new Product();
        prod2.setName("Item2");
        prod2.setPrice(2000L);

        // when
        productService.add(prod1);
        productService.add(prod2);
        List<Product> result = productService.findProducts();

        // then
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    public void findOne() {
        // given
        Product prod = new Product();
        prod.setName("Item");
        prod.setPrice(1000L);

        // when
        productService.add(prod);
        Product result = productService.findOne("Item").get();

        // then
        assertThat(result).isEqualTo(prod);
    }
}
