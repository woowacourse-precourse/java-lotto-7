package lotto.domain;

import java.util.Arrays;

public enum LottoRankType {

    NONE(0, false, 0),
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);

    private final int matchCount;
    private final boolean hasBonusNumber;
    private final int price;

    LottoRankType(int matchCount, boolean hasBonusNumber, int price) {
        this.matchCount = matchCount;
        this.hasBonusNumber = hasBonusNumber;
        this.price = price;
    }

    public static LottoRankType of(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount && rank.hasBonusNumber == matchBonus)
                .findFirst()
                .orElse(NONE);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isHasBonusNumber() {
        return hasBonusNumber;
    }

    public int getPrice() {
        return price;
    }

}