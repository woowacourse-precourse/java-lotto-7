package lotto.service.domain.lotto;

import lotto.service.domain.lottoresult.LottoWinNumber;

public enum LottoReward {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FORTH(4, 50_000),
    FIFTH(3, 5_000),
    FAIL(0, 0);

    private final int requiredMatch;
    private final int prize;
    private final Boolean requiredBonusMatch;

    LottoReward(int requiredMatch, int prize) {
        this.requiredMatch = requiredMatch;
        this.prize = prize;
        this.requiredBonusMatch = null;
    }

    LottoReward(int requiredMatch, int prize, Boolean requiredBonusMatch) {
        this.requiredMatch = requiredMatch;
        this.prize = prize;
        this.requiredBonusMatch = requiredBonusMatch;
    }

    public Boolean getRequiredBonusMatch() {
        return requiredBonusMatch;
    }

    public int getRequiredMatch() {
        return requiredMatch;
    }

    public int getPrize() {
        return prize;
    }
}
