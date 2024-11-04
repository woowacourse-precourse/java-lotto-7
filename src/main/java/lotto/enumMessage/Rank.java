package lotto.enumMessage;

public enum Rank {
    FIFTH(3, 5_000, "3개 일치 (5,000원) - "),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - "),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - ");

    private final int matchingCount;
    private final long prize;
    private final String description;

    Rank(int matchingCount, long prize, String description) {
        this.matchingCount = matchingCount;
        this.prize = prize;
        this.description = description;
    }

    public long getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }

    public static Rank valueOf(int matchingCount, boolean hasBonusNumber) {
        if (matchingCount == 6) {
            return FIRST;
        }
        if (matchingCount == 5) {
            if (hasBonusNumber) return SECOND;
            return THIRD;
        }
        if (matchingCount == 4) {
            return FOURTH;
        }
        if (matchingCount == 3) {
            return FIFTH;
        }
        return null;
    }
}
