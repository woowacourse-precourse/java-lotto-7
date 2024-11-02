package lotto.dto;

import lotto.constant.WinningCondition;

public class MatchingCountResult {
    private WinningCondition winningCondition;
    private int conditionCount;

    public MatchingCountResult(WinningCondition winningCondition) {
        this.winningCondition = winningCondition;
        this.conditionCount = 0;
    }

    public WinningCondition getWinningCondition() {
        return winningCondition;
    }

    public int getConditionCount() {
        return conditionCount;
    }

    public void addCount() {
        this.conditionCount++;
    }
}