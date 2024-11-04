package lotto.model;

import java.util.List;
import lotto.Rank;

public class LottoDrawMachine {
    private final List<Lotto> lottos;
    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;
    private LottoResult lottoResult;

    public LottoDrawMachine(List<Lotto> lottos, List<Integer> winningNumbers, Integer bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoResult calculateLottoResult() {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : lottos) {
            List<Integer> result = lotto.compareNumbersToWinningNumbers(winningNumbers);
            boolean hasBonusNumber = lotto.hasBonusNumber(bonusNumber);
            Rank rank = Rank.findRank(result.size(), hasBonusNumber);
            lottoResult.addResult(rank);
        }
        return lottoResult;
    }

    public long getPurchaseAmount() {
        return lottos.size() * 1000L;
    }
}
