package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, false, 2000000000L, "6개 일치 (2,000,000,000원)"),
    SECOND(5, true, 30000000L, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(5, false, 1500000L, "5개 일치 (1,500,000원)"),
    FOURTH(4, false, 50000L, "4개 일치 (50,000원)"),
    FIFTH(3, false, 5000L, "3개 일치 (5,000원)"),
    EMPTY(0, false, 0L, "낙첨");

    private final int matchedNumberCount;
    private final boolean matchedBonusNumber;
    private final Long price;
    private final String description;

    Rank(int matchedNumberCount, boolean matchedBonusNumber, Long price, String description) {
        this.matchedNumberCount = matchedNumberCount;
        this.matchedBonusNumber = matchedBonusNumber;
        this.price = price;
        this.description = description;
    }

    public static Rank getRank(int matchedNumberCount, boolean isBonusMatched) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.getMatchedNumberCount() == matchedNumberCount &&
                        rank.isMatchedBonusNumber() == isBonusMatched)
                .findAny()
                .orElse(EMPTY);
    }

    public int getMatchedNumberCount() {
        return matchedNumberCount;
    }

    public boolean isMatchedBonusNumber() {
        return matchedBonusNumber;
    }

    public Long getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
