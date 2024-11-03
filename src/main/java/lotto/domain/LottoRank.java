package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIFTH(3, 5_000, "3개 일치"),
    FOURTH(4, 50_000, "4개 일치"),
    THIRD(5, 1_500_000, "5개 일치"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치"),
    FIRST(6, 2_000_000_000, "6개 일치"),
    NONE(0, 0, "꽝");

    private final int matchCount;
    private final int amount;
    private final String description;

    LottoRank(int matchCount, int amount, String description) {
        this.matchCount = matchCount;
        this.amount = amount;
        this.description = description;
    }

    public static LottoRank valueOf(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .filter(rank -> matchCount != 5 || (rank == SECOND) == matchBonus)
                .findFirst()
                .orElse(NONE);
    }

    public int getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}
