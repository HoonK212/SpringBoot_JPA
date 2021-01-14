package toyproject.toyproject_hanclone.repository;

import toyproject.toyproject_hanclone.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    void save(User user);

    List<User> findAll();

    Optional<User> findById(Long id);
    Optional<User> findByName(String name);
}
