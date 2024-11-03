package lotto.model;

public enum Price {
    FIRST(1, 2_000_000_000L),
    SECOND(2, 30_000_000L),
    THIRD(3, 1_500_000L),
    FORTH(4, 50_000L),
    FIFTH(5, 5_000L),
    NONE(0, 0L);

    final int place;
    final Long money;

    Price(int place, Long money) {
        this.place = place;
        this.money = money;
    }
}
