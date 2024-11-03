package lotto.constant;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public enum Rank {
    FIRST(6, null, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, null, 50_000),
    FIFTH(3, null, 5_000),
    NONE(0, null, 0),
    ;

    private int matchCount;
    private Boolean matchBonus;
    private long price;

    Rank(int matchCount, Boolean matchBonus, long price) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.price = price;
    }

    public static Rank of(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
            .filter(rank -> rank.matchCount == matchCount &&
                (rank.matchBonus == null || rank.matchBonus == matchBonus))
            .findAny()
            .orElse(NONE);
    }

    public static List<Rank> values(Comparator<Rank> comparator) {
        List<Rank> ranks = Arrays.asList(values());
        if (comparator != null) {
            ranks.sort(comparator);
        }
        return ranks;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrice() {
        return price;
    }

    public int getRank() {
        return this.ordinal() + 1;
    }
}
