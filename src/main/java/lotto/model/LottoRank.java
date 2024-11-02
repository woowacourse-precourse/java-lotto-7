package lotto.model;

public enum LottoRank {
    FIRST(6, 2_000_000_000, "6개 일치"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, 1_500_000, "5개 일치"),
    FOURTH(4, 50_000, "4개 일치"),
    FIFTH(3, 5_000, "3개 일치"),
    NONE(0, 0, "3개 미만 일치"),
    ;
    private final int matchingCount;
    private final int prizeAmount;
    private final String message;

    LottoRank(int matchingCount, int prizeAmount, String message) {
        this.matchingCount = matchingCount;
        this.prizeAmount = prizeAmount;
        this.message = message;
    }

    public static LottoRank rankFrom(long matchingCount, boolean isBonusNumberMatched) {
        if (matchingCount == 6) {
            return FIRST;
        }
        if (matchingCount == 5 && isBonusNumberMatched) {
            return SECOND;
        }
        if (matchingCount == 5) {
            return THIRD;
        }
        if (matchingCount == 4) {
            return FOURTH;
        }
        if (matchingCount == 3) {
            return FIFTH;
        }
        return NONE;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public String getMessage() {
        return message;
    }
}
