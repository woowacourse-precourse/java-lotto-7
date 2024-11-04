package lotto.global.common;

import java.util.Arrays;

public enum Rank {

    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000) {

        @Override
        public String toString() {
            return String.format("%d개 일치, 보너스 볼 일치 (%,d원)", matchCount, price);
        }
    },
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    public final Integer matchCount;
    public final Boolean matchBonus;
    public final int price;

    Rank(Integer matchCount, Boolean matchBonus, int price) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.price = price;
    }

    public static Rank valueOf(int matchCount, boolean matchBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .filter(rank -> !rank.matchBonus || matchBonus)
                .findFirst()
                .orElse(NONE);
    }


    @Override
    public String toString() {
        return String.format("%d개 일치 (%,d원)", matchCount, price);
    }
}
