package lotto;

import java.util.Arrays;
import java.util.Optional;

public enum WinningPrize {
    FIRST(6, 2000000000, false),
    SECOND(5, 300000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false);

    int matchCount;
    int prize;
    boolean bonusNumberMatch;

    WinningPrize(int MatchCount, int prize, boolean bonusNumberMatch) {
        this.matchCount = MatchCount;
        this.prize = prize;
        this.bonusNumberMatch = bonusNumberMatch;
    }

    public static Optional<WinningPrize> determineWinningPrize(int matchCount, boolean bonusNumberMatch) {
        return Arrays.stream(WinningPrize.values()).
                filter(winningPrize -> winningPrize.matchCount == matchCount && winningPrize.bonusNumberMatch == bonusNumberMatch).
                findFirst();
    }
}