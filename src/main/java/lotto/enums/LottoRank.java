package lotto.enums;

public enum LottoRank {
    NONE(0, 0, "미당첨"),
    FIFTH(3, 5_000, "3개 일치"),
    FOURTH(4, 50_000, "4개 일치"),
    THIRD(5, 1_500_000, "5개 일치"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치"),
    FIRST(6, 2_000_000_000, "6개 일치");

    private final int matchingCount;
    private final int prize;
    private final String description;

    LottoRank(int matchingCount, int prize, String description) {
        this.matchingCount = matchingCount;
        this.prize = prize;
        this.description = description;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public int getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }

    public static LottoRank valueOf(int count, boolean bonusMatched) {
        if (count == 6) {
            return FIRST;
        }
        if (count == 5 && bonusMatched) {
            return SECOND;
        }
        if (count == 5) {
            return THIRD;
        }
        if (count == 4) {
            return FOURTH;
        }
        if (count == 3) {
            return FIFTH;
        }
        return NONE;
    }
}
