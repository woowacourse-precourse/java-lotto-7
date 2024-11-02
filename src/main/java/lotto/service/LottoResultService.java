package lotto.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.constant.WinningCondition;
import lotto.dto.LottoResult;
import lotto.dto.MatchingCountResult;
import lotto.model.Lotto;

public class LottoResultService {
    private final LottoMatchingCounter lottoMatchingCounter;
    private final List<Lotto> purchaseLotto;
    private final String WINNING_COUNT = "winningCount";
    private final String BONUS_COUNT = "bonusCount";
    private final int UNIT = 1000;
    private List<MatchingCountResult> matchingCountResults;

    public LottoResultService(List<Lotto> purchaseLotto, List<Integer> winningNumbers, int bonusNumber) {
        lottoMatchingCounter = new LottoMatchingCounter(winningNumbers, bonusNumber);
        this.purchaseLotto = purchaseLotto;
        this.matchingCountResults = new ArrayList<>();
        initMatchingResults();
    }

    private void initMatchingResults() {
        this.matchingCountResults.add(new MatchingCountResult(WinningCondition.MATCH_3));
        this.matchingCountResults.add(new MatchingCountResult(WinningCondition.MATCH_4));
        this.matchingCountResults.add(new MatchingCountResult(WinningCondition.MATCH_5));
        this.matchingCountResults.add(new MatchingCountResult(WinningCondition.MATCH_5_BONUS));
        this.matchingCountResults.add(new MatchingCountResult(WinningCondition.MATCH_6));
    }

    public LottoResult getLottoResult() {
        List<MatchingCountResult> matchingCountResults = getWinningCount();
        double lottoRate = getLottoRate(matchingCountResults);
        return new LottoResult(matchingCountResults, lottoRate);
    }

    public List<MatchingCountResult> getWinningCount() {
        for (Lotto lotto : purchaseLotto) {
            HashMap<String, Integer> matchingCount = lottoMatchingCounter.countMatchingNumbers(lotto);
            MatchingCountResult matchingCountResult = Converter.matchingCounterResultConvert(
                    matchingCount.get(WINNING_COUNT),
                    matchingCount.get(BONUS_COUNT));
            addOrUpdateMatchingCountResult(matchingCountResults, matchingCountResult);
        }

        return matchingCountResults;
    }

    private void addOrUpdateMatchingCountResult(List<MatchingCountResult> matchingCountResults,
                                                MatchingCountResult matchingCountResult) {
        for (int i = 0; i < matchingCountResults.size(); i++) {
            MatchingCountResult existingResult = matchingCountResults.get(i);
            if (existingResult.getWinningCondition().equals(matchingCountResult.getWinningCondition())) {
                existingResult.addCount();
                return;
            }
        }
    }

    private double getLottoRate(List<MatchingCountResult> matchingCountResults) {
        int purchaseAmount = purchaseLotto.size() * UNIT;
        return LottoRateCalculator.calculateReturnOfRate(purchaseAmount, matchingCountResults);
    }
}
