package lotto.model;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

    private final int sameCount;
    private final int reward;

    Rank(int sameCount, int reward) {
        this.sameCount = sameCount;
        this.reward = reward;
    }
}
