package lotto;

public enum LottoRank {
    FIRST(6L, 2_000_000_000),
    SECOND(5L, 30_000_000),
    THIRD(5L, 1_500_000),
    FOURTH(4L, 50_000),
    FIFTH(3L, 5_000);

    private final Long matchCount;
    private final int reward;

    LottoRank(Long matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }
}
