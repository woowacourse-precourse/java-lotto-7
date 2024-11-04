package lotto.model.lottowinningstrategy;

import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.WinningNumbers;

public class LottoWinningStrategy implements WinningStrategy {

    @Override
    public LottoRank calculateRank(Lotto lotto, WinningNumbers winningNumbers) {
        int numberMatchCount = winningNumbers.countMatchingNumbers(lotto);
        boolean bonusNumberMatch = winningNumbers.isMatchBonusNumber(lotto);

        return LottoRank.matchRank(numberMatchCount, bonusNumberMatch);
    }
}
