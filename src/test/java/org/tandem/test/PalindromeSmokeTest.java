package org.tandem.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.tandem.test.api.PalindromeApi;
import org.tandem.test.model.Result;
import org.tandem.test.model.User;
import org.tandem.test.storage.InMemoryUserRepository;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.tandem.test.model.ResultStatus.OK;

public class PalindromeSmokeTest {
    private static final Random RANDOM = new Random();
    private PalindromeApi PalindromeApi;

    @BeforeEach
    public void init() {
        PalindromeApi = new PalindromeImpl(new InMemoryUserRepository(), new AlphanumericPalindromeRulesHelper());
    }

    @Test
    public void registerAnswerAndUpdateScore() {
        Result actual = PalindromeApi.registerAnswer(RANDOM.nextLong(), "топот");
        assertEquals(OK, actual.getStatus());
        assertEquals(5, actual.getAcquiredPoints());
    }

    @Test
    public void getLeadersBoard() {
        long userId1 = RANDOM.nextLong();
        long userId2 = RANDOM.nextLong();
        PalindromeApi.registerAnswer(userId1, "топот");
        PalindromeApi.registerAnswer(userId2, "тотопотот");
        List<User> actual = PalindromeApi.getLeaderboard(2);
        assertEquals(userId2, actual.get(0).getId());
        assertEquals(userId1, actual.get(1).getId());
        assertEquals(9, actual.get(0).getScore());
        assertEquals(5, actual.get(1).getScore());
    }
}
