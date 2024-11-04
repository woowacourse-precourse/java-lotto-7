package lotto.model;

import java.util.Arrays;

public enum Rank {
    LAST(0, 0, 0, false),
    _5TH(5, 5_000, 3, false),
    _4TH(4, 50_000, 4, false),
    _3TH(3, 1_500_000, 5, false),
    _2TH(2, 30_000_000, 5, true),
    _1TH(1, 2_000_000_000, 6, false),
    ;

    private final int rank;
    private final long price;
    private final long matchCount;
    private final boolean containsBonus;

    Rank(int rank, long price, long matchCount, boolean containsBonus) {
        this.rank = rank;
        this.price = price;
        this.matchCount = matchCount;
        this.containsBonus = containsBonus;
    }

    public int getRank() {
        return rank;
    }

    public long getPrice() {
        return price;
    }

    public long getMatchCount() {
        return matchCount;
    }

    public boolean isContainsBonus() {
        return containsBonus;
    }

    public static Rank of(long matchCount, boolean containsBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .filter(rank -> rank.matchCount != 5 || rank.containsBonus == containsBonus)
                .findFirst()
                .orElse(LAST);
    }
}
