package lotto.dto;

import lotto.constant.WinningCondition;

public record MatchingCountResult(WinningCondition winningCondition, int conditionCount) {
}
