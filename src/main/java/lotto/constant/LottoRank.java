package lotto.constant;

import java.util.Arrays;

public enum LottoRank {
    FIRST(2_000_000_000, 6, "6개 일치 (2,000,000,000원)"),
    SECOND(30_000_000, 5, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(1_500_000, 5, "5개 일치 (1,500,000원)"),
    FORTH(50_000, 4,"4개 일치 (50,000원)"),
    FIFTH(5_000, 3, "3개 일치 (5,000원)");

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
        if (matchCount == FIRST.getMatchCount()) {
            FIRST.win();
        } else if (matchCount == SECOND.getMatchCount() && matchBonusNumber) {
            SECOND.win();
        } else if (matchCount == THIRD.getMatchCount() && !matchBonusNumber) {
            THIRD.win();
        } else if (matchCount == FORTH.getMatchCount()) {
            FORTH.win();
        } else if (matchCount == FIFTH.getMatchCount()) {
            FIFTH.win();
        }
    }

    private void win() {
        this.numberOfWins++;
    }

    public static int getTotalPrize() {
        return Arrays.stream(LottoRank.values())
                .mapToInt(lotto -> lotto.getNumberOfWins() * lotto.getPrize())
                .sum();
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    @Override
    public String toString() {
        return this.winningMessage + " - " + getNumberOfWins() + "개";
    }
}
