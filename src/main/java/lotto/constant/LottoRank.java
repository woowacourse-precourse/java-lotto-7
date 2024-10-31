package lotto.constant;

import java.util.Arrays;

public enum LottoRank {
    FIRST(2_000_000_000, "6개 일치 (2,000,000,000원)"),
    SECOND(30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD(1_500_000, "5개 일치 (1,500,000원)"),
    FORTH(50_000, "4개 일치 (50,000원)"),
    FIFTH(5_000, "3개 일치 (5,000원)");

    private final int prize;
    private final String winningMessage;
    private int numberOfWins;

    LottoRank(int prize, String winningMessage) {
        this.prize = prize;
        this.winningMessage = winningMessage;
        this.numberOfWins = 0;
    }

    public int getPrize() {
        return prize;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public void win() {
        this.numberOfWins++;
    }

    public static int getTotalPrize() {
        return Arrays.stream(LottoRank.values())
                .mapToInt(lotto -> lotto.getNumberOfWins() * lotto.getPrize())
                .sum();
    }

    @Override
    public String toString() {
        return this.winningMessage + " - " + getNumberOfWins() + "개";
    }
}
