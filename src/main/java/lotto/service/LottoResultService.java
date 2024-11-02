package lotto.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.Lotto;
import lotto.LottoResult;
import lotto.constant.WinningCondition;

public class LottoResultService {
    private final LottoMatchingCounter lottoMatchingCounter;
    private final List<Lotto> purchaseLotto;
    private final String WINNING_COUNT = "winningCount";
    private final String BONUS_COUNT = "bonusCount";

    public LottoResultService(List<Lotto> purchaseLotto, List<Integer> winningNumbers, int bonusNumber) {
        lottoMatchingCounter = new LottoMatchingCounter(winningNumbers, bonusNumber);
        this.purchaseLotto = purchaseLotto;
    }

    public List<LottoResult> getWinningCount() {
        List<LottoResult> lottoResults = new ArrayList<>();
        for (Lotto lotto : purchaseLotto) {
            HashMap<String, Integer> matchingCount = lottoMatchingCounter.countMatchingNumbers(lotto);
            LottoResult lottoResult = converter(matchingCount.get(WINNING_COUNT), matchingCount.get(BONUS_COUNT));
            lottoResults.add(lottoResult);
        }
        return lottoResults;
    }

    private LottoResult converter(int winningCount, int bonusCount) {
        if (winningCount < 3) {
            return new LottoResult(WinningCondition.NO_MATCH, 0);
        }
        if (winningCount == 3) {
            return new LottoResult(WinningCondition.MATCH_3, winningCount);
        }
        if (winningCount == 4) {
            return new LottoResult(WinningCondition.MATCH_4, winningCount);
        }
        if (winningCount == 5 && bonusCount == 0) {
            return new LottoResult(WinningCondition.MATCH_5, winningCount);
        }
        if (winningCount == 5 && bonusCount == 1) {
            return new LottoResult(WinningCondition.MATCH_5_BONUS, winningCount);
        }
        return new LottoResult(WinningCondition.MATCH_6, winningCount);
    }
}
