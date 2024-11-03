package lotto.winningNumber.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.lottery.domain.Lotto;
import lotto.winningNumber.domain.LottoResult;
import lotto.winningNumber.domain.WinningNumber;

public class MatchService {

    public Map<LottoResult, Integer> calculateMatchResults(List<Lotto> lottos, WinningNumber winningNumber) {
        Map<LottoResult, Integer> resultCount = initialize();
        for (Lotto lotto : lottos) {
            determineMatchResult(winningNumber, lotto.getNumbers(), resultCount);
        }
        return resultCount;
    }

    private Map<LottoResult, Integer> initialize(){
        Map<LottoResult, Integer> initialLottoResults = new HashMap<>();
        for (LottoResult value : LottoResult.values()) {
            initialLottoResults.put(value, 0);
        }
        return initialLottoResults;
    }

    private void determineMatchResult(WinningNumber winningNumber, List<Integer> lottoNumbers, Map<LottoResult, Integer> resultCount) {
        int matchCount = winningNumber.calculateMatchCount(lottoNumbers);
        boolean bonusMatched = winningNumber.isBonusMatched(lottoNumbers);

        LottoResult lotteryResult = LottoResult.getLotteryResult(matchCount, bonusMatched);

        resultCount.put(lotteryResult, resultCount.getOrDefault(lotteryResult, 0) + 1);
    }

}
