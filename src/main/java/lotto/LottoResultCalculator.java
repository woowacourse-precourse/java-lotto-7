package lotto;

import java.util.List;

public class LottoResultCalculator {
    public WinningResult calculateResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        WinningResult result = new WinningResult();
        for (Lotto lotto : lottos) {
            result.addResult(lotto.match(winningNumbers, bonusNumber));
        }
        return result;
    }

    public double calculateReturnRate(WinningResult result, int purchaseAmount) {
        long totalPrize = result.calculateTotalPrize();
        return (totalPrize * 100.0) / purchaseAmount;
    }
}
