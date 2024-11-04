package lotto;

import java.util.List;

public class Player {

    private final int purchaseAmount;
    private final List<Lotto> lottoes;

    public Player(int purchaseAmount, List<Lotto> lottoes) {
        this.purchaseAmount = purchaseAmount;
        this.lottoes = lottoes;
    }

    public double calculatePrizeRatio(long prizeAmount) {
        return Math.round((double) prizeAmount / purchaseAmount * 1000) / 10.0;
    }
}
