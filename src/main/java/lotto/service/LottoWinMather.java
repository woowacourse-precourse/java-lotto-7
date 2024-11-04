package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PurchasedLottos;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;

public class LottoWinMather {

    public LottoResult calculateLottoWins(PurchasedLottos purchasedLotto, WinningLotto winningLotto) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : purchasedLotto.lottos()) {
            boolean bonus = false;
            List<Integer> lottoNums = lotto.numbers();

            long count = sameNumberCountOf(winningLotto, lottoNums);
            if (lottoNums.contains(winningLotto.bonusNumber())) {
                bonus = true;
            }
            ranks.add(calculateRank(count, bonus));
        }
        return LottoResult.from(ranks);
    }

    private long sameNumberCountOf(WinningLotto winningLotto, List<Integer> lottoNums) {
        return winningLotto.numbers()
                .stream()
                .filter(lottoNums::contains)
                .count();
    }

    private Rank calculateRank(long count, boolean bonus) {
        return Rank.calculateRank(count, bonus);
    }
}
