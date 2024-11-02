package lotto;

import java.text.NumberFormat;
import java.util.stream.Stream;

public enum Rank {
    FIRST(6, false, 2_000_000_000L),
    SECOND(5, true, 30_000_000L),
    THIRD(5, false, 1_500_000L),
    FOURTH(4, false, 50_000L),
    FIFTH(3, false, 5_000L),
    NONE(-1, false, 0L)
    ;

    private final int count;
    private final boolean hasBonus;
    private final long price;

    Rank(int count, boolean hasBonus, long price) {
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

    public long price() {
        return this.price;
    }

    public static Rank findRank(int matchedCount, boolean hasBonus) {
        return Stream.of(values())
                .filter(rank -> rank.count() == matchedCount && rank.hasBonus() == hasBonus)
                .findFirst()
                .orElse(NONE);
    }

    public String getFormattedPrice() {
        return NumberFormat.getInstance().format(this.price);
    }
}
