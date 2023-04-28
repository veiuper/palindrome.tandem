package org.tandem.test.storage;

import org.tandem.test.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> get(Long userId);
    void save(User user);
    List<User> getFirstNUsersByScore(int n);
}
