package lotto.model;

import java.util.Arrays;

public enum Score {

    ZERO(0, 0),
    THREE(3, 5_000),
    FOURTH(4, 50_000),
    FIFTH(5, 1_500_000),
    FIFTH_WITH_BONUS(5, 30000_000),
    SIX(6, 2_000_000_000);

    private final int matchCount;
    private final int prize;

    Score(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Score calculateScore(Lotto lotto, WinningLotto winningLotto) {
        int matchCount = winningLotto.getMatchCount(lotto);
        boolean isBonusNumberMatches = winningLotto.isBonusNumberMatches(lotto);

        return Arrays.stream(values()).filter(score -> score.matchCount == matchCount)
                .filter(score -> !isBonusNumberMatches || score != FIFTH)
                .findFirst()
                .orElseGet(() -> ZERO);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }
}
