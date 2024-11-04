package lotto;

import java.util.Arrays;

public enum Price {

    SIXTH(0L, 0),
    FIFTH(5000L, 3),
    FOURTH(50000L, 4),
    THIRD(1500000L, 5),
    SECOND(30000000L, 5),
    FIRST(2000000000L, 6);

    private final long priceMoney;
    private final int matching;

    Price(long priceMoney, int matching) {
        this.priceMoney = priceMoney;
        this.matching = matching;
    }

    public static Price getPrice(long matchingCount) {
        return Arrays.stream(values())
                .filter(it -> it.matching == matchingCount)
                .findFirst()
                .orElse(Price.SIXTH);
    }

    public int getMatching() {
        return matching;
    }

    public long getPriceMoney() {
        return priceMoney;
    }
}
