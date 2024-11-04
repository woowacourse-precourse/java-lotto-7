package lotto;

import java.util.Arrays;
import java.util.Optional;

public enum WinningPrize {
    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false);

    private final int matchCount;         // 일치해야 하는 번호 개수
    private final int prize;               // 상금
    private final boolean requiresBonus;   // 보너스 번호 일치 여부

    WinningPrize(int matchCount, int prize, boolean requiresBonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.requiresBonus = requiresBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public boolean requiresBonus() {
        return requiresBonus;
    }

    public static Optional<WinningPrize> determineWinningPrize(int matchCount, boolean bonusNumberMatch) {
        return Arrays.stream(WinningPrize.values())
                .filter(winningPrize -> winningPrize.matchCount == matchCount
                        && (!winningPrize.requiresBonus() || bonusNumberMatch))
                .findFirst();
    }
}
