package lotto.model;

import java.util.Arrays;

public enum Winning {

    NO_WIN      (0, "0", "0", 0),
    FIFTH_PLACE (5, "3", "0", 5000),
    FOURTH_PLACE(4, "4", "0", 50000),
    THIRD_PLACE (3, "5", "0", 1500000),
    SECOND_PLACE(2, "5", "1", 30000000),
    FIRST_PLACE (1, "6", "0", 2000000000);

    private final int rank;
    private final String winningNumberMatch;
    private final String bonusNumberMatch;
    private final long prizeMoney;

    Winning(int rank, String winningNumberMatch, String bonusNumberMatch, long prizeMoney) {
        this.rank = rank;
        this.winningNumberMatch = winningNumberMatch;
        this.bonusNumberMatch = bonusNumberMatch;
        this.prizeMoney = prizeMoney;
    }

    public static Winning getPlaceByMatch(int winningNumberMatch, int bonusNumberMatch) {
        return Arrays.stream(Winning.values())
                .filter(winning -> winning.isMatch(String.valueOf(winningNumberMatch), String.valueOf(bonusNumberMatch)))
                .findFirst()
                .orElse(Winning.NO_WIN);
    }

    public static Winning getPlaceByRank(int rank) {
        return Arrays.stream(Winning.values())
                .filter(winning -> winning.rank == rank)
                .findFirst()
                .orElse(Winning.NO_WIN);
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    private boolean isMatch(String winningNumberMatch, String bonusNumberMatch) {
        return this.winningNumberMatch.equals(winningNumberMatch) && this.bonusNumberMatch.equals(bonusNumberMatch);
    }
}
