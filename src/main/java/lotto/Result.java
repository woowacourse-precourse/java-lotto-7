package lotto;

import java.util.Arrays;

public enum Result {
    FIRST(6, 2000000000),
    SECOND(5.5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    OUTOFRANK(0, 0);


    private final double winningPoints;
    private final int prize;
    private int winningCounts;

    private Result(double winningCounts, int prize) {
        this.winningPoints = winningCounts;
        this.prize = prize;
        this.winningCounts = 0;
    }

    public static Result getRank(double winningCounts) {
        return Arrays.stream(values())
                .filter(value -> winningCounts == value.winningPoints)
                .findAny()
                .orElse(OUTOFRANK);
    }

    public static int totalPrize() {
        int totalPrize = 0;
        for(Result rank : values()) {
            totalPrize += (rank.prize() * rank.winningCounts);
        }
        return totalPrize;
    }

    public void winningCountsUp() {
        this.winningCounts++;
    }

    public int prize() {
        return prize;
    }
}
