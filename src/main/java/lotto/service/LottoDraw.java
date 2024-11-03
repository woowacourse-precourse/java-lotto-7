package lotto.service;

import java.util.HashMap;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import lotto.domain.LottoNumber;
import lotto.domain.LottoRank;
import lotto.domain.LottoWinningRule;
import lotto.domain.WinningNumber;

public class LottoDraw {

    private final HashMap<LottoRank, Integer> statistics = new HashMap<>();

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

    private void saveDrawResult(LottoRank key) {
        int value = statistics.getOrDefault(key, 0) + 1;
        statistics.put(key, value);
    }

    public void draw(LottoBundle lottoBundle, WinningNumber winningNumber, BonusNumber bonusNumber) {
        for (Lotto lotto : lottoBundle.getBundle()) {
            int matchesWinning = compareWinningNumber(lotto, winningNumber);
            boolean isMatchBonus = compareBonusNumber(lotto, bonusNumber);
            LottoRank rank = LottoWinningRule.getRank(matchesWinning, isMatchBonus);
            saveDrawResult(rank);
        }
    }
}
