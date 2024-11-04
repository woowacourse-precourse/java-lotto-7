package lotto.service;

import lotto.domain.Amount;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import lotto.domain.LottoNumber;
import lotto.domain.LottoRank;
import lotto.domain.LottoWinningRule;
import lotto.domain.LottoWinningStatistics;
import lotto.domain.WinningNumber;

public class LottoDraw {

    private final LottoWinningStatistics statistics;

    public LottoDraw(LottoWinningStatistics statistics) {
        this.statistics = statistics;
    }

    public int compareWinningNumber(Lotto lotto, WinningNumber winningNumber) {
        int cnt = 0;
        for (LottoNumber number : lotto.getNumbers()) {
            if (winningNumber.getNumbers().contains(number)) {
                cnt++;
            }
        }
        return cnt;
    }

    public boolean compareBonusNumber(Lotto lotto, BonusNumber bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public void draw(LottoBundle lottoBundle, WinningNumber winningNumber, BonusNumber bonusNumber) {
        for (Lotto lotto : lottoBundle.getBundle()) {
            int matchesWinning = compareWinningNumber(lotto, winningNumber);
            boolean isMatchBonus = compareBonusNumber(lotto, bonusNumber);
            statistics.update(LottoWinningRule.getRank(matchesWinning, isMatchBonus));
        }
    }

    public long calcTotalPrize() {
        long totalPrize = 0L;
        for (LottoRank key : LottoRank.values()) {
            totalPrize += LottoWinningRule.getPrize(key) * statistics.search(key);
        }
        return totalPrize;
    }

    public double calcReturnRate(long totalPrize, Amount amount) {
        return (double) totalPrize / amount.getValue();
    }
}
