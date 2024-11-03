package lotto.domain;

public enum WinningPrize {

    FAILURE(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private final int matchCount;
    private final int prize;

    WinningPrize(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

}
