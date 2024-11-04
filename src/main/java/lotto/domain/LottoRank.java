package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    FIFTH(3, 5_000, "3개 일치"),
    FOURTH(4, 50_000, "4개 일치"),
    THIRD(5, 1_500_000, "5개 일치"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치"),
    FIRST(6, 2_000_000_000, "6개 일치"),
    NONE(0, 0, "꽝");

    private final Integer matchCount;
    private final Integer prizeMoney;
    private final String description;

    LottoRank(Integer matchCount, Integer prizeMoney, String description) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.description = description;
    }

    public static LottoRank getLottoRank(Integer matchCount, boolean hasBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount.equals(matchCount))
                .filter(rank -> matchCount != 5 || (rank == SECOND) == hasBonus)
                .findFirst()
                .orElse(NONE);
    }

    public Integer getPrizeMoney() {
        return prizeMoney;
    }

    public String getDescription() {
        return description;
    }
}
