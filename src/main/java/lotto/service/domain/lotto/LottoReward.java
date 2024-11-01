package lotto.service.domain.lotto;

public enum LottoReward {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FORTH(4, 50_000),
    FIFTH(3, 5_000),
    FAIL(0, 0);

    private final int requiredMatch;
    private final int prize;

    LottoReward(int requiredMatch, int prize) {
        this.requiredMatch = requiredMatch;
        this.prize = prize;
    }
}
