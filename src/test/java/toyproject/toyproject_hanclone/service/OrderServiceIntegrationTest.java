package toyproject.toyproject_hanclone.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import toyproject.toyproject_hanclone.domain.Order;
import toyproject.toyproject_hanclone.domain.Product;
import toyproject.toyproject_hanclone.domain.User;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
public class OrderServiceIntegrationTest {

    @Autowired UserService userService;
    @Autowired ProductService productService;
    @Autowired OrderService orderService;

    @BeforeEach
    void beforeEach() {}

    @AfterEach
    void afterEach() {}

    @Test
    public void buy() {
        // given
        User user = userService.findOne("Hoon1").get();
        Product prod = productService.findOne("Item1").get();

        Order order = new Order();
        order.setAmount(1L);
        order.setUser(user);
        order.setProduct(prod);

        // when
        Long saveId = orderService.buy(order);
        Order findOrder = orderService.findOne(saveId).get();

        // then
        assertThat(findOrder.getUser().getName()).isEqualTo(user.getName());
        assertThat(findOrder.getProduct().getName()).isEqualTo(prod.getName());
    }

    @Test
    public void deliver() {
        // given
        Order findOrder = orderService.findOne(1L).get();

        // when
        orderService.deliver(findOrder);

        // then
        assertThat(orderService.findOne(1L).get().getStat()).isEqualTo(1);
    }

    @Test
    public void cancel() {
        //given
        Order findOrder = orderService.findOne(1L).get();

        //when
        orderService.cancel(findOrder);

        //then
        assertThat(orderService.findOne(1L).isEmpty()).isEqualTo(true);
    }
}
