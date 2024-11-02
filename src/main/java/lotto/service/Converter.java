package lotto.service;

import lotto.constant.WinningCondition;
import lotto.dto.MatchingCountResult;

public class Converter {
    public static MatchingCountResult matchingCounterResultConvert(int winningCount, int bonusCount) {
        if (winningCount < 3) {
            return new MatchingCountResult(WinningCondition.NO_MATCH, 0);
        }
        if (winningCount == 3) {
            return new MatchingCountResult(WinningCondition.MATCH_3, winningCount);
        }
        if (winningCount == 4) {
            return new MatchingCountResult(WinningCondition.MATCH_4, winningCount);
        }
        if (winningCount == 5 && bonusCount == 0) {
            return new MatchingCountResult(WinningCondition.MATCH_5, winningCount);
        }
        if (winningCount == 5 && bonusCount == 1) {
            return new MatchingCountResult(WinningCondition.MATCH_5_BONUS, winningCount);
        }
        return new MatchingCountResult(WinningCondition.MATCH_6, winningCount);
    }
}
