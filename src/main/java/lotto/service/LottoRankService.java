package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.util.LottoConstant;

public class LottoRankService {
    public int[] countRank(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        int[] countRank = new int[LottoConstant.THE_NUMBER_OF_LOTTO_NUMBER];

        for (Lotto lotto : lottos) {
            countRank[lotto.checkRank(lotto.countWinningNumbers(winningNumbers), bonusNumber)]++;
        }

        return countRank;
    }
}
