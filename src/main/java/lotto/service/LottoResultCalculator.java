package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class LottoResultCalculator {
    public static WinningStatistics calculate(List<Lotto> purchasedLottos, Lotto winningLotto, int bonusNumber) {
        WinningStatistics statistics = new WinningStatistics();
        for (Lotto lotto : purchasedLottos) {
            Rank rank = getRank(lotto, winningLotto, bonusNumber);
            statistics.addRank(rank);
        }
        return statistics;
    }

    static Rank getRank(Lotto lotto, Lotto winningLotto, int bonusNumber) {
        int matchCount = countMatchingNumbers(lotto, winningLotto);
        boolean bonusMatch = lotto.contains(bonusNumber);
        return Rank.valueOf(matchCount, bonusMatch);
    }

    public static int countMatchingNumbers(Lotto lotto, Lotto winningLotto) {
        int count = 0;
        for (int number : lotto.getNumbers()) {
            if (winningLotto.contains(number)) {
                count++;
            }
        }
        return count;
    }
}

