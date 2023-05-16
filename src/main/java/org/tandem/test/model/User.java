package org.tandem.test.model;

import java.util.HashSet;

public class User {
    private long id;
    private int score;
    private HashSet<String> words;

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

    public void setId(long id) {
        this.id = id;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setWords(HashSet<String> words) {
        this.words = words;
    }
}
