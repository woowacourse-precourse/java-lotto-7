package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.WinningResult;

public class Player {

    private final int purchaseAmount;
    private final List<Lotto> lottoes;

    public Player(int purchaseAmount, List<Lotto> lottoes) {
        this.purchaseAmount = purchaseAmount;
        this.lottoes = lottoes;
    }

    public double calculatePrizeRatio(long prizeAmount) {
        return (double) prizeAmount / purchaseAmount * 100;
    }

    public List<WinningResult> checkResults(WinningLotto winningLotto) {
        List<WinningResult> results = new ArrayList<>();

        for (Lotto lotto : lottoes) {
            WinningResult winningResult = winningLotto.checkResult(lotto);
            results.add(winningResult);
        }

        return results;
    }
}
