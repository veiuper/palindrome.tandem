package org.tandem.test.storage;

import org.tandem.test.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class InMemoryUserRepository implements UserRepository {
    private final Map<Long, User> users = new HashMap<>();

    @Override
    public Optional<User> get(Long userId) {
        return Optional.ofNullable(users.get(userId));
    }

    @Override
    public void save(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public List<User> getFirstNUsersByScore(int n) {
        return users.values().stream()
                .sorted((u1, u2) -> u2.getScore() - u1.getScore())
                .limit(n)
                .collect(toList());
    }
}
