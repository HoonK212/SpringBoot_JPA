package toyproject.toyproject_hanclone;

import org.springframework.context.annotation.Configuration;
import toyproject.toyproject_hanclone.repository.UserRepository;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private EntityManager em;

    public SpringConfig(EntityManager em) {
        this.em = em;
    }
}
