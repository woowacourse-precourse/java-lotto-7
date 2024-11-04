package lotto.model;

import java.util.Arrays;

public enum Rank {
    FIFTH(5, 3, false, "3개 일치 (5,000원) - ", 5000),
    FOURTH(4, 4, false, "4개 일치 (50,000원) - ", 50000),
    THIRD(3, 5, false, "5개 일치 (1,500,000원) - ", 1500000),
    SECOND(2, 5, true, "5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000),
    FIRST(1, 6, false, "6개 일치 (2,000,000,000원) - ", 2000000000);

    private final int rank;
    private final int matchCount;
    private final boolean bonusMatchRequired;
    private final String description;
    private final int prize;

    Rank(int rank, int matchCount, boolean bonusMatchRequired, String description, int prize) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.bonusMatchRequired = bonusMatchRequired;
        this.description = description;
        this.prize = prize;
    }

    // 당첨 조건에 맞는 Rank 반환 메서드
    public static Rank getRank(int count, boolean bonusMatch) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == count && rank.bonusMatchRequired == bonusMatch)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 조건에 맞는 Rank가 없습니다"));
    }

    // Getters (필요시 추가)
    public int getRank() {
        return rank;
    }

    public String getDescription() {
        return description;
    }

    public int getPrize() {
        return prize;
    }
}
