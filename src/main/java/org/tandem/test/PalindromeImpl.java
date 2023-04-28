package org.tandem.test;

import org.tandem.test.api.PalindromeApi;
import org.tandem.test.api.PalindromeRulesHelper;
import org.tandem.test.model.Result;
import org.tandem.test.model.User;
import org.tandem.test.storage.UserRepository;

import java.util.HashSet;
import java.util.List;

import static org.tandem.test.model.ResultStatus.IS_NOT_PALINDROME;
import static org.tandem.test.model.ResultStatus.OK;
import static org.tandem.test.model.ResultStatus.WORD_ALREADY_USED;

public class PalindromeImpl implements PalindromeApi {
    private final UserRepository userRepository;
    private final PalindromeRulesHelper palindromeRulesHelper;

    public PalindromeImpl(UserRepository userRepository, PalindromeRulesHelper palindromeRulesHelper) {
        this.userRepository = userRepository;
        this.palindromeRulesHelper = palindromeRulesHelper;
    }

    @Override
    public Result registerAnswer(long userId, String word) {
        if (palindromeRulesHelper.isPalindrome(word)) {
            int points = palindromeRulesHelper.getPoints(word);
            User user = userRepository.get(userId).orElseGet(() -> new User(userId, 0, new HashSet<>()));
            if (user.getWords().contains(word)) {
                return new Result(WORD_ALREADY_USED, 0);
            }
            User updatedUser = new User(user.getId(), user.getScore() + points, addNewWord(user.getWords(), word));
            userRepository.save(updatedUser);
            return new Result(OK, points);
        }
        return new Result(IS_NOT_PALINDROME, 0);
    }

    @Override
    public List<User> getLeaderboard(int leadersCount) {
        return userRepository.getFirstNUsersByScore(leadersCount);
    }

    private HashSet<String> addNewWord(HashSet<String> words, String word) {
        words.add(word);
        return words;
    }
}
