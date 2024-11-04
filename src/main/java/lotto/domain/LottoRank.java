package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum LottoRank {
    FIRST(6,
            false,
            2_000_000_000,
            (winningCount, bonusNumberMatched) -> winningCount.equals(6) && bonusNumberMatched.equals(false)),

    SECOND(5,
            true,
            30_000_000,
            (winningCount, bonusNumberMatched) -> winningCount.equals(5) && bonusNumberMatched.equals(true)),
    THIRD(5,
            false,
            1_500_000,
            (winningCount, bonusNumberMatched) -> winningCount.equals(5) && bonusNumberMatched.equals(false)),
    FIRTH(4,
            false,
            50_000,
            (winningCount, bonusNumberMatched) -> winningCount.equals(4) && bonusNumberMatched.equals(false)),
    FIFTH(3,
            false,
            5_000,
            (winningCount, bonusNumberMatched) -> winningCount.equals(3) && bonusNumberMatched.equals(false)),
    NONE(0,
            false,
            0,
            (winningCount, bonusNumberMatched) -> winningCount < 3);

    private final int winningCount;
    private final boolean bonusNumberMatched;
    private final long price;
    private final BiPredicate<Integer, Boolean> standard;

    LottoRank(int winningCount, boolean bonusNumberMatched, long price, BiPredicate<Integer, Boolean> standard) {
        this.winningCount = winningCount;
        this.bonusNumberMatched = bonusNumberMatched;
        this.price = price;
        this.standard = standard;
    }

    public static LottoRank findLottoRank(final int winningCount, final boolean bonusNumberMatched) {
        return Arrays.stream(LottoRank.values())
                .filter(winning -> winning.standard.test(winningCount, bonusNumberMatched))
                .findFirst()
                .orElse(NONE);
    }
}