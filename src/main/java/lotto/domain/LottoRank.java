package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum LottoRank {
    FIRST(6,
            false,
            2_000_000_000,
            (winningCount, bonusNumberMatched) -> winningCount.equals(6) && bonusNumberMatched.equals(false),
            "6개 일치 (2,000,000,000원) - %d개"),

    SECOND(5,
            true,
            30_000_000,
            (winningCount, bonusNumberMatched) -> winningCount.equals(5) && bonusNumberMatched.equals(true),
            "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    THIRD(5,
            false,
            1_500_000,
            (winningCount, bonusNumberMatched) -> winningCount.equals(5) && bonusNumberMatched.equals(false),
            "5개 일치 (1,500,000원) - %d개"),
    FIRTH(4,
            false,
            50_000,
            (winningCount, bonusNumberMatched) -> winningCount.equals(4) && bonusNumberMatched.equals(false),
            "4개 일치 (50,000원) - 0개"),
    FIFTH(3,
            false,
            5_000,
            (winningCount, bonusNumberMatched) -> winningCount.equals(3) && bonusNumberMatched.equals(false),
            "3개 일치 (5,000원) - 1개"),
    NONE(0,
            false,
            0,
            (winningCount, bonusNumberMatched) -> winningCount < 3,
            "");

    private final int winningCount;
    private final boolean bonusNumberMatched;
    private final long price;
    private final BiPredicate<Integer, Boolean> standard;
    private final String printMessages;

    LottoRank(int winningCount, boolean bonusNumberMatched, long price, BiPredicate<Integer, Boolean> standard,
              String printMessages) {
        this.winningCount = winningCount;
        this.bonusNumberMatched = bonusNumberMatched;
        this.price = price;
        this.standard = standard;
        this.printMessages = printMessages;
    }

    public static LottoRank findLottoRank(final int winningCount, final boolean bonusNumberMatched) {
        return Arrays.stream(LottoRank.values())
                .filter(winning -> winning.standard.test(winningCount, bonusNumberMatched))
                .findFirst()
                .orElse(NONE);
    }

    public int getWinningCount() {
        return winningCount;
    }

    public boolean isBonusNumberMatched() {
        return bonusNumberMatched;
    }

    public long getPrice() {
        return price;
    }
}