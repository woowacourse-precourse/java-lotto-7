package lotto.domain;

// 당첨번호 개수 세서 넘겨주고, 보너스 일치번호는 별도로 넘겨줌
public enum Rank {
    FIFTH_PRIZE(3, 5_000, "3개 일치 (5,000원)"),
    FOURTH_PRIZE(4, 50_000, "4개 일치 (50,000원)"),
    THIRD_PRIZE(5, 1_500_000, "5개 일치 (1,500,000원)"),
    SECOND_PRIZE(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST_PRIZE(6, 2_000_000_000, "6개 일치 (2,000,000,000원)");

    private final int matchingCount;
    private final long prize;
    private final String description;

    Rank(int matchingCount, int prize, String description) {
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

    public static Rank getRank(int matchingCount, boolean bonusMatching) {
        if (matchingCount == 6) {
            return FIRST_PRIZE;
        }

        if (matchingCount == 5 && bonusMatching) {
            return SECOND_PRIZE;
        }

        for (Rank rank : values()) {
            if (rank.matchingCount == matchingCount && rank != SECOND_PRIZE) {
                return rank; // 그 외 일치하는 경우 반환
            }
        }

        return null;
    }
}
