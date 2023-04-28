package org.tandem.test.api;

import org.tandem.test.model.Result;
import org.tandem.test.model.User;

import java.util.List;

public interface PalindromeApi {
    Result registerAnswer(long userId, String word);
    List<User> getLeaderboard(int leadersCount);
}
