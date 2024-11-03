package domain.prize;

import domain.lotto.Lotto;
import domain.lotto.WinningLotto;

import java.util.List;

public class PrizeCalculator {

    public PrizeResult calculate(List<Lotto> userLottos, WinningLotto winningLotto) {
        PrizeResult prizeResult = new PrizeResult();
        for (Lotto lotto : userLottos) {
            int matchingCount = lotto.countMatchingNumbers(winningLotto);
            boolean bonusMatch = lotto.containsBonusNumber(winningLotto.getBonusNumber());
            Prize prize = Prize.determinePrize(matchingCount, bonusMatch);
            prizeResult.addPrize(prize);
        }
        return prizeResult;
    }
}