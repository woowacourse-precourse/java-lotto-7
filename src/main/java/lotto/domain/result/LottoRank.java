package lotto.domain.result;

import lotto.domain.money.Money;

public enum LottoRank {
    FIRST(6, Money.from(2_000_000_000), "6개 일치"),
    SECOND(5, Money.from(30_000_000), "5개 일치, 보너스 볼 일치"),
    THIRD(5, Money.from(1_500_000), "5개 일치"),
    FOURTH(4, Money.from(50_000), "4개 일치"),
    FIFTH(3, Money.from(5_000), "3개 일치"),
    NONE(0, Money.from(0), "미당첨");

    private final int matchCount;
    private final Money prizeMoney;
    private final String description;

    LottoRank(int matchCount, Money prizeMoney, String description) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.description = description;
    }

    public static LottoRank of(int matchCount, boolean hasBonusNumber) {
        if (isSecondRank(matchCount, hasBonusNumber)) {
            return SECOND;
        }
        return findByMatchCount(matchCount);
    }

    private static boolean isSecondRank(int matchCount, boolean hasBonusNumber) {
        return matchCount == 5 && hasBonusNumber;
    }

    private static LottoRank findByMatchCount(int matchCount) {
        for (LottoRank rank : values()) {
            if (rank.matchCount == matchCount && rank != SECOND) {
                return rank;
            }
        }
        return NONE;
    }

    public Money getPrizeMoney() {
        return prizeMoney;
    }

    @Override
    public String toString() {
        if (this == NONE) {
            return description;
        }
        return String.format("%s (%s)", description, prizeMoney);
    }
}