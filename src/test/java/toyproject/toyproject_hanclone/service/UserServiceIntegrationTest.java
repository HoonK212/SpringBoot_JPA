package toyproject.toyproject_hanclone.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import toyproject.toyproject_hanclone.domain.User;
import toyproject.toyproject_hanclone.repository.UserRepository;
import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
public class UserServiceIntegrationTest {

    @Autowired UserService userService;

    @BeforeEach
    void beforeEach() {}

    @AfterEach
    void afterEach() {}

    @Test
    public void join() {
        // given
        User user = new User();
        user.setName("Hoon");
        user.setPw("1234");

        // when
        Long saveId = userService.join(user);
        User findUser = userService.findOne(saveId).get();

        // then
        assertThat(findUser.getName()).isEqualTo(user.getName());
    }

    @Test
    public void validateDuplicateUser() {
        // given
        User user1 = new User();
        user1.setName("Hoon");
        user1.setPw("1234");
        User user2 = new User();
        user2.setName("Hoon");
        user2.setPw("1234");

        // when
        userService.join(user1);

        // then
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> userService.join(user2));
    }

    @Test
    public void findUsers() {
        // given
        User user1 = new User();
        user1.setName("Hoon1");
        user1.setPw("1234");
        User user2 = new User();
        user2.setName("Hoon2");
        user2.setPw("1234");

        // when
        userService.join(user1);
        userService.join(user2);
        List<User> result = userService.findUsers();

        // then
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    public void findOne() {
        // given
        User user = new User();
        user.setName("Hoon");
        user.setPw("1234");

        // when
        userService.join(user);
        User result = userService.findOne("Hoon").get();

        // then
        assertThat(result).isEqualTo(user);
    }
}
