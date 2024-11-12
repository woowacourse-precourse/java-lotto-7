package lotto.model;

import java.util.Arrays;

public enum LottoRank {
    MISS(0, 0, "낙첨"),
    FIVE(3, 5000, "3개 일치 (5,000원)"),
    FOUR(4, 50000, "4개 일치 (50,000원)"),
    THIRD(5, 1500000, "5개 일치 (1,500,000원)"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원)");

    private final int matchCount;
    private final int price;
    private final String message;

    LottoRank(int matchCount, int price, String message) {
        this.matchCount = matchCount;
        this.price = price;
        this.message = message;
    }

    public int getPrice() {
        return price;
    }

    public int getMatchCount() {
        return matchCount;
    }

    @Override
    public String toString() {
        return message;
    }

    public static LottoRank getRank(int matchCount, boolean isBonusMatched) {
        if (matchCount == SECOND.matchCount && isBonusMatched) {
            return SECOND;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(MISS);
    }
}