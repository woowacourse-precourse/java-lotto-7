package lotto.domain;

public enum LottoRank {
    FIRST(6, 2000000000, false),
    SECOND_BONUS(5, 30000000, true),
    SECOND(5, 1500000, false),
    THIRD(4, 50000, false),
    FOURTH(3, 5000, false);

    private final int matchCount;
    private final int price;
    private final boolean bonus;

    LottoRank(int matchCount, int price, boolean bonus) {
        this.matchCount = matchCount;
        this.price = price;
        this.bonus = bonus;
    }
}
