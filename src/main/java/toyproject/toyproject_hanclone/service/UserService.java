package toyproject.toyproject_hanclone.service;

import org.springframework.stereotype.Service;
import toyproject.toyproject_hanclone.domain.User;
import toyproject.toyproject_hanclone.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 회원 가입
    public Long join(User user) {
        validateDuplicateUser(user);
        userRepository.save(user);
        return user.getId();
    }

    // 중복 회원 검증
    private void validateDuplicateUser(User user) {
        userRepository.findByName(user.getName())
                .ifPresent(u -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    // 전체 회원 조회
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    // 특정 회원 조회
    public Optional<User> findOne(Long id) {
        return userRepository.findById(id);
    }
    public Optional<User> findOne(String name) {
        return userRepository.findByName(name);
    }
}
