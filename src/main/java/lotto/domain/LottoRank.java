package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    LOSE(0, 0, ""),
    THREE_MATCH(3, 5000, "3개 일치 (5,000원)"),
    FOUR_MATCH(4, 50000, "4개 일치 (50,000원)"),
    FIVE_MATCH(5, 1500000, "5개 일치 (1,500,000원)"),
    FIVE_MATCH_BONUS(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX_MATCH(6, 2000000000, "6개 일치 (2,000,000,000원)");

    private final int matchCount;
    private final int prize;
    private final String description;

    LottoRank(int matchCount, int prize, String description) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.description = description;
    }

    public static LottoRank of(int matchCount, boolean hasBonus) {
        if (matchCount == 5) {
            return getFiveMatchRank(hasBonus);
        }
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(LOSE);
    }

    private static LottoRank getFiveMatchRank(boolean hasBonus) {
        if (hasBonus) {
            return FIVE_MATCH_BONUS;
        }
        return FIVE_MATCH;
    }

    public int getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }
}