package lotto;

import java.util.stream.Stream;

public enum Rank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NONE(-1, false, 0)
    ;

    private final int count;
    private final boolean hasBonus;
    private final int price;

    Rank(int count, boolean hasBonus, int price) {
        this.count = count;
        this.hasBonus = hasBonus;
        this.price = price;
    }

    public int count() {
        return this.count;
    }

    public boolean hasBonus() {
        return this.hasBonus;
    }

    public int price() {
        return this.price;
    }

    public static Rank findRank(int matchedCount, boolean hasBonus) {
        return Stream.of(values())
                .filter(rank -> rank.count() == matchedCount && rank.hasBonus() == hasBonus)
                .findFirst()
                .orElse(NONE);
    }
}
