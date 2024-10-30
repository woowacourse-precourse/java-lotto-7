package lotto.domain;

public enum LottoRank {
    FIRST(6, 2_000_000_000, "6개 일치"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, 1_500_000, "5개 일치"),
    FOURTH(4, 50_000, "4개 일치"),
    FIFTH(3, 5_000, "3개 일치"),
    NONE(0, 0, "꽝");

    private final int matchcnt;
    private final int amount;
    private final String description;

    LottoRank(int matchcnt, int amount, String description) {
        this.matchcnt = matchcnt;
        this.amount = amount;
        this.description = description;
    }
}
