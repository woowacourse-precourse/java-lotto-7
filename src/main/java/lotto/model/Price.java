package lotto.model;

import java.util.List;

public enum Price {
    FIRST(1, 6, 2_000_000_000L),
    SECOND(2, 5, 30_000_000L),
    THIRD(3, 5, 1_500_000L),
    FORTH(4, 4, 50_000L),
    FIFTH(5, 3, 5_000L),
    NONE(6, 0, 0L);

    public final int place;
    public final int matchCount;
    public final Long money;

    Price(int place, int matchCount, Long money) {
        this.place = place;
        this.matchCount = matchCount;
        this.money = money;
    }

    public void print(int count) {
        if (this == SECOND) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n", matchCount, money, count);
        }
        System.out.printf("%d개 일치 (%,d원) - %d개\n", matchCount, money, count);
    }

    public static List<Price> getValues() {
        return List.of(FIFTH, FORTH, THIRD, SECOND, FIRST);
    }

    public Long getProfit(int count) {
        return money * count;
    }
}
