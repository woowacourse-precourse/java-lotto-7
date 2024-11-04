package lotto.service;

import lotto.model.*;

import java.util.List;

public class Calculator {
    private final Lottos lottos;
    private final WinningNumbers winningNumbers;
    private final LottoResult lottoResult;

    public Calculator(Lottos lottos, WinningNumbers winningNumbers) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        lottoResult = new LottoResult();
    }

    public LottoResult getLottoResult() {
        return lottoResult;
    }

    public void calculateLottoResult() {
        List<Lotto> lottoList = lottos.getLottos();
        for (Lotto lotto : lottoList) {
            int matchingNumbers = winningNumbers.countMatchingNumbers(lotto);
            boolean isBonusNumberMatched = winningNumbers.checkBonusMatch(lotto);
            LottoRank rank = LottoRank.getRankOfEachLotto(matchingNumbers, isBonusNumberMatched);
            lottoResult.update(rank);
        }
    }

    public double calculateRateOfReturn(LottoPurchaseAmount amount) {
        Double totalReturn = LottoRank.getTotalReturn(lottoResult);
        return totalReturn / amount.getAmount() * 100.0;
    }
}
