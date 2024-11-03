package domain.prize;

import domain.lotto.Lotto;
import domain.lotto.WinningLotto;

import java.util.List;

public class PrizeCalculator {
    private final PrizeResult prizeResult = new PrizeResult();

    public PrizeResult calculate(List<Lotto> userLottos, WinningLotto winningLotto) {
        for (Lotto lotto : userLottos) {
            int matchingCount = lotto.countMatchingNumbers(winningLotto);
            boolean bonusMatch = lotto.containsBonusNumber(winningLotto);
            Prize prize = Prize.determinePrize(matchingCount, bonusMatch);
            prizeResult.addPrize(prize);
        }
        return prizeResult;
    }

    public PrizeResult getPrizeResult() {
        return prizeResult;
    }
}
