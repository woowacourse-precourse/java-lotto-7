package lotto.model.lottowinningstrategy;

import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.WinningNumbers;

public class LottoWinningStrategy implements WinningStrategy {

    @Override
    public LottoRank calculateRank(Lotto lotto, WinningNumbers winningNumbers) {
        int matchLotto = winningNumbers.countMatchingNumbers(lotto);
        boolean matchBonus = winningNumbers.isMatchBonusNumber(lotto);

        return LottoRank.matchRank(matchLotto, matchBonus);
    }
}
