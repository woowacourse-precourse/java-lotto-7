package lotto.domain.service;

import lotto.domain.model.Lotto;
import lotto.domain.model.PrizeCategory;
import lotto.domain.model.WinningNumbers;

public class LottoPrizeService {
    public PrizeCategory calculatePrize(Lotto lotto, WinningNumbers winningNumbers) {
        int matchCount = winningNumbers.countMatchingNumbers(lotto);
        boolean matchBonus = winningNumbers.isBonusMatch(lotto);
        return PrizeCategory.getCategory(matchCount, matchBonus);
    }
}
