package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoRule;
import lotto.model.Lottos;

public class LottoMatcher {
    public Map<LottoRule, Integer> calculateMatchResult(Lottos lottos, List<Integer> winNumbers, int bonusNumber) {
        Map<LottoRule, Integer> matchInfo = new HashMap<>();

        for (Lotto lotto : lottos.getLottos()) {
            int matchCount = calculateMatchCount(lotto, winNumbers);
            boolean bonusMatch = isBonusMatch(lotto, bonusNumber, matchCount);
            updateMatchInfo(matchInfo, matchCount, bonusMatch);
        }
        return matchInfo;
    }

    private int calculateMatchCount(Lotto lotto, List<Integer> winNumbers) {
        int matchCount = 0;
        for (Integer winNumber : winNumbers) {
            if (lotto.getNumbers().contains(winNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private boolean isBonusMatch(Lotto lotto, int bonusNumber, int matchCount) {
        return (matchCount == 5) && lotto.getNumbers().contains(bonusNumber);
    }

    private void updateMatchInfo(Map<LottoRule, Integer> matchInfo, int matchCount, boolean bonusMatch) {
        LottoRule rule = LottoRule.getWinInfo(matchCount, bonusMatch);
        matchInfo.put(rule, matchInfo.getOrDefault(rule, 0) + 1);
    }
}
