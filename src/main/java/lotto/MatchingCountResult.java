package lotto;

import lotto.constant.WinningCondition;

public record MatchingCountResult(WinningCondition winningCondition, int conditionCount) {
}
