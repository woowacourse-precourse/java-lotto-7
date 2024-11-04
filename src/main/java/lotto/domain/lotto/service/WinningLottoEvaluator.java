package lotto.domain.lotto.service;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningNumber;
import lotto.domain.lotto.vo.LottoPrize;

public class WinningLottoEvaluator {

    public LottoPrize evaluate(WinningNumber winningNumber, Lotto lotto) {
        int matchingNumbers = winningNumber.getMatchingNumbersCount(lotto);
        boolean isBonusMatched = winningNumber.isBonusNumberMatched(lotto);

        return LottoPrize.of(matchingNumbers, isBonusMatched);
    }

}
