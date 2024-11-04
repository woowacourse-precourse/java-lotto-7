package lotto.service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.model.BonusNumber;
import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.model.WinningResult;

public class LottoEvaluator {
    public Map<WinningResult, Integer> evaluateWinningResult(Lottos lottos, WinningNumbers winningNumbers,
                                                             BonusNumber bonusNumber) {
        Map<WinningResult, Integer> winningResults = new EnumMap<>(WinningResult.class);
        List<LottoResult> results = lottos.getTotalMatchedLottoResult(winningNumbers, bonusNumber);

        for (LottoResult lottoResult : results) {
            int count = lottoResult.getMatchedNumberCount();
            boolean hasBonusNumber = lottoResult.hasBonusNumber();
            WinningResult winningResult = WinningResult.fromMatchedNumberCount(count, hasBonusNumber);
            winningResults.put(winningResult, winningResults.getOrDefault(winningResult, 0) + 1);
        }

        return winningResults;
    }
}
