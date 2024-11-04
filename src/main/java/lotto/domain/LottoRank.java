package lotto.constant;

import java.util.Arrays;

public enum LottoRank {
    FIFTH(5_000, 3, "3개 일치 (5,000원)"),
    FORTH(50_000, 4,"4개 일치 (50,000원)"),
    THIRD(1_500_000, 5, "5개 일치 (1,500,000원)"),
    SECOND(30_000_000, 5, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(2_000_000_000, 6, "6개 일치 (2,000,000,000원)");

    private static final String HYPHEN = " - ";
    private static final String LOTTO_UNIT = "개";

    private final int prize;
    private final int matchCount;
    private final String winningMessage;
    private int numberOfWins;

    LottoRank(int prize, int matchCount, String winningMessage) {
        this.prize = prize;
        this.matchCount = matchCount;
        this.winningMessage = winningMessage;
        this.numberOfWins = 0;
    }

    public static void checkLottoPrize(int matchCount, boolean matchBonusNumber) {
        if (matchCount == FIRST.matchCount) {
            FIRST.numberOfWins++;
        } else if (matchCount == SECOND.matchCount && matchBonusNumber) {
            SECOND.numberOfWins++;
        } else if (matchCount == THIRD.matchCount && !matchBonusNumber) {
            THIRD.numberOfWins++;
        } else if (matchCount == FORTH.matchCount) {
            FORTH.numberOfWins++;
        } else if (matchCount == FIFTH.matchCount) {
            FIFTH.numberOfWins++;
        }
    }

    public static int getTotalPrize() {
        return Arrays.stream(LottoRank.values())
                .mapToInt(lotto -> lotto.numberOfWins * lotto.prize)
                .sum();
    }

    @Override
    public String toString() {
        return this.winningMessage + HYPHEN + numberOfWins + LOTTO_UNIT;
    }
}
