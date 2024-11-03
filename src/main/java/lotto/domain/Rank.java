package lotto.domain;

import java.util.Arrays;

public enum Rank {
    NONE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000, BonusMatcher.FALSE),
    SECOND(5, 30_000_000, BonusMatcher.TRUE),
    FIRST(6, 2_000_000_000);

    private final int count;
    private final int price;
    private final BonusMatcher matchBonus;

    Rank(int count, int price, BonusMatcher matchBonus) {
        this.count = count;
        this.price = price;
        this.matchBonus = matchBonus;
    }

    Rank(int count, int price) {
        this(count, price, BonusMatcher.NONE);
    }

    public static Rank match(int count, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(v -> v.count == count)
                .filter(v -> v.matchBonus.match(matchBonus))
                .findFirst()
                .orElse(NONE);
    }

    public int count() {
        return count;
    }

    public int price() {
        return price;
    }

    private enum BonusMatcher {
        NONE {
            @Override
            public boolean match(boolean matchBonus) {
                return true;
            }
        },
        FALSE {
            @Override
            public boolean match(boolean matchBonus) {
                return !matchBonus;
            }
        },
        TRUE {
            @Override
            public boolean match(boolean matchBonus) {
                return matchBonus;
            }
        };

        protected abstract boolean match(boolean matchBonus);
    }
}
