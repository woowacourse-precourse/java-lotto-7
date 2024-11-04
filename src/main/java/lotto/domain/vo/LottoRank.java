package lotto.domain.vo;

import java.util.Arrays;

public enum LottoRank {
    FIFTH(3, false, 5_000L, (matchingCount, bonusMatch) -> matchingCount == 3),
    FOURTH(4, false, 50_000L, (matchingCount, bonusMatch) -> matchingCount == 4),
    THIRD(5, false, 1_500_000L, (matchingCount, bonusMatch) -> matchingCount == 5 && !bonusMatch),
    SECOND(5, true, 30_000_000L, (matchingCount, bonusMatch) -> matchingCount == 5 && bonusMatch),
    FIRST(6, false, 2_000_000_000L, (matchingCount, bonusMatch) -> matchingCount == 6),
    NONE(0, false, 0L, (matchingCount, bonusMatch) -> matchingCount < 3);

    private final int matchingCount;
    private final boolean bonusMatch;
    private final Long prize;
    private final WinningCondition winningCondition;

    LottoRank(int matchingCount, boolean bonusMatch, Long prize, WinningCondition winningCondition) {
        this.matchingCount = matchingCount;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
        this.winningCondition = winningCondition;
    }

    public static LottoRank of(Integer matchingCount, Boolean bonusNumberMatch) {
        return Arrays.stream(values())
                .filter(rank -> rank.matches(matchingCount, bonusNumberMatch))
                .findFirst()
                .orElse(NONE);
    }

    private boolean matches(Integer matchingCount, Boolean bonusNumberMatch) {
        return winningCondition.isWinningCondition(matchingCount, bonusNumberMatch);
    }

    public Long getPrize() {
        return prize;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }
}
