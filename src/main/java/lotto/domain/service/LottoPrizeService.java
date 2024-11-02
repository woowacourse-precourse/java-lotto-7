package lotto.domain.service;

import lotto.domain.model.Lotto;
import lotto.domain.model.PrizeCategory;
import lotto.domain.model.WinningNumbers;

//로또 당첨 등급 및 수익률을 계산하는 클래스
public class LottoPrizeService {
    public PrizeCategory calculatePrize(Lotto lotto, WinningNumbers winningNumbers) {
        int matchCount = winningNumbers.countMatchingNumbers(lotto);
        boolean matchBonus = winningNumbers.isBonusMatch(lotto);
        return PrizeCategory.getCategory(matchCount, matchBonus);
    }

    public double calculateProfitRate(int totalCost, int totalPrize) {
        return Math.round(((double) totalPrize / totalCost) * 1000) / 10.0;
    }
}
