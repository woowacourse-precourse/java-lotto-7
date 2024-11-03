package lotto.model.constant;

public enum LottoRank {
    FIRST(2000000000, 6L, false),
    SECOND(30000000, 5L, true),
    THIRD(1500000, 5L, false),
    FOURTH(50000, 4L, false),
    FIFTH(5000, 3L, false),
    NONE(0, 0L, false) {

    };

    private final int prize;
    private final Long winningCount;
    private final Boolean isBonus;

    LottoRank(int prize, Long winningCount, Boolean isBonus) {
        this.prize = prize;
        this.winningCount = winningCount;
        this.isBonus = isBonus;
    }

    public int getPrize() {
        return prize;
    }

    public Boolean getIsBonus() {
        return isBonus;
    }

    public Long getWinningCount() {
        return winningCount;
    }

    public static LottoRank getRank(long winningCount, boolean isBonus) {
        for (LottoRank winning : LottoRank.values()) {
            if (winning.winningCount == winningCount && winning.isBonus.equals(isBonus)) {
                return winning;
            }
        }
        return NONE;
    }
}
