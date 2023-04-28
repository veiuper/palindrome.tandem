package org.tandem.test;

import org.junit.jupiter.api.Test;
import org.tandem.test.model.User;
import org.tandem.test.storage.InMemoryUserRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryUserRepositoryTest {

    // TODO Для составления перечня тестов использовать первые 2 техники тест-дизайна из https://habr.com/ru/articles/549054/
    @Test
    public void getFirstNLeadersByScoreDescAndIdAsc(){
        InMemoryUserRepository userRepository = new InMemoryUserRepository();
        userRepository.save(new User(1, 2, null));
        userRepository.save(new User(2, 2, null));
        userRepository.save(new User(3, 3333, null));

        List<User> actual = userRepository.getFirstNUsersByScore(5);

        assertEquals(3, actual.size());
        assertEquals(3, actual.get(0).getId());
        assertEquals(1, actual.get(1).getId());
        assertEquals(2, actual.get(2).getId());
    }
}