package lotto.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.dto.LottoResult;
import lotto.dto.MatchingCountResult;
import lotto.model.Lotto;

public class LottoResultService {
    private final LottoMatchingCounter lottoMatchingCounter;
    private final List<Lotto> purchaseLotto;
    private final String WINNING_COUNT = "winningCount";
    private final String BONUS_COUNT = "bonusCount";
    private final int UNIT = 1000;

    public LottoResultService(List<Lotto> purchaseLotto, List<Integer> winningNumbers, int bonusNumber) {
        lottoMatchingCounter = new LottoMatchingCounter(winningNumbers, bonusNumber);
        this.purchaseLotto = purchaseLotto;
    }

    public LottoResult getLottoResult() {
        List<MatchingCountResult> matchingCountResults = getWinningCount();
        double lottoRate = getLottoRate(matchingCountResults);
        return new LottoResult(matchingCountResults, lottoRate);
    }

    public List<MatchingCountResult> getWinningCount() {
        List<MatchingCountResult> matchingCountResults = new ArrayList<>();
        for (Lotto lotto : purchaseLotto) {
            HashMap<String, Integer> matchingCount = lottoMatchingCounter.countMatchingNumbers(lotto);
            MatchingCountResult matchingCountResult = Converter.matchingCounterResultConvert(
                    matchingCount.get(WINNING_COUNT),
                    matchingCount.get(BONUS_COUNT));
            matchingCountResults.add(matchingCountResult);
        }
        return matchingCountResults;
    }

    private double getLottoRate(List<MatchingCountResult> matchingCountResults) {
        int purchaseAmount = purchaseLotto.size() * UNIT;
        return LottoRateCalculator.calculateReturnOfRate(purchaseAmount, matchingCountResults);
    }
}
