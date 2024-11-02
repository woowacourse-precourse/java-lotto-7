package lotto.model;

import java.util.Arrays;

public enum Rank {
    LAST(0, 0, false),
    _5TH(5_000, 3, false),
    _4TH(50_000, 4, false),
    _3TH(1_500_000, 5, false),
    _2TH(30_000_000, 5, true),
    _1TH(2_000_000_000, 6, false),
    ;

    private final int price;
    private final int matchCount;
    private final boolean containsBonus;

    Rank(int price, int matchCount, boolean containsBonus) {
        this.price = price;
        this.matchCount = matchCount;
        this.containsBonus = containsBonus;
    }

    public static Rank of(int matchCount, boolean containsBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .filter(rank -> rank.containsBonus == containsBonus)
                .findFirst()
                .orElse(LAST);
    }
}
