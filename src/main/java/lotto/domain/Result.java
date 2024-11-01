package lotto.domain;


import static lotto.common.NumberConstants.SECOND_RANK_CHANCE;

public enum Result {

    FIRST(1, "2,000,000,000", 6, 0),
    SECOND(2, "30,000,000", 5, 1),
    THIRD(3, "1,500,000", 5, 0),
    FOURTH(4, "50,000", 4, 0),
    FIFTH(5, "5,000", 3, 0),
    NONE(0, "0",  -1, -1);

    private final int rank;
    private final String prize;
    private final int winningNumberCount;
    private final int bonusNumberCount;

    Result(int rank, String prize, Integer winningNumberCount, Integer bonusNumberCount) {
        bonusNumberCount = setBonus(winningNumberCount, bonusNumberCount);
        this.rank = rank;
        this.prize = prize;
        this.winningNumberCount = winningNumberCount;
        this.bonusNumberCount = bonusNumberCount;
    }

    private Integer setBonus(Integer winningNumberCount, Integer bonusNumberCount) {
        if (winningNumberCount == SECOND_RANK_CHANCE) {
            return bonusNumberCount;
        }
        return 0;
    }

    public static Result findByCount(Integer winningNumberCount, Integer bonusNumberCount) {
        for (Result rank : values()) {
            if (found(rank, winningNumberCount, bonusNumberCount)) {
                return rank;
            }
        }
        return NONE;
    }

    private static Boolean found(Result rank, Integer winningNumberCount, Integer bonusNumberCount) {
        return rank.winningNumberCount == winningNumberCount && rank.bonusNumberCount == bonusNumberCount;
    }

    public int rank() {
        return rank;
    }

    public String prize() {
        return prize;
    }

    public long longPrize() {
        return Long.parseLong(prize.replace(",", ""));
    }
}
