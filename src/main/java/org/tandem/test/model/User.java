package org.tandem.test.model;

import java.util.HashSet;

public class User {
    private final long id;
    private final int score;
    private final HashSet<String> words;

    public User(long id, int score, HashSet<String> words) {
        this.id = id;
        this.score = score;
        this.words = words;
    }

    public long getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public HashSet<String> getWords() {
        return words;
    }
}
