package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;

import java.util.List;

public class LottoResultCalculator {
    public static int[] calculateResults(List<Lotto> userLottos, List<Integer> winningNumbers, int bonusNumber) {
        int[] matchCounts = new int[LottoRank.values().length];

        for (Lotto lotto : userLottos) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

            LottoRank rank = LottoRank.valueOf(matchCount, bonusMatch);
            matchCounts[rank.ordinal()]++;
        }

        return matchCounts;
    }
}