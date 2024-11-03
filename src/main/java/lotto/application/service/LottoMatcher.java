package lotto.application.service;

import java.util.List;
import lotto.application.service.vo.MatchingInfo;
import lotto.domain.Lotto;
import lotto.domain.WinLotto;

public class LottoMatcher {

    private int SECOND_OR_THIRD_MATCH_COUNT = 5;

    public MatchingInfo checkMatchCount(WinLotto winLotto, Lotto lotto) {
        int matchingCount = winLotto.getLotto().calculateMatchingCount(lotto);
        if (matchingCount != SECOND_OR_THIRD_MATCH_COUNT) {
            return new MatchingInfo(matchingCount, false);
        }
        boolean bonusNumber = isMatchBonusNumber(winLotto.getBonusNumber(), lotto.getNumbers());
        return new MatchingInfo(matchingCount, bonusNumber);
    }

    private boolean isMatchBonusNumber(int bonusNumber, List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number == bonusNumber);
    }
}
